package com.wecanbetethis.diabetesapp.Controllers;

import com.wecanbetethis.diabetesapp.Models.Data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="login")
    public String login(Model model) {

        return "tracking/login";
    }

    @RequestMapping(value="register")
    public String register(Model model) {

        return "tracking/registration";
    }


}
