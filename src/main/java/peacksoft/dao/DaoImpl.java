package peacksoft.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import peacksoft.entity.Student;
import peacksoft.util.HibernateUtil;


import java.util.List;

public class DaoImpl implements DaoInterface{

    public DaoImpl(){}

    @Override
    public void create(Student student) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
           transaction= session.beginTransaction();
           session.saveOrUpdate(student);
           transaction.commit();
           System.out.println("Successfully");
        }catch (HibernateException e) {
           transaction.rollback();
           e.printStackTrace();
        }finally {
            session.close();
        }

    }

    @Override
    public List<Student> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Student> students = null;
        try {
            transaction = session.beginTransaction();
            students = session.createQuery("FROM Student ").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }

    @Override
    public void update(long id, String name, String lastName, int age, String course){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            student.setId(id);
            student.setName(name);
            student.setLastName(lastName);
            student.setAge(age);
            student.setCourse(course);
            transaction.commit();
            System.out.println("Student" + student +  " UPDATE!");
        } catch (HibernateException e)  {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            transaction.commit();
            System.out.println("Student" + student +  " DELETED!");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
