package org.example;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Student first = new Student("Artem", "Shendarov");
        Teacher teacher = new Teacher("Pavel", "Panilov", new ArrayList<>());
        teacher.addCourse("Methots of algoritmisation");
        Teacher secteacher = new Teacher("Artem", "Nikolaev", new ArrayList<>());
        secteacher.addCourse("Computer Science");
        first.setTutor(teacher);
        List<People> p = new ArrayList<>();
        p.add(first);
        p.add(teacher);
        for (People pp: p) {
            System.out.println(pp);
        }
    }
}

abstract class People {
    String Name;
    String Surname;

    public People(String name, String surname) {
        this.Surname = surname;
        this.Name = name;
    }
}

class Student extends People {

    private Teacher Tutor;

    public Student(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Tutor=" + Tutor +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }

    public void setTutor(Teacher tutor) {
        if (this.Tutor != null) {
            throw new IllegalStateException("Student already have tutor" + this.Tutor);

        } else {
            this.Tutor = tutor;
        }
    }
}

class Teacher extends People{
    private List<String> Courses;
    public Teacher (String name, String surname, List<String> courses) {
        super(name, surname);
        this.Courses = new ArrayList<String>(courses);
    }


    public List<String> getCourse() {
        return this.Courses;
    }

    public void setCourse(List<String> courses) {
        this.Courses = courses;
    }

    public void addCourse (String course) {;
        this.Courses.add(course);
    }

    public void removeCourse (String course) {
        this.Courses.remove(course);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Courses=" + Courses +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }
}
