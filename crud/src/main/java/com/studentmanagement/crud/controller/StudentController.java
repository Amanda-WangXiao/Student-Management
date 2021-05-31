package com.studentmanagement.crud.controller;

import com.studentmanagement.crud.entity.Student;
import com.studentmanagement.crud.service.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

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
        String no = request.getParameter("del_no");
        studentDao.deleteByID(no);
        return new ModelAndView("redirect:/display");
    }

    @GetMapping("/addPage")
    public ModelAndView addPage(Model model){
        model.addAttribute("new_student",new Student());
        return new ModelAndView("add","add_model",model);
    }

    @PostMapping("/add")
    public ModelAndView add(Student student){
        studentDao.add(student);
        return new ModelAndView("redirect:/display");
    }

    @GetMapping("/updatePage")
    public ModelAndView updatePage(HttpServletRequest request,Model model){
        String no = request.getParameter("update_no");
        Student student = studentDao.selectByID(no);
        model.addAttribute("student_tobeUpdate",student);
        return new ModelAndView("edit","update_model",model);
    }

    @PostMapping("/update")
    public ModelAndView update(Student student){
        studentDao.update(student);
        return new ModelAndView("redirect:/display");
    }

}
