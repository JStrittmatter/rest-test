package org.jstrittmatter.controller;

import org.jstrittmatter.model.CalculatedPayroll;
import org.jstrittmatter.model.Deduction;
import org.jstrittmatter.model.Payroll;
import org.jstrittmatter.util.PayrollUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justin on 6/24/15.
 */
@Controller
@RequestMapping("/")
public class PayrollController {

    @ModelAttribute("payroll")
    public Payroll getPayroll(){
        Payroll payroll = new Payroll();
        return payroll;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String goHome(){
        return "redirect:/home";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public Model getHome(Model model){
        return model;
    }

    @RequestMapping(value="sendPayroll", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public CalculatedPayroll sendPayroll(@RequestBody final Payroll payroll){
        return PayrollUtil.convertToCalcPayroll(payroll);
    }

}
