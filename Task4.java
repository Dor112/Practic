package org.example;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Object {
    public static void main(String[] args) {
        Student student1 = new Student("Bob", "Smith");
        Student student2 = new Student("John", "Smith");
        Teacher teacher1 = new Teacher("Bob", "Smith", new ArrayList<>());
        Teacher teacher2 = new Teacher("John", "Smith", new ArrayList<>());
        teacher1.addCourse("Math");
        teacher1.addCourse("CS");
        student1.setTutor(teacher1);
        student1.setTutor(teacher2, teacher1);
        System.out.println(teacher1);

        System.out.println(student1);

        List<People> peopleList = new ArrayList<>();
        peopleList.add(student1);
        peopleList.add(student2);
        peopleList.add(teacher1);
        peopleList.add(teacher2);


    }
}

abstract class People {
    protected String name;
    protected String surmame;
    public People(String name, String surmame) {
        this.name = name;
        this.surmame = surmame;
    }
}

class Student extends People {
    private Teacher tutor;

    public Student(String name, String surname){
        super(name, surname);
    }

    public void setTutor(Teacher tutor){
        if (this.tutor != null) {
            throw new IllegalStateException("Tutor has already been set");
        }else{
            this.tutor = tutor;
        }
    }

    public void setTutor(Teacher newTutor, Teacher previousTutor){
        if (this.tutor == previousTutor){
            this.tutor = newTutor;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "tutor=" + tutor +
                ", name='" + name + '\'' +
                ", surmame='" + surmame + '\'' +
                '}';
    }
}


class Teacher  extends People{
    private List<String> courses;
    public Teacher(String name, String surmame, List<String> courses) {
        super(name, surmame);
        this.courses = new ArrayList<>(courses);
    }

    public void addCourse(String course){
        courses.add(course);
    }

    public void removeCourse(String course){
        courses.remove(course);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "courses=" + courses +
                ", name='" + name + '\'' +
                ", surmame='" + surmame + '\'' +
                '}';
    }
}
