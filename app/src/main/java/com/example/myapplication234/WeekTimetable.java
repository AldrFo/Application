package com.example.myapplication234;

import java.util.ArrayList;

//класс содержащий расписание дней недели
public class WeekTimetable {

    public static EduSubject[] pn = {
            new EduSubject("Физика","А-106","Лаборантка","нет",1,EduSubject.LAB),
            new EduSubject("Инженерная графика","Д-308","Маслов","нет",2,EduSubject.SEMINAR),
            new EduSubject("Программирование","Ж-111","Гречка","нет",3,EduSubject.SEMINAR),
            new EduSubject("Математический анализ","Ж-413","Тварь","нет",4,EduSubject.SEMINAR)
    };

    public static EduSubject[] vt = {
            new EduSubject("Математический анализ","ЭО и ДОТ","Симушев А.А.","нет",1,EduSubject.LECTURE),
            new EduSubject("Физика","ЭО и ДОТ","Корецкая И.В.","нет",2,EduSubject.LECTURE),
            new EduSubject("Инженерная графика","ЭО и ДОТ","Касаткина Е.П.","нет",3,EduSubject.LECTURE),

    };
}
