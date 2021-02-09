package com.example.myapplication234;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//активность для редактирования данных о предмете
public class ConfigureSubjectActivity extends AppCompatActivity {

    private EditText numOfClassRoom;
    private EditText description;
    private EditText teacherName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_subject);

        numOfClassRoom = findViewById(R.id.num_of_classroom_edit_text);
        description = findViewById(R.id.description_edit_text);
        teacherName = findViewById(R.id.teacher_name_edit_text);

        Intent intent = getIntent();

        numOfClassRoom.setText(intent.getStringExtra(SubjectFragment.NUM_OF_CLASSROOM_EXTRA));
        description.setText(intent.getStringExtra(SubjectFragment.DESCRIPTION_EXTRA));
        teacherName.setText(intent.getStringExtra(SubjectFragment.TEACHER_NAME_EXTRA));
    }

    public void onClickOk(View v){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(SubjectFragment.TEACHER_NAME_EXTRA,teacherName.getText().toString());
        intent.putExtra(SubjectFragment.DESCRIPTION_EXTRA,description.getText().toString());
        intent.putExtra(SubjectFragment.NUM_OF_CLASSROOM_EXTRA,numOfClassRoom.getText().toString());
        setResult(1,intent);
        finish();
    }
}