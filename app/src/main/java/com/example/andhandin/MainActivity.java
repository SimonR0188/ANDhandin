
package com.example.andhandin;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNavigation;
    private FrameLayout mMainFrame;

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNavigation = (BottomNavigationView) findViewById(R.id.main_navigation);


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

        ArrayList<String> Games = new ArrayList<>();
        Games.add("League Of Legends");
        Games.add("Path Of Exile");
        Games.add("World Of Warcraft");
        Games.add("Counter Strike");
        Games.add("Path of Diablo");


        RecyclerView recyclerView = findViewById(R.id.computerGame);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, Games);
        recyclerView.setAdapter(adapter);

    }

        public void onItemClick (View view,int position){
            Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        }
    }

