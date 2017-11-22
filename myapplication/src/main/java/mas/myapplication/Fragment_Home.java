package mas.myapplication;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mas.a13.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Home extends Fragment{


    public Fragment_Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.home, container, false);
        final TextView mytext = (TextView) view.findViewById(R.id.textView11);
        TextView uner_text= (TextView)view.findViewById(R.id.textView8);
        TextView growth_text= (TextView)view.findViewById(R.id.Growth_text);
        TextView Score_text= (TextView)view.findViewById(R.id.Score_text);
        Button re_button = (Button)view.findViewById(R.id.re_button);

        re_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Re_login re_login = new Re_login();
                android.app.FragmentManager fragmentManager2 = getFragmentManager();
                fragmentManager2.beginTransaction().replace(R.id.contentlayout,
                        re_login,
                        re_login.getTag()).commit();

            }});

        String sex = "";
        String weight = "";
        String growth = "";
        Integer score = 0;
        SharedPreferences settings = this.getActivity().getSharedPreferences("DATA", 0);
        weight= settings.getString("weight", "");
        sex = settings.getString("sex", "");
        growth = settings.getString("growth", "");
        score = settings.getInt("score",0);
        mytext.setText("Weight = "+ weight);
        growth_text.setText("Growth = "+ growth);
        Score_text.setText("Score = " +score);
        int w = Integer.parseInt(weight);
        /*
        if(sex.equals("male")  &&  w <= 79)
        {
            String text = "Its ok for men having weight less then 79";
            uner_text.setText(text);
        }
        else if(sex.equals("male") &&  w > 79)
        {
            String text = "You have troubles with health, its danger for everybody be overweight";
            uner_text.setText(text);
        }
        else if(sex.equals("female") &&  w <= 56)
        {
            String text = "Its ok for girl having weight less then 56";
            uner_text.setText(text);
        }
        else if(sex.equals("female") &&  w > 56) {
            String text = "You have troubles with health, its danger for everybody be overweight";
            uner_text.setText(text);
    }
        else
        {
            uner_text.setText("!"+sex+"!");
        }
        */
        check_weight(uner_text);

       // Button buttondec = (Button)view.findViewById(R.id.button6);
       // Button buttoninc = (Button)view.findViewById(R.id.button7);
        /*
        buttondec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences somesettings = getActivity().getSharedPreferences("DATA", 0);
                String weight_in= somesettings.getString("weight", "");
                int a = Integer.parseInt(weight_in);
                a--;
                String some = Integer.toString(a);
                SharedPreferences settings = getActivity().getSharedPreferences("DATA", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("weight",some);
                // Apply the edits!
                editor.apply();
                mytext.setText("Weight = "+text);

                String sex = "";
                String weight = "";
                weight= settings.getString("weight", "");
                sex = settings.getString("sex", "");
                int w = Integer.parseInt(weight);
                if(sex.equals("male") &&  w <= 79)
                {
                    String text = "its ok for men having weight less then 79";
                    mytext.setText("Weight = "+text);
                }
                else if(sex.equals("male") &&  w > 79)
                {
                    String text = "you have troubles with health, its danger for everybody be overweight";
                    mytext.setText("Weight = "+text);
                }
                else if(sex.equals("female") &&  w <= 56)
                {
                    String text = "its ok for girl having weight less then 56";
                    mytext.setText("Weight = "+text);
                }
                else if(sex.equals("female") &&  w > 56) {
                    String text = "you have troubles with health, its danger for everybody be overweight";
                    mytext.setText("Weight = "+text);
                }
            }
        });
        buttoninc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences somesettings = getActivity().getSharedPreferences("DATA", 0);
                String weight_in= somesettings.getString("weight", "");
                int a = Integer.parseInt(weight_in);
                a++;
                String some = Integer.toString(a);
                SharedPreferences settings = getActivity().getSharedPreferences("DATA", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("weight",some);
                // Apply the edits!
                editor.apply();
                mytext.setText("Weight = "+text);

                String sex = "";
                String weight = "";
                weight= settings.getString("weight", "");
                sex = settings.getString("sex", "");
                int w = Integer.parseInt(weight);
                if(sex.equals("male") &&  w <= 79)
                {
                    String text = "its ok for men having weight less then 79";
                    mytext.setText("Weight = "+text);
                }
                else if(sex.equals("male") &&  w > 79)
                {
                    String text = "you have troubles with health, its danger for everybody be overweight";
                    mytext.setText("Weight = "+text);
                }
                else if(sex.equals("female") &&  w <= 56)
                {
                    String text = "its ok for girl having weight less then 56";
                    mytext.setText("Weight = "+text);
                }
                else if(sex.equals("female") &&  w > 56) {
                    String text = "you have troubles with health, its danger for everybody be overweight";
                    mytext.setText("Weight = "+text);
                }
            }
        });
        */
        return view;
    }

    /*
    private void ret_met()
    {
        String sex = "";
        String weight = "";
        SharedPreferences settings = this.getActivity().getSharedPreferences("DATA", 0);
        weight= settings.getString("weight", "");
        sex = settings.getString("sex", "");
        int w = Integer.parseInt(textView.getText().toString());
        if(sex == "male" &&  w <= 79)
        {
            text.setText("its ok for men having weight less then 79");
        }
        else if(sex == "male" &&  w > 79)
        {
            text.setText("you have troubles with health, its danger for everybody be overweight");
        }
        else if(sex == "female" &&  w <= 56)
        {
            text.setText("its ok for girl having weight less then 56");
        }
        else if(sex == "female" &&  w > 56)
        {
            text.setText("you have troubles with health, its danger for everybody be overweight");
        }
    }
    */

    private void check_weight( TextView uner_text )
        {

        SharedPreferences settings = this.getActivity().getSharedPreferences("DATA", 0);
        String weight= settings.getString("weight", "");
        String sex = settings.getString("sex", "");
        String growth = settings.getString("growth", "");
        int w = Integer.parseInt(weight);
        int g = Integer.parseInt(growth);

            g = g - 110;
        if(sex.equals("female"))
        {
            if(g == w)
            {
                uner_text.setText("You have unreal healthy body!");
                return;
            }
            else if(g+2 >= w && g-2 <=w)
            {
                //идеальный вес
                uner_text.setText("You have unreal healthy body!");
                return;
            }
            else if(g+10 >= w && g-10 <=w)
            {
                //норма
                uner_text.setText("You have normal body!");
                return;
            }

            else
            {
                //плохой вес
                uner_text.setText("You have troubles with health!");
                return;
            }

        }
        else
        {
            if(g+2 >= w && g-2 <=w)
            {
                //идеальный вес
                uner_text.setText("You have unreal healthy body!");
                return;
            }
            else if(g+10 >= w && g-10 <=w)
            {
                //норма
                uner_text.setText("You have normal body!");
                return;

            }
            else
            {
                //плохой вес
                uner_text.setText("You have troubles with health!");
                return;
            }
        }

        }


}
