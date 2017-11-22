package res.layout;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import mas.a13.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_work_place extends Fragment {

    public Fragment_work_place() {
        // Required empty public constructor
    }

    static boolean choose_way = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_work_place, container, false);

        Button button = (Button)v.findViewById(R.id.Get_new_q_button);
        Button done_button = (Button)v.findViewById(R.id.button2);
        final TextView textView = (TextView)v.findViewById(R.id.q_text);
        final ImageView myimage = (ImageView)v.findViewById(R.id.imageView);

        SharedPreferences when_create = getActivity().getSharedPreferences("DATA", 0);
        String quest= when_create.getString("quest", "");
        String sex_of_person = when_create.getString("sex","");
        final String lvl = when_create.getString("lvl","");

        if(quest.isEmpty())
        {
            textView.setText("All quests done, try to get some new.");
            myimage.clearAnimation();
            myimage.setVisibility(View.INVISIBLE);
        }
        else
        {
            textView.setText(quest);
            String quest_text = textView.getText().toString();
            String arr[] = quest_text.split(" ", 2);
            String firstWord = arr[0];

            if(firstWord.equals("Beams."))
            {
                if(sex_of_person.equals("male"))
                    myimage.setImageResource(R.drawable.brus);
                else
                    myimage.setImageResource(R.mipmap.brus_for_wo);
            }
            if(firstWord.equals("Dumbbells."))
            {
                if(sex_of_person.equals("male"))
                    myimage.setImageResource(R.mipmap.girya2);
                else if(sex_of_person.equals("female"))
                    myimage.setImageResource(R.mipmap.gantel_for_w);
            }
            if(firstWord.equals("Pull-ups."))
            {
                if(sex_of_person.equals("male"))
                    myimage.setImageResource(R.drawable.pod);
                else
                    myimage.setImageResource(R.mipmap.pod_for_wo);
            }
            if(firstWord.equals("Push-ups."))
            {
                if(sex_of_person.equals("male"))
                    myimage.setImageResource(R.mipmap.otzh);
                else if(sex_of_person.equals("female"))
                    myimage.setImageResource(R.mipmap.otzh_for_wo);
            }
            if(firstWord.equals("Sit-ups."))
            {
                if(sex_of_person.equals("male"))
                    myimage.setImageResource(R.drawable.presydaniya);
                else
                    myimage.setImageResource(R.mipmap.pres_for_wo);
            }

            choose_way = true;
            myimage.setVisibility(View.VISIBLE);
        }
        done_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textstr = textView.getText().toString();
                if(!choose_way)
                {
                    Toast toast = Toast.makeText( getActivity().getApplicationContext(),
                            "You cant just increase you'r score, get quest",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    myimage.setVisibility(View.INVISIBLE);
                }
                else {


                    SharedPreferences take_score = getActivity().getSharedPreferences("DATA", 0);
                    int score = take_score.getInt("score", 0);
                    score+=5;

                    SharedPreferences.Editor editor = take_score.edit();
                    editor.putInt("score",  score);
                    editor.putString("quest","");
                    editor.apply();
                    myimage.clearAnimation();
                    myimage.setVisibility(View.INVISIBLE);
                   // myimage.setVisibility(View.VISIBLE);
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            "Nice! Score  = "+Integer.toString(score)+"",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                    textView.setText("You done with all you want to done with. To get new quest, press button \"get new quest\" ");
                    choose_way = false;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences settings = getActivity().getSharedPreferences("DATA", 0);
                String way= settings.getString("way", "");
                if(textView.getText().toString().equals("You done with all you want to done with. To get new quest, press button \"get new quest\" ") ||
                        textView.getText().toString().equals("All quests done, try to get some new.")) {

                }
                else{
                    int MyScore = settings.getInt("score",0);
                    MyScore-=2;
                    if(MyScore < 0)
                        MyScore = 0;

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("score",  MyScore);
                    editor.apply();

                    if(MyScore !=0) {
                        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                "Fine! You have not done with quest, -2 points from you'r score!",
                                Toast.LENGTH_LONG);
                        toast.show();
                    }

                }
                while(true) {
                    if (way.equals("Hands")) {
                        String[] array;
                        if(lvl.equals("normal")) {
                            array = getActivity().getResources().getStringArray(R.array.Hands);
                        }
                        else
                        {
                            array = getActivity().getResources().getStringArray(R.array.Hands2);
                        }
                        String randomStr = array[new Random().nextInt(array.length)];
                        if(textView.getText().toString().equals(randomStr))
                            continue;
                        textView.setText(randomStr);
                        break;
                    }
                    if (way.equals("Chest")) {
                        String[] array;
                        if(lvl.equals("normal")) {
                            array = getActivity().getResources().getStringArray(R.array.Chest);
                        }
                        else
                        {
                            array = getActivity().getResources().getStringArray(R.array.Chest2);
                        }
                        String randomStr = array[new Random().nextInt(array.length)];
                        if(textView.getText().toString().equals(randomStr))
                            continue;
                        textView.setText(randomStr);
                        break;
                    }
                    if (way.equals("Legs")) {
                        String[] array;
                        if(lvl.equals("normal")) {
                            array = getActivity().getResources().getStringArray(R.array.Legs);
                        }
                        else
                        {
                            array = getActivity().getResources().getStringArray(R.array.Legs2);
                        }
                        String randomStr = array[new Random().nextInt(array.length)];
                        if(textView.getText().toString().equals(randomStr))
                            continue;
                        textView.setText(randomStr);
                        break;
                    }
                    if (way.equals("Complex")) {
                        String[] array;
                        if(lvl.equals("normal")) {
                            array = getActivity().getResources().getStringArray(R.array.Complex);
                        }
                        else
                        {
                            array = getActivity().getResources().getStringArray(R.array.Complex2);
                        }
                        String randomStr = array[new Random().nextInt(array.length)];
                        if(textView.getText().toString().equals(randomStr))
                            continue;
                        textView.setText(randomStr);
                        break;
                    }
                    if (way.equals("Back")) {
                        String[] array;
                        if(lvl.equals("normal")) {
                            array = getActivity().getResources().getStringArray(R.array.Back);
                        }
                        else
                        {
                            array = getActivity().getResources().getStringArray(R.array.Back2);
                        }
                        String randomStr = array[new Random().nextInt(array.length)];
                        if(textView.getText().toString().equals(randomStr))
                            continue;
                        textView.setText(randomStr);
                        break;
                    }
                }

                String quest_text = textView.getText().toString();
                myimage.clearAnimation();
                SharedPreferences when_create = getActivity().getSharedPreferences("DATA", 0);
                String sex_of_person = when_create.getString("sex","");


                String arr[] = quest_text.split(" ", 2);
                String firstWord = arr[0];

                if(firstWord.equals("Beams."))
                {
                    if(sex_of_person.equals("male"))
                        myimage.setImageResource(R.drawable.brus);
                    else
                        myimage.setImageResource(R.mipmap.brus_for_wo);
                }
                if(firstWord.equals("Dumbbells."))
                {
                    if(sex_of_person.equals("male"))
                        myimage.setImageResource(R.mipmap.girya2);
                    else if(sex_of_person.equals("female"))
                        myimage.setImageResource(R.mipmap.gantel_for_w);
                }
                if(firstWord.equals("Pull-ups."))
                {
                    if(sex_of_person.equals("male"))
                        myimage.setImageResource(R.drawable.pod);
                    else
                        myimage.setImageResource(R.mipmap.pod_for_wo);
                }
                if(firstWord.equals("Push-ups."))
                {
                    if(sex_of_person.equals("male"))
                        myimage.setImageResource(R.mipmap.otzh);
                    else if(sex_of_person.equals("female"))
                        myimage.setImageResource(R.mipmap.otzh_for_wo);
                }
                if(firstWord.equals("Sit-ups."))
                {
                    if(sex_of_person.equals("male"))
                        myimage.setImageResource(R.drawable.presydaniya);
                    else
                        myimage.setImageResource(R.mipmap.pres_for_wo);
                }
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("quest", quest_text);
                editor.apply();
                choose_way = true;
                myimage.setVisibility(View.VISIBLE);

            }
        });



        return v;
    }

}
