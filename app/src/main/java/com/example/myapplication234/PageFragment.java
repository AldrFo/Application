package com.example.myapplication234;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import javax.security.auth.Subject;

//Фрагмент, отвечающий за содержание каждого дня недели
public class PageFragment extends Fragment {

    public static final String ARG_PAGE_NUMBER = "arg_page_number";

    public static final String LIFECYCLE_LOG = "lifecycle_log";

    //страница, на которой находится PageFragment
    private int page;

    private RecyclerView recyclerView;

    //лист расписания дня
    private ArrayList<EduSubject> timetable = new ArrayList<>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onAttach()====" + " " + page);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onCreate()====" + " " + page);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onCreateView()====" + " " + page);

        View v = inflater.inflate(R.layout.fragment_page, container, false);

        recyclerView = v.findViewById(R.id.recyclerView);

        SubjectAdapter.OnSubjectClickListener subjectClickListener = new SubjectAdapter.OnSubjectClickListener() {
            @Override
            public void onSubjectClick(EduSubject s, int pos) {
                Intent intent = new Intent(getContext(),ConfigureSubjectActivity.class);
                startActivity(intent);
            }
        };
        SubjectAdapter subjectAdapter = new SubjectAdapter(getContext(),timetable, subjectClickListener);

        page = getArguments().getInt(ARG_PAGE_NUMBER);

        recyclerView.setAdapter(subjectAdapter);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onStart()===="+ " " + page);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onResume()===="+ " " + page);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onPause()===="+ " " + page);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onStop()===="+ " " + page);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onDestroyView()===="+ " " + page);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onDestroy()===="+ " " + page);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LIFECYCLE_LOG,"pageFragment: ====onDetach()===="+ " " + page);
    }

    private void addSubjectsToList(EduSubject[] subjects){
        for(int i = 0;i<subjects.length;i++){
            timetable.add(subjects[i]);
        }
    }

    public static PageFragment newInstance(int page){
        PageFragment pageFragment = new PageFragment();
        Log.d(LIFECYCLE_LOG,"new instance PageFragment");
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE_NUMBER,page);
        pageFragment.setArguments(arguments);
        switch (page){
            case 0:
            case 1:
                pageFragment.addSubjectsToList(WeekTimetable.pn);
                break;
            case 2:
                pageFragment.addSubjectsToList(WeekTimetable.vt);
                break;

        }

        return pageFragment;
    }
}