package com.company.HourlyEmployee;

public class HourlyEmployeeDetails {
    private String name;
    private int employeeId;
    private long phoneNo;
    private int hourWorked;
    private int hourRate;
    private String type;

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

    public int getHourWorked() {
        return hourWorked;
    }

    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked;
    }

    public int getHourRate() {
        return hourRate;
    }

    public void setHourRate(int hourRate) {
        this.hourRate = hourRate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
