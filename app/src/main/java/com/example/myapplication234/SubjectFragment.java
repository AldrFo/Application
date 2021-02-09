package com.example.myapplication234;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

// фрагмент учебного предмета
public class SubjectFragment extends Fragment{

    public static final String NUM_OF_CLASSROOM_EXTRA = "classroom";
    public static final String DESCRIPTION_EXTRA = "description";
    public static final String TEACHER_NAME_EXTRA = "teacher name";

    private EduSubject subject;
    private int color;

    private boolean result;

    private TextView eduSubjectName;
    private TextView classroom;
    private TextView teacherName;
    private TextView description;
    private TextView typeOfSubject;
    private TextView time;

    private LinearLayout layout;

    public SubjectFragment(EduSubject subject){
        this.subject = subject;

        switch (subject.getTypeOfSubject()){
            case EduSubject.LECTURE:
                color = R.color.colorAccent;
                break;
            case EduSubject.SEMINAR:
                color = R.color.colorPrimary;
                break;
        }
        result = false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_subject, container, false);

        layout = v.findViewById(R.id.subject_main_layout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ConfigureSubjectActivity.class);
                intent.putExtra(NUM_OF_CLASSROOM_EXTRA, subject.getClassroom());
                intent.putExtra(DESCRIPTION_EXTRA, subject.getDescription());
                intent.putExtra(TEACHER_NAME_EXTRA, subject.getTeacherName());
                startActivityForResult(intent, 2);
            }
        });

        eduSubjectName = v.findViewById(R.id.subject_name);
        classroom = v.findViewById(R.id.num_of_classroom);
        teacherName = v.findViewById(R.id.teacher_name);
        description = v.findViewById(R.id.description);
        time = v.findViewById(R.id.time);
        typeOfSubject = v.findViewById(R.id.type_of_subject);

        eduSubjectName.setText(subject.getEduSubjectName());
        typeOfSubject.setText(subject.getTypeNameOfSubject());
        classroom.setText(subject.getClassroom());
        teacherName.setText(subject.getTeacherName());
        description.setText(subject.getDescription());
        time.setText(subject.getTime());
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    //изменяем данные о учебном предмете, после возращения из активности редактирования предмета
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == 1){
            try {
                Log.d("subject",data.getStringExtra(DESCRIPTION_EXTRA));
                description.setText(data.getStringExtra(DESCRIPTION_EXTRA));
                teacherName.setText(data.getStringExtra(TEACHER_NAME_EXTRA));
                classroom.setText(data.getStringExtra(NUM_OF_CLASSROOM_EXTRA));
                result = true;
            }catch (NullPointerException e){
                Log.d("subject","error");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static SubjectFragment newInstance(EduSubject eS){
        return new SubjectFragment(eS);
    }
}