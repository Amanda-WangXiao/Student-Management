package com.studentmanagement.crud.controller;

import com.studentmanagement.crud.entity.Student;
import com.studentmanagement.crud.service.StudentDao;
import com.studentmanagement.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/display")
    public ModelAndView Display(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentDao.queryAll();
        modelAndView.addObject("students",studentList);
        modelAndView.setViewName("display");
        return modelAndView;
    }
}
