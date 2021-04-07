package com.studentmanagement.crud.service;

import com.studentmanagement.crud.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> queryAll();

    boolean add(Student student);

    boolean deleteByID(int no);

    boolean update(Student student);
}
