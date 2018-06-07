package com.company.Common;

public enum Type {
    COMMISSION_EMPLOYEE("Commission EMployee","CE"),
    SALARY_EMPLOYEE("Salary EMployee","SE"),
    HOURLY_EMPLOYEE("Hourly EMployee","HE"),
    BASE_PLUS_COMMISSION_EMPLOYEE("Base Plus Commission EMployee","BPCE"),
    BASESALARY_EMPLOYEE("BaseSalary EMployee","BSE");
    private String key;
    private String value;

    Type(String key,String value){
        this.key=key;
        this.value=value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
