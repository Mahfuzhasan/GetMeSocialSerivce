package com.example.getmesocialservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.getmesocialservice.Controller.SignUpForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/signup")
    public String getInfo(@ModelAttribute SignUpForm signUpForm, Model model){
        model.addAttribute("signUpForm",signUpForm);
        return "info";

    }

}
