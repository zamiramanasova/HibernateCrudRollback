package peacksoft.dao;

import peacksoft.entity.Student;

import java.util.List;

public interface DaoInterface {

    void create(Student student);

    List<Student> read();

    void update(long id, String name, String lastName, int age, String course);

    void delete(long id);
}
