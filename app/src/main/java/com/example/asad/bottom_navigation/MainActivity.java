package com.example.asad.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Fragment myfragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ID of bottom navigation to select an Items
        BottomNavigationView bottomvaigation = findViewById(R.id.bottomNavigationView);

        //This is by default show a fragment when we open a app
        myfragment = new homeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fame_layout,myfragment).commit();
        //This is bottomnavigation setonClckListner
        bottomvaigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        myfragment = new homeFragment();
                        break;
                    case R.id.navigation_search:
                        myfragment = new ChatFragment();
                        break;
                    case R.id.navigation_chat:
                        myfragment = new SearchFragment();
                        break;
                    default:
                        return false;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fame_layout,myfragment).commit();
                return true;
            }
        });


    }


}
