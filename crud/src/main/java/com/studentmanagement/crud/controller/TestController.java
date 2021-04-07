package com.studentmanagement.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public void hello(HttpServletResponse response) throws IOException {
        response.sendRedirect("first.html");
    }
}
