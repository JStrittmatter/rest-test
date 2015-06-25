package org.jstrittmatter.controller;

import org.jstrittmatter.model.CalculatedPayroll;
import org.jstrittmatter.model.Payroll;
import org.jstrittmatter.util.PayrollUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by justin on 6/24/15.
 */
@Controller
@RequestMapping("/")
public class PayrollController {

    @RequestMapping(value="sendPayroll.json", method = RequestMethod.POST,headers = {"Content-type=application/json"})
    @ResponseBody
    public CalculatedPayroll sendPayroll(@RequestBody final Payroll payroll){
        return PayrollUtil.convertToCalcPayroll(payroll);
    }

}
