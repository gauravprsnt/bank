package com.company.HourlyEmployee;

import com.company.Common.Constants;
import com.company.Common.Employee;
import com.company.Common.MyTypes;
import com.company.Common.Type;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HourlyEmployee extends Employee {
    Scanner scanner=new Scanner(System.in);

    private int hourWorked;
    private int hourlyRate;

    public HourlyEmployee() {

    }

    public HourlyEmployee(String name,
                          int employeeId,
                          long phoneNo,
                          int hourWorked,
                          int hourlyRate) {
        super(name, employeeId, phoneNo);
        setHourlyRate(hourlyRate);
        setHourWorked(hourWorked);

    }

    @Override
    public String display() {
        return "Hourly Emlpoyee::\n" + super.display() + "  Earning::" + earning();
    }

    @Override
    public double earning() {
        if (getHourWorked() > 100) {
            return 100 * getHourlyRate() + (getHourWorked() - 100) * 1.5;
        } else {
            return getHourWorked() * getHourlyRate();
        }

    }


    public int getHourWorked() {
        return hourWorked;
    }

    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public HourlyEmployee readHourlyEmployee() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee();
        System.out.println("Enter your Name::");
        hourlyEmployee.setName(scanner.next());
        System.out.println("Enter Employee Id::");
        hourlyEmployee.setEmployeeId(scanner.nextInt());
        System.out.println("Enter phone No::");
        hourlyEmployee.setPhoneNo(scanner.nextLong());
        System.out.println("Enter Hour Worked");
        hourlyEmployee.setHourWorked(scanner.nextInt());
        System.out.println("Enter Hourly Rate");
        hourlyEmployee.setHourlyRate(scanner.nextInt());
        return hourlyEmployee;
    }

    public void insertingIntoHourlyEmployee(HourlyEmployee hourlyEmployee) {
        try {
            Class.forName(Constants.ClassName);
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Practice", "root", "root"
            );
            Statement statement = connection.createStatement();

            statement.executeUpdate("\n" +
                    "INSERT INTO `Practice`.`test` \n" +
                    "\t(`Name`, \n" +
                    "\t`Emp_Id`, \n" +
                    "\t`Phn_No`, \n" +
                    "\t`Gross_Sell`, \n" +
                    "\t`Commission_Rate`, \n" +
                    "\t`Base_Salary`, \n" +
                    "\t`sales_rate`, \n" +
                    "\t`hour`, \n" +
                    "\t`type`\n" +
                    "\t)\n" +
                    "\tVALUES\n" +
                    "\t( '" + hourlyEmployee.getName() + "', \n" +
                    "\t" + hourlyEmployee.getEmployeeId() + ", \n" +
                    "\t" + hourlyEmployee.getPhoneNo() + ", \n" +
                    "\tNULL, \n" +
                    "\t NULL , \n" +
                    "\t NULL , \n" +
                    "\t" + hourlyEmployee.getHourlyRate() + ", \n" +
                    "\t " + hourlyEmployee.getHourWorked() + " , \n" +
                    "\t" + Type.HOURLY_EMPLOYEE.ordinal() + "\n" +
                    "\t);\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<HourlyEmployeeDetails> getMyReport() {
        try {
            Class.forName(Constants.ClassName);
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Practice", "root", "root"
            );
            Statement statement = connection.createStatement();

            List<HourlyEmployeeDetails> list = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT \t`Name`, \n" +
                    "\t`Emp_Id`, \n" +
                    "\t`Phn_No`, \n" +
                    "\t`Gross_Sell`, \n" +
                    "\t`Commission_Rate`, \n" +
                    "\t`Base_Salary`, \n" +
                    "\t`sales_rate`, \n" +
                    "\t`hour`, \n" +
                    "\t`type`\n" +
                    "\t \n" +
                    "\tFROM \n" +
                    "\t`Practice`.`test` WHERE TYPE = " + Type.HOURLY_EMPLOYEE.ordinal() + "");
            while (resultSet.next()) {
                HourlyEmployeeDetails hourlyEmployeeDetails = new HourlyEmployeeDetails();
                hourlyEmployeeDetails.setName(resultSet.getString("Name"));
                hourlyEmployeeDetails.setEmployeeId(resultSet.getInt("Emp_Id"));
                hourlyEmployeeDetails.setPhoneNo(resultSet.getLong("Phn_No"));
                hourlyEmployeeDetails.setHourRate(resultSet.getInt("sales_rate"));
                hourlyEmployeeDetails.setHourWorked(resultSet.getInt("hour"));
                hourlyEmployeeDetails.setType(MyTypes.getMyType(resultSet.getInt("type")));
                list.add(hourlyEmployeeDetails);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }





    public void showMyReport(List<HourlyEmployeeDetails> hourlyEmployeeDetailsList) {
        System.out.println("Name" + Constants.SPACE +
                "EMP ID" + Constants.SPACE +
                "Phone Number" + Constants.SPACE +
                "Hourly Rate" + Constants.SPACE +
                "Hours Worked" + Constants.SPACE +
                "Type");
        System.out.println(Constants.DASH + Constants.DASH);
        for (HourlyEmployeeDetails hourlyEmployeeDetails : hourlyEmployeeDetailsList) {
            System.out.println(hourlyEmployeeDetails.getName() + Constants.SPACE +
                    hourlyEmployeeDetails.getEmployeeId() + Constants.SPACE +
                    hourlyEmployeeDetails.getPhoneNo() + Constants.SPACE +
                    hourlyEmployeeDetails.getHourRate() + Constants.SPACE + Constants.SPACE +
                    hourlyEmployeeDetails.getHourWorked() + Constants.SPACE +
                    hourlyEmployeeDetails.getType()
            );


        }


    }
}
