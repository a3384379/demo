package com.example.controller;

import com.example.entity.User;
import com.example.util.PageUtil;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
public class UserController {
    @RequestMapping("/addUser")
    @ResponseBody
    public PageUtil addUser(Model model, User user) {
        PageUtil<User> pageUtil = new PageUtil();
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User(1, "1", "123"));
        userList.add(new User(2, "2", "123"));
        userList.add(new User(3, "3", "123"));
        userList.add(new User(4, "33843794", "123"));
        userList.add(new User(5, "33843795", "123"));
        userList.add(new User(6, "33843796", "123"));
        userList.add(new User(7, "33843797", "123"));
        userList.add(new User(8, "33843798", "123"));
        userList.add(new User(9, "33843799", "123"));
        userList.add(new User(10, "338437920", "123"));
        userList.add(new User(11, "1", "123"));
        userList.add(new User(12, "2", "123"));
        userList.add(new User(13, "3", "123"));
        userList.add(new User(14, "33843794", "123"));
        userList.add(new User(15, "33843795", "123"));
        userList.add(new User(16, "33843796", "123"));
        userList.add(new User(17, "33843797", "123"));
        userList.add(new User(18, "33843798", "123"));
        userList.add(new User(19, "33843799", "123"));
        pageUtil.setData(userList);
        model.addAttribute("name", "大大大大");
        System.out.println(user.getName());
        return pageUtil;
    }

    @CrossOrigin
    @RequestMapping("/")
    public String test1(Model model) {
        model.addAttribute("name", "大大");
        return "index.html";
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/upload")
    public String test2(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            String filePath = "D:/";
            File dest = new File(filePath + fileName);
            file.transferTo(dest);

        } catch (Exception e) {

        }
        return "哈哈哈";

    }

    @CrossOrigin
    @RequestMapping("/test3")
    public void test3(Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        model.addAttribute("name","苏邱钊");
        System.out.println("111");
        request.getRequestDispatcher("http://127.0.0.1:8020/test/index.html").forward(request,response);
    }
}