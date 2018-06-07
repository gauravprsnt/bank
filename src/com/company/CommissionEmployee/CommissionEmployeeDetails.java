package com.company.CommissionEmployee;

public class CommissionEmployeeDetails {
    private String name;
    private int empID;
    private double phoneNo;
    private double commisssionRate;
    private double grossSales;
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public double getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(double phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getCommisssionRate() {
        return commisssionRate;
    }

    public void setCommisssionRate(double commisssionRate) {
        this.commisssionRate = commisssionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
