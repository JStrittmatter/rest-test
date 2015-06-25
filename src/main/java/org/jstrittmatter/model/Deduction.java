package org.jstrittmatter.model;

/**
 * Created by justin on 6/24/15.
 */
public class Deduction {
    private String amount;
    private Boolean preTax;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Boolean getPreTax() {
        return preTax;
    }

    public void setPreTax(Boolean preTax) {
        this.preTax = preTax;
    }
    @Override
    public String toString() {
        return "Deduction{" +
                "amount='" + amount + '\'' +
                ", preTax=" + preTax +
                '}';
    }
}
