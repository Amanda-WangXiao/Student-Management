package com.studentmanagement.crud.controller;

import com.studentmanagement.crud.entity.Student;
import com.studentmanagement.crud.service.StudentDao;
import com.studentmanagement.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/delete")
    public ModelAndView Delete(HttpServletRequest request){
        String no = request.getParameter("no");
        studentDao.deleteByID(no);
        return new ModelAndView("redirect:/display");
    }

    @GetMapping("/addPage")
    public ModelAndView addPage(Model model){
        model.addAttribute("new_student",new Student());
        return new ModelAndView("add","stumodel",model);
    }

    @PostMapping("/add")
    public ModelAndView add(Student student){
        studentDao.add(student);
        return new ModelAndView("redirect:/display");
    }


}