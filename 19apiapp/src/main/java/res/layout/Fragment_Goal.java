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
import android.widget.TextView;

import mas.a13.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Goal extends Fragment {


    public Fragment_Goal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__goal, container, false);
        Button button = (Button)view.findViewById(R.id.Button_re_choose_ygoal);
        final TextView textView = (TextView) view.findViewById(R.id.textView7);
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


            }
        });

        return view;
    }

}
