package com.wecanbetethis.diabetesapp.Controllers;

import com.wecanbetethis.diabetesapp.Models.BloodSugar;
import com.wecanbetethis.diabetesapp.Models.Data.BloodSugarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("tracking")
public class BloodSugarController {

    @Autowired
    private BloodSugarDao bloodSugarDao;

    @RequestMapping(value= "", method = RequestMethod.GET)
    public String addForm(Model model) {
        return "tracking/add";
    }

//    @RequestMapping(value = "/tracking", method = RequestMethod.GET)
//    public String addForm(Model model) {
//        BloodSugar bloodSugar = new BloodSugar();
//        model.addAttribute("bloodsugar", bloodSugar);
//        model.addAttribute("title", "Blood Sugar Entry");
//        return "tracking/add";
//    }

}
