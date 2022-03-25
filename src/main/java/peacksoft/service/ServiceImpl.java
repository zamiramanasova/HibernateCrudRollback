package peacksoft.service;


import peacksoft.dao.DaoImpl;
import peacksoft.dao.DaoInterface;
import peacksoft.entity.Student;

import java.util.List;

public class ServiceImpl implements ServiceInterface {

    private DaoInterface daoInterface = new DaoImpl();

    @Override
    public void create(Student student) {
       daoInterface.create(student);
    }

    @Override
    public List<Student> read() {
        return daoInterface.read();
    }

    @Override
    public void update(long id, String name, String lastName, int age, String course) {
        daoInterface.update(id,name,lastName,age,course);
    }

    @Override
    public void delete(long id) {
       daoInterface.delete(id);
    }
}
