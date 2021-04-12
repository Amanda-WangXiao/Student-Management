package com.studentmanagement.crud.service;

import com.studentmanagement.crud.entity.Student;
import com.studentmanagement.crud.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentDao {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAll() {
        List<Student> studentList = studentMapper.queryAll();
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        studentMapper.insert(student);
        return true;
    }

    @Override
    public boolean deleteByID(String no) {
        studentMapper.deleteByPrimaryKey(no);
        return true;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

}
