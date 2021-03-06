package res.layout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class BNA extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Fragment_Home fragment_home = new Fragment_Home();
                    android.app.FragmentManager fragmentManager1 = getFragmentManager();
                    fragmentManager1.beginTransaction().replace(R.id.contentlayout,
                            fragment_home,
                            fragment_home.getTag()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    Fragment_Goal fragment_goal = new Fragment_Goal();
                    android.app.FragmentManager fragmentManager2 = getFragmentManager();
                    fragmentManager2.beginTransaction().replace(R.id.contentlayout,
                            fragment_goal,
                            fragment_goal.getTag()).commit();
                    return true;
                case R.id.navigation_notifications:
                    Fragment_work_place fragment_work_place = new Fragment_work_place();
                    android.app.FragmentManager fragmentManager3 = getFragmentManager();
                    fragmentManager3.beginTransaction().replace(R.id.contentlayout,
                            fragment_work_place,
                            fragment_work_place.getTag()).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bn);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String restoredText = prefs.getString("data", null);

        Fragment_Home fragment_home = new Fragment_Home();
        android.app.FragmentManager fragmentManager1 = getFragmentManager();
        fragmentManager1.beginTransaction().replace(R.id.contentlayout,
                fragment_home,
                fragment_home.getTag()).commit();

    }

}
