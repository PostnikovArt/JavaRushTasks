package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double max = 0;
        Student studentMax = null;
        for (Student student : students) {
            if (student.getAverageGrade() > max) {
                max = student.getAverageGrade();
                studentMax = student;
            }
        }
        if (studentMax != null) {
            return studentMax;
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double min = Double.MAX_VALUE;
        Student studentMin = null;
        for (Student student : students) {
            if (student.getAverageGrade() < min) {
                min = student.getAverageGrade();
                studentMin = student;
            }
        }
        if (studentMin != null) {
            return studentMin;
        }
        return null;
    }
    public void expel(Student student) {
        students.remove(student);
    }
}