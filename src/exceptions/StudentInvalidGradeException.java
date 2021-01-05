package exceptions;

public class StudentInvalidGradeException extends RuntimeException { //unchecked
//public class StudentInvalidGradeException extends Exception { //checked

    public StudentInvalidGradeException(String message) {
        super(message);
    }
}
