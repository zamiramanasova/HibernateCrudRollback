package peacksoft.main;

import peacksoft.dao.DaoImpl;
import peacksoft.entity.Student;
import peacksoft.service.ServiceImpl;
import peacksoft.service.ServiceInterface;
import peacksoft.util.HibernateUtil;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        HibernateUtil.getSessionFactory();

        ServiceInterface serviceInterface = new ServiceImpl();


        System.out.println("=======================================================================");
        Student student1 = new Student("Marina", "Golova", 54, "swim");
        Student student2 = new Student("Nikol", "Mikkoy", 34, "java");
        Student student3 = new Student("Jon", "Darry", 29, "english");
        Student student4 = new Student("Kim", "Sacley", 46, "cook");
        Student student5 = new Student("Witty", "Queen", 36, "read");
        serviceInterface.create(student1);
        serviceInterface.create(student2);
        serviceInterface.create(student3);
        serviceInterface.create(student4);
        serviceInterface.create(student5);

        System.out.println("=======================================================================");
        System.out.println("READ ALL STUDENTS");
        serviceInterface.read();
        List<Student> studentList = serviceInterface.read();
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("=======================================================================");
        serviceInterface.update(3,"Varvara", "Romova",23,"cleaning home");

        System.out.println("=======================================================================");
        serviceInterface.delete(1);
    }
}
