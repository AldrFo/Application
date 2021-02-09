package com.example.myapplication234;

//класс, содержащий данные о учебном предмете
public class EduSubject {

    public static final int LECTURE = 1;
    public static final int SEMINAR = 2;
    public static final int LAB = 3;

    private String eduSubjectName;
    private String classroom;
    private String teacherName;
    private String description;
    private int numOfPair;
    private int typeOfSubject;

    public EduSubject(String eSN, String cr,String tN, String desc,int noP,int toS){
        eduSubjectName = eSN;
        classroom = cr;
        teacherName = tN;
        description = desc;
        numOfPair = noP;
        typeOfSubject = toS;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTypeOfSubject(int typeOfSubject) {
        this.typeOfSubject = typeOfSubject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getNumOfPair() {
        return numOfPair;
    }

    public int getTypeOfSubject() {
        return typeOfSubject;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getEduSubjectName() {
        return eduSubjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTime(){
        switch (numOfPair){
            case 1:
                return "9:20\n10:55";
            case 2:
                return "11:10\n12:45";
            case 3:
                return "33:33\n33:33";
            case 4:
                return "44:44\n44:44";
            case 5:
                return "55:55\n55:55";
        }
        return "error";
    }

    public String getTypeNameOfSubject(){
        switch (getTypeOfSubject()){
            case LECTURE:
                return "Лекция";
            case SEMINAR:
                return "Семинар";
            case LAB:
                return "Лабораторная работа";
        }
        return "error";
    }
}
