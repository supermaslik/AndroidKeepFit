package mas.a13;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
//import android.icu.text.SimpleDateFormat;
//import android.icu.util.Calendar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import res.layout.BNA;

import static android.R.attr.button;


public class Set_log extends AppCompatActivity {

    Button way;
    EditText AgeText;
    EditText NameText;
    EditText WeightText;
    EditText GrowthText;
    EditText Text;
    RadioButton r1;
    RadioButton r2;
    Intent intent;
    Spinner my_spinner;
  //  Calendar myCalendar = Calendar.getInstance();



//editGrowth
   // DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

       // @Override
      //  public void onDateSet(DatePicker view, int year, int monthOfYear,
            //                  int dayOfMonth) {
            // TODO Auto-generated method stub
      //      myCalendar.set(Calendar.YEAR, year);
         //   myCalendar.set(Calendar.MONTH, monthOfYear);
         //   myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
         //   updateLabel();
     //   }

  //  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_log);
        way = (Button) findViewById(R.id.button);
        my_spinner = (Spinner)findViewById(R.id.spinner);
        r1 = (RadioButton)findViewById(R.id.radioButton2);
        r2 = (RadioButton)findViewById(R.id.radioButton3);
        r1.setChecked(true);


        SharedPreferences check = getApplicationContext().getSharedPreferences("DATA", 0);
        String my_check = "";
        my_check = check.getString("data", "");

        intent = new Intent(this, BNA.class);
        if(!my_check.isEmpty())
            startActivity(intent);




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.way_yo_want_to_change, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        my_spinner.setAdapter(adapter);
        GrowthText = (EditText)findViewById(R.id.editGrowth);
        AgeText = (EditText)findViewById(R.id.editText2);
        NameText = (EditText)findViewById(R.id.editText3);
        WeightText = (EditText)findViewById(R.id.editText6);
        NameText.setText("");
        AgeText.setFocusable(false);
        AgeText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
              //  DatePickerDialog dpd =  new DatePickerDialog(Set_log.this, date, myCalendar
                //        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                //        //myCalendar.getDatePicker().setMaxDate(System.currentTimeMillis());
                //        myCalendar.get(Calendar.DAY_OF_MONTH));

                long time = 0;
                long dec_time = 3600 * 1000;
                time = System.currentTimeMillis();
                dec_time = dec_time*24;

                for(int i = 0 ; i < 364*3;i++)
                {
                    time-=dec_time;
                }
             //   dpd.getDatePicker().setMaxDate(time);
             //   dpd.show();
            }
        });

        way.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Toast toast;
              /*  try {
                    if(!check_data_value())
                    {
                        toast = Toast.makeText(getApplicationContext(),
                                "Enter you'r age in normal format",
                                Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        return;
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                */
                if(!check_gw(GrowthText)) {

                    toast= Toast.makeText(getApplicationContext(),
                            "Enter you'r growth or write it right",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                    return;
                }
                if(!check_gw(WeightText)) {
                    toast= Toast.makeText(getApplicationContext(),
                            "Enter you'r weightor write it right",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }
                if(check_is_string_ok(AgeText)) {
                    if (check_is_string_ok(NameText)) {
                        //start ac-ty with those values



                        String myFormat = "MM/dd/yy";
                    //    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                    //    String data = sdf.format(myCalendar.getTime());
                        String name = NameText.getText().toString();
                        String  sex = "";
                        String way = my_spinner.getSelectedItem().toString();
                        String weight = WeightText.getText().toString();
                        String growth = GrowthText.getText().toString();
                        if (r1.isChecked())
                            sex =  r1.getText().toString();
                        else if (r2.isChecked())
                            sex =  r2.getText().toString();


                        /*
                        SharedPreferences sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
                        SharedPreferences.Editor ed = sPref.edit();
                        ed.putString("data",data);
                        ed.putString("name",name);
                        ed.putString("sex",sex);
                        ed.putString("way",way);
                        ed.commit();
                        */
                        SharedPreferences settings = getApplicationContext().getSharedPreferences("DATA", 0);
                        SharedPreferences.Editor editor = settings.edit();
                       // editor.putString("data",data);
                        editor.putString("name",name);
                        editor.putString("sex",sex);
                        editor.putString("way",way);
                        editor.putString("weight",weight);
                        editor.putString("growth",growth);
                        editor.putString("quest", "");
                        editor.putInt("score", 0);
                        // Apply the edits!
                        editor.apply();

                        startActivity(intent);

                    } else {
                        toast = Toast.makeText(getApplicationContext(),
                                "Enter you'r name",
                                Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                else
                {
                    toast = Toast.makeText(getApplicationContext(),
                            "Enter you'r age",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });

    }


    @Override
    public void onStart(){
        super.onStart();

        SharedPreferences check = getApplicationContext().getSharedPreferences("DATA", 0);
        String my_check = "";
        my_check = check.getString("data", "");

        if(!my_check.isEmpty()) {
            intent = new Intent(this, BNA.class);
            startActivity(intent);
        }
    }




    boolean check_is_string_ok(EditText sometext)
    {
        if(sometext.getText().toString().isEmpty())
            return false;
        return true;
    }

  //  private void updateLabel() {

     //   String myFormat = "MM/dd/yy"; //In which you need put here
  //      SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

   //     AgeText.setText(sdf.format(myCalendar.getTime()));
   // }
//
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
    /*
    boolean check_data_value() throws ParseException {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        String data = sdf.format(myCalendar.getTime());
        SimpleDateFormat current = new SimpleDateFormat("MM/dd/yy");
        String sdata = current.format("MM/dd/yy");


        Date date = new SimpleDateFormat("MM/dd/yy").parse(data);
        Date sdate = new SimpleDateFormat("MM/dd/yy").parse(sdata);

        if(date.after(sdate))
        return true;
        return false;
    }
    */

}
