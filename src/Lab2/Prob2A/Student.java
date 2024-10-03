package Lab2.Prob2A;

public class Student {
    private String name;
    private GradeReport gradeReport;

    public Student(String name){
        this.name = name;
        gradeReport = new GradeReport();
    }

    public String getName(){
        return this.name;
    }

    public GradeReport getGradeReport(){
        return this.gradeReport;
    }
}
