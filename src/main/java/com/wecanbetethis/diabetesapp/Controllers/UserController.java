package com.wecanbetethis.diabetesapp.Controllers;

import com.wecanbetethis.diabetesapp.Models.Data.BlogDao;
import com.wecanbetethis.diabetesapp.Models.Data.UserDao;
import com.wecanbetethis.diabetesapp.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value="")
public class UserController {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private BlogDao blogDao;

    @RequestMapping(value = "/home")
    public String index(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "Home");
        return "home";
    }

    // gets the registration page
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("title", "Registration");
        return "tracking/registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute @Valid User newUser, Errors errors, Model model) {
        if (errors.hasErrors()) {
//            model.addAttribute("title", "Register");
            return "tracking/registration";
        }
        userDao.save(newUser);
        return "redirect:/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
//        User user = new User();
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "LogIn Information");
//        model.addAttribute("user", userDao.findById(userId));
//        model.addAttribute("user", userDao.findAll());
        return "tracking/login";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model, Errors errors) {
        String username = user.getUsername();
        String password = user.getPassword();

        User foundUser = userDao.findByUsername(username);
        if (foundUser != null && password.equals(foundUser.getPassword())) {
            return "redirect:/home";
        }
        if (errors.hasErrors()) {
            return "tracking/login";

        }
        model.addAttribute("invalidCredentials", true);
        return "redirect:home";
    }
}














