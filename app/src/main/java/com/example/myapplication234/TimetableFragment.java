package com.example.myapplication234;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


public class TimetableFragment extends Fragment {

    private FloatingActionButton add;
    private ViewPager viewPager;
    private TabLayout tabs;

    private PagerAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onAttach()====");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onCreate()====");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_timetable, container, false);

        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onCreateView====");

        add = v.findViewById(R.id.floatingActionButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Это не работает",Toast.LENGTH_LONG).show();
            }
        });

        viewPager = v.findViewById(R.id.viewpager);
        adapter = new MyFragmentPagerAdapter(getFragmentManager(),getContext());
        viewPager.setAdapter(adapter);

        tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onStart()====");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onResume()====");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onPause()====");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onStop()====");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onDestroyView()====");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onDestroy()====");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(PageFragment.LIFECYCLE_LOG,"TimetableFragment: ====onDetach()====");
    }

    public static TimetableFragment newInstance(){
        return new TimetableFragment();
    }
}