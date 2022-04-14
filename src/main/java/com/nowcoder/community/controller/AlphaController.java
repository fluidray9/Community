package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot.";
    }

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/find")
    @ResponseBody
    public String sayService(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        // 获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());

        // 返回响应数据
        response.setContentType("text/html;charset=utf-8");

        try(PrintWriter printWriter = response.getWriter();) {
            printWriter.write("<h1>DM</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GET请求
    // students?current=1&limit=20
    @RequestMapping(path="/students", method = RequestMethod.GET)
    @ResponseBody
    public String Student(
            @RequestParam(name="current", required = false, defaultValue = "1") int current,
            @RequestParam(name="limit", required = false, defaultValue = "20") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    // students/123
    @RequestMapping(path = "students/{id}", method=RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    // POST请求
    @RequestMapping(path = "/students", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudents(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success!";
    }

    //响应html数据
    @RequestMapping(path="/teacher", method=RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "张三");
        modelAndView.addObject("age", 26);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    // 更简单返回html
    @RequestMapping(path="/school", method=RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name", "丽梅");
        model.addAttribute("age", 30);
        return "/demo/view";
    }

    //响应json(异步请求)
    // Java对象 -> JSON对象 -> JS对象
    @RequestMapping(path="/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 24);
        map.put("salary", 8000.00);
        return map;
    }

    // 多个员工
    @RequestMapping(path="/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 24);
        map.put("salary", 8000.00);
        list.add(map);

        map = new HashMap<>();
        map.put("name", "李四");
        map.put("age", 26);
        map.put("salary", 4000.00);
        list.add(map);

        map = new HashMap<>();
        map.put("name", "刘三");
        map.put("age", 30);
        map.put("salary", 10000.00);
        list.add(map);

        return list;
    }
}
