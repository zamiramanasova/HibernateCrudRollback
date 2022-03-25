package peacksoft.service;

import peacksoft.entity.Student;

import java.util.List;

public interface ServiceInterface {

     void create(Student student);

     List<Student> read();

     void update(long id, String name, String lastName, int age, String course);

     void delete(long id);

}
