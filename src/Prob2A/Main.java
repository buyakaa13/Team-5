package Prob2A;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("George");
        student.getGradeReport().setGrade("A+");
        System.out.println("Name: " + student.getName());
        System.out.println("OnetoOne.GradeReport: " + student.getGradeReport().getGrade());;
    }
}
