package com.studentmanagement.crud.service;

import com.studentmanagement.crud.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface StudentDao {
    List<Student> queryAll();

    boolean add(Student student);

    boolean deleteByID(int no);

    boolean update(Student student);
}
