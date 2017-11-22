package res.layout;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import mas.a13.R;

import static mas.a13.R.id.container;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Goal extends Fragment {


    public Fragment_Goal() {
        // Required empty public constructor
    }

    RadioButton rad_normal;
    RadioButton rad_hard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__goal, container, false);
        Button button = (Button)view.findViewById(R.id.Button_re_choose_ygoal);
        final TextView textView = (TextView) view.findViewById(R.id.textView7);
        rad_normal = (RadioButton)view.findViewById(R.id.radioButton20);
        rad_hard = (RadioButton)view.findViewById(R.id.radioButton21);
        rad_normal.setOnClickListener(listener);
        rad_hard.setOnClickListener(listener);

        SharedPreferences when_create = getActivity().getSharedPreferences("DATA", 0);
        String lvl = when_create.getString("lvl","");
        if(lvl.equals("normal"))
            rad_normal.setChecked(true);
        else if(lvl.equals("hard"))
            rad_hard.setChecked(true);


        String way = "";
        SharedPreferences settings = this.getActivity().getSharedPreferences("DATA", 0);
        way= settings.getString("way", "");
        textView.setText("You main goal is "+way);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                AlertDialog.Builder builderSingle = new AlertDialog.Builder( getActivity());
                builderSingle.setTitle("Select you'r goal :");


                final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.way_yo_want_to_change, android.R.layout.simple_spinner_item);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = (String) adapter.getItem(which);

                        SharedPreferences settings = getActivity().getSharedPreferences("DATA", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("way",strName);
                        // Apply the edits!
                        editor.apply();
                        textView.setText("You main goal is "+strName);

                        AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
                        builderInner.setMessage(strName);
                        builderInner.setTitle("Your Selected Item is");
                        builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which) {
                                dialog.dismiss();
                            }
                        });
                        builderInner.show();
                    }
                });
                builderSingle.show();

                SharedPreferences settings = getActivity().getSharedPreferences("DATA", 0);
                String MyWay = settings.getString("way","");
                if(MyWay.equals("My Own"))
                {
                    Toast toast = Toast.makeText(getContext(),"My Own", Toast.LENGTH_LONG);
                    toast.show();
                   // String[] array = getActivity().getResources().getStringArray(R.array.MyOwn);
                }

               // SharedPreferences settings = getApplicationContext().getSharedPreferences("DATA", 0);
              //  SharedPreferences.Editor editor = settings.edit();
            }
        });

        return view;
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("DATA", 0);
            SharedPreferences.Editor editor = settings.edit();
            switch (v.getId())
            {
                case R.id.radioButton20:

                    editor.putString("lvl","normal");
                    editor.apply();
                    break;
                case R.id.radioButton21:
                    editor.putString("lvl","hard");
                    editor.apply();
                    break;
                default:
                    editor.apply();
                    break;
            }
        }
    };
}
