package language.com.clp;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Home_online extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_online);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(MenuItem item) {
               Fragment selectedfragment=null;
               switch (item.getItemId())
               {
                   case R.id.action_category:
                       selectedfragment=CategoryFragment.newInstance();
                       break;
                   case R.id.action_ranking:
                       selectedfragment=RankingFragment.newInstance();
                       break;



               }
                 FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                 transaction.replace(R.id.frame_layout,selectedfragment);
                 transaction.commit();
                  return true ;


                        

                    }
                });
        setDefaultFragment();

    }

    private void setDefaultFragment() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,CategoryFragment.newInstance());
        transaction.commit();

    }
}


