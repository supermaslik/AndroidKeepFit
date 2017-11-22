package res.layout;


import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import mas.a13.R;

import static android.support.v7.appcompat.R.id.text;
import static mas.a13.R.id.container;

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
        TextView NameOfUser = (TextView)view.findViewById(R.id.textView3);
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
        String Name = "";
        SharedPreferences settings = this.getActivity().getSharedPreferences("DATA", 0);
        weight= settings.getString("weight", "");
        sex = settings.getString("sex", "");
        growth = settings.getString("growth", "");
        score = settings.getInt("score",0);
        Name = settings.getString("name","");
        NameOfUser.setText(Name);
        mytext.setText("Weight = "+ weight);
        growth_text.setText("Growth = "+ growth);
        Score_text.setText("Score = " +score);
        int w = Integer.parseInt(weight);
        check_weight(uner_text);

        return view;
    }

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
