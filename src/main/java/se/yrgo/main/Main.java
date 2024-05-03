package se.yrgo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Tutor;
import se.yrgo.domain.Student;

import java.util.List;


public class Main {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student student1 = new Student("Kalle Karlsson" );
        Student student2 = new Student("Robert Bengtsson");
        Student student3 = new Student("Leila Wahlgren");

        Tutor tutor1 = new Tutor("Arthur Bengt");


        tutor1.addStudentToStudents(student1);
        tutor1.addStudentToStudents(student2);
        tutor1.addStudentToStudents(student3);
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(tutor1);

        tx.commit();

        Tutor tutor_from_database = session.get(Tutor.class, tutor1.getId());
        System.out.println(tutor_from_database);
        List<Student> students = tutor_from_database.getStudents();
        for (Student s : students) {
            System.out.println(s);
        }

        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
