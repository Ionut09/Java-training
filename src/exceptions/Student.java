package exceptions;

public class Student implements Comparable<Student> {

    //    @NotBlank
//    @Size
    private String name;

    //    @Min(1)
//    @Max(10)
    private int grade;

    @Override
    public int compareTo(Student o) {
        int nameCompare = name.compareTo(o.name);

        if (nameCompare == 0) {
            return Integer.valueOf(grade).compareTo(o.grade);
        }
        return nameCompare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade < 1 || grade > 10) {
            var name = getName(); //local variable type inference
//            name = 1;
            var exception = new StudentInvalidGradeException("Grade should be between 1 and 10");

            throw exception;
        }
        this.grade = grade;
    }
}
