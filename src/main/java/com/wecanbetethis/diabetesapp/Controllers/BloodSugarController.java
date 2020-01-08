package com.wecanbetethis.diabetesapp.Controllers;

import com.wecanbetethis.diabetesapp.Models.Blog;
import com.wecanbetethis.diabetesapp.Models.Meals;
import com.wecanbetethis.diabetesapp.Models.BloodSugar;
import com.wecanbetethis.diabetesapp.Models.Data.BloodSugarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
@RequestMapping("tracking")
public class BloodSugarController {

    @Autowired
    private BloodSugarDao bloodSugarDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("bloodsugar", bloodSugarDao.findAll());
        model.addAttribute("title", "Blood Sugar Entries");
        return "tracking/stats";
    }

    @RequestMapping(value= "add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute(new BloodSugar());
        model.addAttribute("bloodsugar", bloodSugarDao.findAll());
        model.addAttribute("title","Blood Sugar Tracking");
        return "tracking/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String postForm(@ModelAttribute @Valid BloodSugar newBloodSugar, Errors errors, Model model) {

        if (errors.hasErrors()) {

            return "tracking/add";
        }

        bloodSugarDao.save(newBloodSugar);
        return "redirect:/tracking";
    }

    @RequestMapping(value = "view/{bloodSugarId}", method = RequestMethod.GET)
    public String viewEntry(Model model, @PathVariable int bloodSugarId) {

        BloodSugar bloodSugar = bloodSugarDao.findById(bloodSugarId).get();
        model.addAttribute("bloodSugar", bloodSugar);
        model.addAttribute("bloodSugarId", bloodSugar.getId());

        return "tracking/view";
    }
}
