package com.company.Common;

import java.util.Scanner;

public abstract class Employee {

    private String name;
    private int employeeId;
    private long phoneNo;

    Scanner scanner = new Scanner(System.in);
    public abstract double earning();

    public Employee() {

    }

    public Employee(String name,
                    int employeeId,
                    long phoneNo) {
        setName(name);
        setEmployeeId(employeeId);
        setPhoneNo(phoneNo);

    }


    public String display() {
        return "Name::" + getName() + "  Employee Id::" + getEmployeeId() + "  Phone No::" + getPhoneNo();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
}
