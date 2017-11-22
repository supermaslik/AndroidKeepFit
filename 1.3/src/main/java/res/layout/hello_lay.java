package res.layout;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.widget.TextView;

import mas.a13.R;
import mas.a13.Set_log;

/**
 * Created by super on 31.05.2017.
 */

public class hello_lay extends AppCompatActivity {


    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    //Hello in our application
    TextView mytext;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_lay);

        String sometext = "";
        mytext = (TextView)findViewById(R.id.textView);
        SharedPreferences settings = getApplication().getSharedPreferences("DATA", 0);
        sometext = settings.getString("name","");
        if(sometext.isEmpty())
            sometext = "user";


        mytext.setText("Hello in our application, " + sometext);

        alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, hello_lay.class);
        alarmIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, 0);

// Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 30);

// setRepeating() lets you specify a precise custom interval--in this case,
// 20 minutes.
       // alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
     //           1000 * 60 * 20, alarmIntent);

        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                          1000 * 60, alarmIntent);




        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Set_log.class);
                startActivity(intent);
            }
        }, 3000);


        NotificationCompat.Builder  MyB = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.iconofnot)
                .setContentTitle("Keep fit")
                .setContentText("Yor health cant wait!");
        // Creates an explicit intent for an Activity in your app

        Intent resultIntent = new Intent(this, this.getClass());

        int mId = 0;
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(this.getClass());
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        MyB.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(mId, MyB.build());



        // alarm - is cycle notification, and i am create this here
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        Intent neintent = new Intent(this, AlarmMen.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, neintent, 0);

        Calendar mcalendar = Calendar.getInstance();
        mcalendar.setTimeInMillis(System.currentTimeMillis());
        //mcalendar.set(Calendar.HOUR_OF_DAY, 00);
        long timeToStart = mcalendar.getTimeInMillis();
        if(System.currentTimeMillis() < timeToStart){
            timeToStart += 24 * 60 * 60 * 1000; // one day
        }
        //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, timeToStart, AlarmManager.INTERVAL_DAY, alarmIntent);
        //alarmManager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime() + 60*60* 1000, alarmIntent);

        // Wake up the device to fire the alarm in 60*6 minutes, and every 60*6  minutes after that:
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_DAY,
                AlarmManager.INTERVAL_DAY, alarmIntent);
    }





}
