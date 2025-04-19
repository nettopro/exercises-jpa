package test.inheritance;

import infra.DAO;
import model.inheritance.ScholarshipStudent;
import model.inheritance.Student;

public class NewStudent {
    public static void main(String[] args) {
        DAO<Student> studentDAO = new DAO<>();

        Student student1 = new Student(123L, "John");
        ScholarshipStudent student2 = new ScholarshipStudent(124L, "Jim", 1000);

        studentDAO.insertAtomic(student1);
        studentDAO.insertAtomic(student2);

        studentDAO.close();
    }
}
