package res.layout;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import mas.a13.R;

/**
 * Created by super on 08.06.2017.
 */

public class AlarmMen extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context,"Alarm Raised",Toast.LENGTH_SHORT).show();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent1 = new Intent();

        //intent1.setClassName("mas.a13","res.layout.hello_lay");
        intent1.setClassName("mas.a13","res.layout.BNA");
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent= PendingIntent.getActivity(context,0,intent1,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.iconofnot);
        builder.setContentTitle("Keep fit");
        builder.setContentText("It's time to move on with your health (from alarm)");
        builder.setPriority(Notification.PRIORITY_MAX);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setLights(0x0000FF,3000,2000);
        builder.setContentIntent(pendingIntent);
        notificationManager.notify(56, builder.build());
    }
}

