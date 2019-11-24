package com.example.andhandin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeScreen extends AppCompatActivity {

    private BottomNavigationView mMainNavigation;
    private FrameLayout mMainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = findViewById(R.id.main_frame);
        mMainNavigation = findViewById(R.id.main_navigation);


        mMainNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

                switch (menuItem.getItemId()) {

                    case R.id.navigation_home:
                        mMainNavigation.setItemBackgroundResource(R.color.colorPrimary);
                        selectedFragment = new Home_Fragment();
                        break;
                    case R.id.navigation_content:
                        mMainNavigation.setItemBackgroundResource(R.color.colorAccent);
                        selectedFragment = new Content_Fragment();
                        break;
                    case R.id.navigation_notes:
                        mMainNavigation.setItemBackgroundResource(R.color.colorPrimaryDark);
                        selectedFragment = new Notes_Fragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, selectedFragment).commit();
                return true;
            }
        });

    }

}