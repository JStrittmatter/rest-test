package org.jstrittmatter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by justin on 6/24/15.
 */
public class Payroll implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private Double grossAmount;
    private Integer federalTaxRate;
    private Integer stateTaxRate;
    private List<Deduction> deductions = new ArrayList<Deduction>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Integer getFederalTaxRate() {
        return federalTaxRate;
    }

    public void setFederalTaxRate(Integer federalTaxRate) {
        this.federalTaxRate = federalTaxRate;
    }

    public Integer getStateTaxRate() {
        return stateTaxRate;
    }

    public void setStateTaxRate(Integer stateTaxRate) {
        this.stateTaxRate = stateTaxRate;
    }

    public List<Deduction> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<Deduction> deductions) {
        this.deductions = deductions;
    }
}
