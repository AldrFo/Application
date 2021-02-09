package com.example.myapplication234;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

//Фрагмент, отвечающий за содержание каждого дня недели
public class PageFragment extends Fragment {

    public static final String ARG_PAGE_NUMBER = "arg_page_number";

    public static final String LIFECYCLE_LOG = "lifecycle_log";

    //страница, на которой находится PageFragment
    private int page;

    private LinearLayout layout;

    //лист расписания дня
    private ArrayList<EduSubject> timetable = new ArrayList<>();

    public PageFragment(){
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(LIFECYCLE_LOG,"====onAttach()====");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LIFECYCLE_LOG,"====onCreate()====");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LIFECYCLE_LOG,"====onCreateView()====");

        View v = inflater.inflate(R.layout.fragment_page, container, false);

        page = getArguments().getInt(ARG_PAGE_NUMBER);
        TextView pageText = v.findViewById(R.id.page);
        pageText.setText("Страница - " + page);

        layout = v.findViewById(R.id.subjects_layout);

        //добавление учебных предметов в лист дня
        switch(page){
            case 0:
                timetable.add(WeekTimetable.pn[0]);
                break;
            case 1:
                setTimetable(WeekTimetable.pn);
                break;
            case 2:
                setTimetable(WeekTimetable.vt);
                break;
            //Остальные кейсы пропишу потом, как только разберусь с работой станиц
        }

        Log.d(LIFECYCLE_LOG,"page = "+ page +" размер листа = " + timetable.size());
        addSubjectFragments(timetable);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LIFECYCLE_LOG,"====onStart()====");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LIFECYCLE_LOG,"====onResume()====");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LIFECYCLE_LOG,"====onPause()====");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LIFECYCLE_LOG,"====onStop()====");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LIFECYCLE_LOG,"====onDestroyView()====");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LIFECYCLE_LOG,"====onDestroy()====");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LIFECYCLE_LOG,"====onDetach()====");
    }

    public static PageFragment newInstance(int page){
        PageFragment pageFragment = new PageFragment();
        Log.d(LIFECYCLE_LOG,"new instance: " + page);
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE_NUMBER,page);
        pageFragment.setArguments(arguments);

        return pageFragment;
    }

    //метод для добавления фрагмента учебного предмета в лэйаут
    public void addSubjectFragment(SubjectFragment subjectFragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(layout.getId(),subjectFragment);
        fragmentTransaction.commit();
    }

    //метод для добавления листа фрагментов в лэйаут
    public void addSubjectFragments(ArrayList<EduSubject> eduSubjects){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for(int i = 0; i < eduSubjects.size();i++){
            fragmentTransaction.add(layout.getId(),new SubjectFragment(eduSubjects.get(i)));
        }
        fragmentTransaction.commit();
    }

    //добавление расписания в лист расписания дня
    public void setTimetable(EduSubject[] subjects){
        for (int i =0;i<subjects.length;i++){
            subjects[i].setDescription("Это лист " + page);
            timetable.add(subjects[i]);
        }
    }
}