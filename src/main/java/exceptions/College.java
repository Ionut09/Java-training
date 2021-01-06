package exceptions;

import java.sql.SQLException;
import java.util.logging.Logger;

public class College {

    static Logger log = Logger.getLogger(College.class.getName());

    public static void main(String... args) {//throws Exception {
        Student john = new Student();
        john.setName("John");
        try {
            m1(john); //handle or declare
            System.out.println("jasnajsnkaskjs");
        } catch (ArithmeticException | IllegalArgumentException e) {
            log.severe(e.getMessage());
            e.getCause();
        } catch (Exception e) {
            log.severe(e.getMessage());
            e.printStackTrace();
            System.err.println("After stack trace");
            throw new RuntimeException(e);
        } finally {
            System.out.println("Print something no matter what!!!");
        }

        int[] ints = new int[1];
        ints[2] = 2;
    }

    public static void m1(Student john) throws Exception {
        m2(john);
    }

    public static void m2(Student john) throws Exception {
        m3(john);
    }

    public static void m3(Student john) {
        john.setGrade(12);
    }


}
