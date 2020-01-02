package com.wecanbetethis.diabetesapp.Controllers;

import com.wecanbetethis.diabetesapp.Models.Blog;
import com.wecanbetethis.diabetesapp.Models.Data.BlogDao;
import com.wecanbetethis.diabetesapp.Models.Data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("title","Blogs");
        return "blog/index";
    }

    @RequestMapping(value = "view/{blogId}", method = RequestMethod.GET)
    public String viewBlog(Model model, @PathVariable int blogId) {

        Blog blog = blogDao.findById(blogId).get();
        model.addAttribute("blog", blog);
        model.addAttribute("blogId", blog.getId());

        return "blog/view";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addBlogForm(Model model) {
        model.addAttribute(new Blog());
        model.addAttribute("blogs",blogDao.findAll());
        model.addAttribute("title", "Add your Blog");
        return "blog/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String postBlogForm(@ModelAttribute @Valid Blog newBlog, Errors errors, Model model) {

        if (errors.hasErrors()) {

            return "blog/add";
        }

        blogDao.save(newBlog);
        return "redirect:/blogs";
    }

    @RequestMapping(value = "remove", method= RequestMethod.GET)
    public String removeBlogForm(Model model){
        model.addAttribute("blogs", blogDao.findAll());
        model.addAttribute("title", "Remove your Blog");
        return "blog/remove";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String postRemoveBlogForm(@RequestParam int[] blogIds) {
        for (int blogId : blogIds) {
            blogDao.deleteById(blogId);
        }
        return "redirect: ";
    }


}
