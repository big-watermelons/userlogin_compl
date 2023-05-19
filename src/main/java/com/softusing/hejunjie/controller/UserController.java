package com.softusing.hejunjie.controller;


import com.softusing.hejunjie.entity.User;
import com.softusing.hejunjie.form.UserForm;

import com.softusing.hejunjie.mapper.UserMapper;
import com.softusing.hejunjie.server.UserService;
import com.softusing.hejunjie.server.UserServiceInterFace;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "login";
    }


    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result) {

        if (!userForm.confirmPassword()) {
            result.rejectValue("confirmPassword", "confirmError", "两次密码不一致");
        }
        if (result.hasErrors()) {
            return "register";
        }

        User user = userForm.convertToUser();
        userService.save(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String result(HttpServletRequest req , HttpServletResponse resp){
        String username =req.getParameter("username");
        String password =req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean flag = userService.login(user);
        if (flag == true){
            return "Success";
        } else {
            return "Middle";
        }
    }

    @GetMapping("/middle")
    public String middle(){
        return "Middle";
    }


    @GetMapping("/forms")
    public String getForms(Model model) {
        List<User> forms = userService.findAll();
        model.addAttribute("form", forms);
        return "form"; // 返回视图名
    }

    @GetMapping("/exception")
    public String testException() {
        throw new RuntimeException();
    }

}




