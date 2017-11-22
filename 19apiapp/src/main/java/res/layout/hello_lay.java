package res.layout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import mas.a13.R;
import mas.a13.Set_log;

/**
 * Created by super on 31.05.2017.
 */

public class hello_lay extends AppCompatActivity {



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
            sometext = "nobody";


        mytext.setText("Hello in our application, " + sometext);



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Set_log.class);
                startActivity(intent);
            }
        }, 3000);

    }





}
