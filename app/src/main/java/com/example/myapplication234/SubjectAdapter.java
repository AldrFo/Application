package com.example.myapplication234;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.security.auth.Subject;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    interface OnSubjectClickListener{
        void onSubjectClick(EduSubject s, int pos);
    }

    private final LayoutInflater inflater;
    private final List<EduSubject> subjects;
    private OnSubjectClickListener onSubjectClickListener;

    public SubjectAdapter(Context context, List<EduSubject> subjects){
        inflater = LayoutInflater.from(context);
        this.subjects = subjects;
    }

    public SubjectAdapter(Context context, List<EduSubject> subjects,
                          OnSubjectClickListener subjectClickListener){
        inflater = LayoutInflater.from(context);
        this.subjects = subjects;
        onSubjectClickListener = subjectClickListener;
    }

    @NonNull
    @Override
    public SubjectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.subject_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubjectAdapter.ViewHolder holder, final int position) {
        final EduSubject sub = subjects.get(position);
        holder.subjectName.setText(sub.getEduSubjectName());
        holder.teacherName.setText(sub.getTeacherName());
        holder.subjectType.setText(sub.getTypeNameOfSubject());
        holder.classroomNum.setText(sub.getClassroom());
        holder.time.setText(sub.getTime());
        holder.description.setText(sub.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubjectClickListener.onSubjectClick(sub,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        final TextView time;
        final TextView subjectName;
        final TextView subjectType;
        final TextView classroomNum;
        final TextView teacherName;
        final TextView description;

        ViewHolder(View v){
            super(v);
            time = v.findViewById(R.id.time);
            subjectName = v.findViewById(R.id.subject_name);
            subjectType = v.findViewById(R.id.type_of_subject);
            classroomNum = v.findViewById(R.id.num_of_classroom);
            teacherName = v.findViewById(R.id.teacher_name);
            description = v.findViewById(R.id.description);
        }
    }
}
