package com.example.myapplication234;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.bottomNavigationView);

        menu.setOnNavigationItemSelectedListener(this);
        menu.setSelectedItemId(R.id.timetable);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.timetable:
                loadFragment(TimetableFragment.newInstance());
                return true;
            case R.id.bars:
                loadFragment(BarsFragment.newInstance());
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frag_container,fragment);
        ft.commit();
    }
}