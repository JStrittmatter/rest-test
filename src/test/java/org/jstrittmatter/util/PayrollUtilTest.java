package org.jstrittmatter.util;

import org.jstrittmatter.model.CalculatedPayroll;
import org.jstrittmatter.model.Deduction;
import org.jstrittmatter.model.Payroll;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by justin on 6/24/15.
 */
public class PayrollUtilTest {


    Payroll payroll = new Payroll();

    @Before
    public void setUp(){
        payroll.setFirstName("Tommy");
        payroll.setLastName("Test");
        payroll.setGrossAmount(2345.67);
        payroll.setFederalTaxRate(15);
        payroll.setStateTaxRate(5);
        Deduction ded1 = new Deduction();
        ded1.setAmount("20.50");
        ded1.setPreTax(true);
        Deduction ded2 = new Deduction();
        ded2.setAmount("150.00");
        ded2.setPreTax(false);
        List<Deduction> deductionList = new ArrayList<Deduction>();
        deductionList.add(ded1);
        deductionList.add(ded2);
        payroll.setDeductions(deductionList);
    }

    @Test
    public void shouldConvertPayroll(){
        CalculatedPayroll calculatedPayroll = PayrollUtil.convertToCalcPayroll(payroll);
        assertTrue(calculatedPayroll.getGrossAmount().equals(2345.67));
        assertTrue(calculatedPayroll.getPreTaxDeductionTotal().equals(20.50));
        assertTrue(calculatedPayroll.getPostTaxDeductionTotal().equals(150.00));
        assertTrue(calculatedPayroll.getFederalTaxAmount().equals(348.78));
        assertTrue(calculatedPayroll.getStateTaxAmount().equals(116.26));
        assertTrue(calculatedPayroll.getNetAmount().equals(1710.13));
    }
}
