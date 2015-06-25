package org.jstrittmatter.util;

import org.jstrittmatter.model.CalculatedPayroll;
import org.jstrittmatter.model.Deduction;
import org.jstrittmatter.model.Payroll;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by justin on 6/24/15.
 */
public class PayrollUtil {

    public static CalculatedPayroll convertToCalcPayroll(Payroll payroll){
        CalculatedPayroll calculatedPayroll = new CalculatedPayroll();
        try {
            calculatedPayroll.setFirstName(payroll.getFirstName());
            calculatedPayroll.setLastName(payroll.getLastName());
            List<Deduction> deductions = payroll.getDeductions();
            Double preTax = 0.0;
            Double postTax = 0.0;
            for (Deduction ded : deductions) {
                if (ded.getPreTax()) {
                    preTax = preTax + Double.valueOf(ded.getAmount());
                } else {
                    postTax = postTax + Double.valueOf(ded.getAmount());
                }
            }
            calculatedPayroll.setFederalTaxAmount(round((payroll.getGrossAmount() - preTax) * (Double.valueOf(payroll.getFederalTaxRate()) / 100.00),2));
            calculatedPayroll.setGrossAmount(round(payroll.getGrossAmount(), 2));
            calculatedPayroll.setPreTaxDeductionTotal(round(preTax,2));
            calculatedPayroll.setPostTaxDeductionTotal(round(postTax,2));
            calculatedPayroll.setStateTaxAmount(round((payroll.getGrossAmount() - preTax) * (Double.valueOf(payroll.getStateTaxRate()) / 100.00),2));
            calculatedPayroll.setNetAmount(round(calculatedPayroll.getGrossAmount() - preTax - calculatedPayroll.getFederalTaxAmount() - calculatedPayroll.getStateTaxAmount() - calculatedPayroll.getPostTaxDeductionTotal(),2));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return calculatedPayroll;
        }

    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
