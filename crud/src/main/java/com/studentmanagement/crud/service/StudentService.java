package com.studentmanagement.crud.service;

import com.studentmanagement.crud.bean.Student;
import com.studentmanagement.crud.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService{

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> queryAll() {
        List<Student> studentList = studentMapper.queryAll();
        return studentList;
    }

    public boolean add(Student student) {
        studentMapper.insert(student);
        return true;
    }

    public boolean deleteByID(String no) {
        studentMapper.deleteByPrimaryKey(no);
        return true;
    }

    public Student selectByID(String no) {
        Student student = studentMapper.selectByPrimaryKey(no);
        return student;
    }

    public int update(Student student) {
        int i = studentMapper.updateByPrimaryKeySelective(student);
        return i;
    }

}
