package res.layout;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import mas.a13.R;
import mas.a13.Set_log;

/**
 * A simple {@link Fragment} subclass.
 */
public class Re_login extends Fragment {


    public Re_login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.re_login, container, false);
        Button Sing = (Button) view.findViewById(R.id.button3);
        Button set = (Button) view.findViewById(R.id.button4);


        Sing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Are you sure, you will lost you'r values?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity() ,Set_log.class);
                                SharedPreferences settings = getActivity().getSharedPreferences("DATA", 0);
                                SharedPreferences.Editor editor = settings.edit();
                                editor.putString("data","");
                                editor.putString("name","");
                                editor.putString("sex","");
                                editor.putString("way","");
                                editor.putString("weight","");
                                editor.putString("growth","");
                                editor.putString("quest", "");
                                editor.putString("lvl", "");
                                editor.putInt("score", 0);
                                // Apply the edits!
                                editor.apply();
                                startActivity(intent);
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();
            }});


        set.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() ,Re_set.class);

                startActivity(intent);

            }});


        return view;
    }
    @Override
    public void onStart(){
        super.onStart();

        SharedPreferences some = getActivity().getSharedPreferences("DATA", 0);
        String name = some.getString("name","");
        if(name.equals(""))
        {
            Intent intent = new Intent(getActivity() ,Set_log.class);
            startActivity(intent);
        }
    }
}
