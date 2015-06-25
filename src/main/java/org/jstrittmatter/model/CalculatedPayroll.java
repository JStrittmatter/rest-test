package org.jstrittmatter.model;

/**
 * Created by justin on 6/24/15.
 */
public class CalculatedPayroll {

    private String firstName;
    private String lastName;
    private Double grossAmount;
    private Double preTaxDeductionTotal;
    private Double federalTaxAmount;
    private Double stateTaxAmount;
    private Double postTaxDeductionTotal;
    private Double netAmount;

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

    public Double getPreTaxDeductionTotal() {
        return preTaxDeductionTotal;
    }

    public void setPreTaxDeductionTotal(Double preTaxDeductionTotal) {
        this.preTaxDeductionTotal = preTaxDeductionTotal;
    }

    public Double getFederalTaxAmount() {
        return federalTaxAmount;
    }

    public void setFederalTaxAmount(Double federalTaxAmount) {
        this.federalTaxAmount = federalTaxAmount;
    }

    public Double getStateTaxAmount() {
        return stateTaxAmount;
    }

    public void setStateTaxAmount(Double stateTaxAmount) {
        this.stateTaxAmount = stateTaxAmount;
    }

    public Double getPostTaxDeductionTotal() {
        return postTaxDeductionTotal;
    }

    public void setPostTaxDeductionTotal(Double postTaxDeductionTotal) {
        this.postTaxDeductionTotal = postTaxDeductionTotal;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }
}
