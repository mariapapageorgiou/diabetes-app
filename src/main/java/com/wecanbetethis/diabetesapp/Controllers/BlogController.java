package com.wecanbetethis.diabetesapp.Controllers;

import com.wecanbetethis.diabetesapp.Models.Blog;
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
import java.util.Optional;

@Controller
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("blogs", blogDao.findAll());

        return "blog/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addBlogForm(Model model) {
        model.addAttribute(new Blog());
        model.addAttribute("users",userDao.findAll());
        model.addAttribute("title", "Add your Blog");
        return "blog/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String postBlogForm(@ModelAttribute @Valid Blog newBlog, Errors errors, @RequestParam int userId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("users", userDao.findAll());
            return "blog/add";
        }

        Optional<User> user = userDao.findById(userId);
        newBlog.setUser(user);
        blogDao.save(newBlog);
        return "redirect:/blogs";
    }

    @RequestMapping(value = "remove", method= RequestMethod.GET)
    public String removeBlog(Model model){
        model.addAttribute("blogs", blogDao.findAll());
        model.addAttribute("title", "Remove your Blog");
        return "blog/remove";
    }

}
