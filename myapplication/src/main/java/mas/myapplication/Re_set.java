package mas.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mas.a13.R;

/**
 * Created by super on 27.05.2017.
 */

public class Re_set extends AppCompatActivity {

    EditText name;
    EditText weight;
    EditText Growth;
    Button bt_set;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_val);
        name = (EditText)findViewById(R.id.editText3);
        weight = (EditText)findViewById(R.id.editText6);
        Growth = (EditText)findViewById(R.id.editGrowth);
        bt_set = (Button)findViewById(R.id.button5);

        bt_set.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(!check_is_string_ok(name))
                {
                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Enter you'r name",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }
                if(!check_gw(weight))
                {
                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Enter you'r weight or write it right",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }
                if(!check_gw(Growth))
                {
                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Enter you'r or write it right",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }


                String nametext = name.getText().toString();
                String weighttext = weight.getText().toString();
                String growthtext = Growth.getText().toString();



                SharedPreferences for_set = getApplicationContext().getSharedPreferences("DATA", 0);
                SharedPreferences.Editor editor = for_set.edit();
                editor.putString("name",nametext);
                editor.putString("weight",weighttext);
                editor.putString("growth",growthtext);
                editor.apply();

                Intent intent = new Intent(getApplicationContext() ,BNA.class);
                startActivity(intent);
            }
        });




    }

    boolean check_gw(EditText sometext)
    {
        if(sometext.getText().toString().isEmpty())
            return false;

        int data = 0;
        data = Integer.parseInt(sometext.getText().toString());
        if(data > 250 || data < 20)
            return false;
        else
            return true;
    }

    boolean check_is_string_ok(EditText sometext)
    {
        if(sometext.getText().toString().isEmpty())
            return false;
        return true;
    }
}
