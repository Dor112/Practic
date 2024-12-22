package org.example;
public class Main {
    public static void main(String[] args) {
        // Создаем экземпляры классов
        IUStudent iuStudent = new IUStudent("Ivan", "Ivanov", 3, 5);
        MathStudent mathStudent = new MathStudent("Petr", "Petrov",2, 5);

        iuStudent.printInfo();
        iuStudent.writeExam();

        System.out.println();

        mathStudent.printInfo();
        mathStudent.writeExam();
    }
}
abstract class Student {
    protected String name;
    protected String surname;
    protected int course;
    protected int last_mark;

    // Конструктор
    public Student(String name, String surname, int course, int last_mark) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.last_mark = last_mark;
    }
    public abstract void writeExam();

    public void printInfo() {
        System.out.println("Name: " + name + " " + surname +  ", Curse: " + course + ", Grade for the last exam: " + last_mark);
    }
}

class IUStudent extends Student {

    public IUStudent(String name, String surname, int course, int last_mark) {
        super(name, surname, course, last_mark);
    }

    @Override
    public void writeExam() {
        System.out.println(name + " " + surname + " (IU Student) writing exam 'Inforamtics technology'.");
    }
}
class MathStudent extends Student {
    public MathStudent(String name, String surname, int course, int last_mark) {
        super(name, surname,  course, last_mark);
    }

    @Override
    public void writeExam() {
        System.out.println(name + " " + surname + " (Math Student) writing exam 'Maths'.");
    }
}
