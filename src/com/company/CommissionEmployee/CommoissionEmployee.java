package com.company.CommissionEmployee;

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


public class CommoissionEmployee extends Employee {
    Scanner scanner=new Scanner(System.in);
    private double grossSell;
    private double commissionRate;


    public CommoissionEmployee() {

    }

    public CommoissionEmployee(String name,
                               int employeeId,
                               long phoneNo,
                               double grossSell,
                               double commissionRate) {
        super(name, employeeId, phoneNo);
        setGrossSell(grossSell);
        setCommissionRate(commissionRate);

    }

    public void InsertingIntoCommissionEmployee(CommoissionEmployee commissionEmployee) {

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
                    "\t( '" + commissionEmployee.getName() + "', \n" +
                    "\t" + commissionEmployee.getEmployeeId() + ", \n" +
                    "\t" + commissionEmployee.getPhoneNo() + ", \n" +
                    "\t" + commissionEmployee.getGrossSell() + ", \n" +
                    "\t" + commissionEmployee.getCommissionRate() + ", \n" +
                    "\t NULL , \n" +
                    "\t NULL , \n" +
                    "\t NULL , \n" +
                    "\t" + Type.COMMISSION_EMPLOYEE.ordinal() + "\n" +
                    "\t);\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public String display() {
        return "Commission Employee\n" + super.display() + "  Earning::" + earning();
    }


    @Override
    public double earning() {
        return getGrossSell() * getCommissionRate();
    }

    public double getGrossSell() {
        return grossSell;
    }

    public void setGrossSell(double grossSell) {
        this.grossSell = grossSell;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public CommoissionEmployee readCommissionEmployee() {
        CommoissionEmployee commoissionEmployee = new CommoissionEmployee();
        System.out.println("Enter Commission employee Name::");
        commoissionEmployee.setName(scanner.next());
        System.out.println("Enter employee Id::");
        commoissionEmployee.setEmployeeId(scanner.nextInt());
        System.out.println("Enter Phone number::");
        commoissionEmployee.setPhoneNo(scanner.nextLong());
        System.out.println("Enter Gross Sell::");
        commoissionEmployee.setGrossSell(scanner.nextDouble());
        System.out.println("Enter Commission Rate::");
        commoissionEmployee.setCommissionRate(scanner.nextDouble());
        // System.out.println("Inside commission Employee::"+commoissionEmployee.toString());
        return commoissionEmployee;
    }


    public List<CommissionEmployeeDetails> getMyReport() {

        try {
            Class.forName(Constants.ClassName);
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Practice", "root", "root"
            );
            Statement statement = connection.createStatement();

            List<CommissionEmployeeDetails> list = new ArrayList<>();
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
                    "\t`Practice`.`test` WHERE TYPE = " + Type.COMMISSION_EMPLOYEE.ordinal() + "");
            while (resultSet.next()) {
                CommissionEmployeeDetails commissionEmployeeDetails = new CommissionEmployeeDetails();
                commissionEmployeeDetails.setName(resultSet.getString("Name"));
                commissionEmployeeDetails.setEmpID(resultSet.getInt("Emp_Id"));
                commissionEmployeeDetails.setPhoneNo(resultSet.getLong("Phn_No"));
                commissionEmployeeDetails.setCommisssionRate(resultSet.getDouble("Commission_Rate"));
                commissionEmployeeDetails.setGrossSales(resultSet.getDouble("Gross_Sell"));
                commissionEmployeeDetails.setType(MyTypes.getMyType(resultSet.getInt("type")));
                list.add(commissionEmployeeDetails);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    public void showMyReport(List<CommissionEmployeeDetails> list) {
        System.out.println("Name" + Constants.SPACE +
                "EMP ID" + Constants.SPACE +
                "Phone Number" + Constants.SPACE +
                "Gross Sell" + Constants.SPACE +
                "Commisssion Rate" + Constants.SPACE +
                "Type");
        System.out.println(Constants.DASH + Constants.DASH);
        for (CommissionEmployeeDetails commissionEmployeeDetails : list) {
            System.out.println(commissionEmployeeDetails.getName() + Constants.SPACE +
                    commissionEmployeeDetails.getEmpID() + Constants.SPACE +
                    commissionEmployeeDetails.getPhoneNo() + Constants.SPACE +
                    commissionEmployeeDetails.getGrossSales() + Constants.SPACE + Constants.SPACE +
                    commissionEmployeeDetails.getCommisssionRate() + Constants.SPACE +
                    commissionEmployeeDetails.getType()
            );


        }

    }
}
