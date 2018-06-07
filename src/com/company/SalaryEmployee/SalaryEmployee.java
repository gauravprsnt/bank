package com.company.SalaryEmployee;

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

public class SalaryEmployee extends Employee {
    Scanner scanner=new Scanner(System.in);
    private double salary;

    public SalaryEmployee() {

    }

    public SalaryEmployee(String name,
                          int employeeId,
                          long phoneNo,
                          double salary) {
        super(name, employeeId, phoneNo);
        setSalary(salary);

    }

    @Override
    public String display() {
        return "Salary Employee::\n" + super.display() + "  Salary::" + earning();
    }

    @Override
    public double earning() {
        return getSalary();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SalaryEmployee readSalaryEmployee() {
        SalaryEmployee salaryEmployee = new SalaryEmployee();
        System.out.println("Enter your Name::");
        salaryEmployee.setName(scanner.next());
        System.out.println("Enter Employee Id::");
        salaryEmployee.setEmployeeId(scanner.nextInt());
        System.out.println("Enter phone No::");
        salaryEmployee.setPhoneNo(scanner.nextLong());
        System.out.println("Enter Salary");
        salaryEmployee.setSalary(scanner.nextInt());
        return salaryEmployee;
    }

    public void insertingIntoSalaryEmployee(SalaryEmployee salaryEmployee) {
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
                    "\t( '" + salaryEmployee.getName() + "', \n" +
                    "\t" + salaryEmployee.getEmployeeId() + ", \n" +
                    "\t" + salaryEmployee.getPhoneNo() + ", \n" +
                    "\t NULL , \n" +
                    "\t NULL , \n" +
                    "\t" + salaryEmployee.getSalary() + " , \n" +
                    "\t NULL , \n" +
                    "\t NULL , \n" +
                    "\t" + Type.SALARY_EMPLOYEE.ordinal() + "\n" +
                    "\t);\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<SalaryEmployeeDetails> getMyReport() {
        try {
            Class.forName(Constants.ClassName);
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Practice", "root", "root"
            );
            Statement statement = connection.createStatement();

            List<SalaryEmployeeDetails> list = new ArrayList<>();
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
                    "\t`Practice`.`test` WHERE TYPE = " + Type.SALARY_EMPLOYEE.ordinal() + "");
            while (resultSet.next()) {
                SalaryEmployeeDetails salaryEmployeeDetails = new SalaryEmployeeDetails();
                salaryEmployeeDetails.setName(resultSet.getString("Name"));
                salaryEmployeeDetails.setEmployeeId(resultSet.getInt("Emp_Id"));
                salaryEmployeeDetails.setPhoneNo(resultSet.getLong("Phn_No"));
                salaryEmployeeDetails.setSalary(resultSet.getInt("Base_Salary"));
                salaryEmployeeDetails.setType(MyTypes.getMyType(resultSet.getInt("type")));
                list.add(salaryEmployeeDetails);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }


    public void showMyReport(List<SalaryEmployeeDetails> salaryEmployeeDetailsList) {
        System.out.println("Name" + Constants.SPACE +
                "EMP ID" + Constants.SPACE +
                "Phone Number" + Constants.SPACE +
                "Base_Salary" + Constants.SPACE +
                "Type");
        System.out.println(Constants.DASH + Constants.DASH);
        for (SalaryEmployeeDetails salaryEmployeeDetails : salaryEmployeeDetailsList) {
            System.out.println(salaryEmployeeDetails.getName() + Constants.SPACE +
                    salaryEmployeeDetails.getEmployeeId() + Constants.SPACE +
                    salaryEmployeeDetails.getPhoneNo() + Constants.SPACE +
                    salaryEmployeeDetails.getSalary() + Constants.SPACE + Constants.SPACE +
                    salaryEmployeeDetails.getType()
            );


        }

    }
}
