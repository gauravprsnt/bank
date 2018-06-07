package com.company.BaseCommissionEmployee;

import com.company.CommissionEmployee.CommoissionEmployee;
import com.company.Common.Constants;
import com.company.Common.MyTypes;
import com.company.Common.Type;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BaseCommissionEmployee extends CommoissionEmployee {
    Scanner scanner=new Scanner(System.in);
    private double baseSalary;

    public BaseCommissionEmployee() {

    }

    public BaseCommissionEmployee(String name,
                                  int employeeId,
                                  long phoneNo,
                                  double grossSell,
                                  double commissionRate,
                                  double baseSalary) {

        super(name, employeeId, phoneNo, grossSell, commissionRate);
        setBaseSalary(baseSalary);

    }

    @Override
    public String display() {
        return "Base Commission Employee::\n" + super.display() + "  Salary::" + getBaseSalary();
    }

    @Override
    public double earning() {
        return super.earning() + getBaseSalary();
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BaseCommissionEmployee readBaseEmployee() {
        BaseCommissionEmployee baseCommissionEmployee=new BaseCommissionEmployee();
        System.out.println("Enter Commission employee Name::");
        baseCommissionEmployee.setName(scanner.next());
        System.out.println("Enter employee Id::");
        baseCommissionEmployee.setEmployeeId(scanner.nextInt());
        System.out.println("Enter Phone number::");
        baseCommissionEmployee.setPhoneNo(scanner.nextLong());
        System.out.println("Enter Gross Sell::");
        baseCommissionEmployee.setGrossSell(scanner.nextDouble());
        System.out.println("Enter Commission Rate::");
        baseCommissionEmployee.setCommissionRate(scanner.nextDouble());
        System.out.println("Enter Salary");
        baseCommissionEmployee.setBaseSalary(scanner.nextInt());
        return baseCommissionEmployee;
    }

    public void insertingIntoBaseCommissionEmployee(BaseCommissionEmployee baseCommissionEmployee) {
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
                    "\t`Commission_Rate`, \n"+
                    "\t`Base_Salary`, \n" +
                    "\t`sales_rate`, \n" +
                    "\t`hour`, \n" +
                    "\t`type`\n" +
                    "\t)\n" +
                    "\tVALUES\n" +
                    "\t( '" + baseCommissionEmployee.getName() + "', \n" +
                    "\t" + baseCommissionEmployee.getEmployeeId() + ", \n" +
                    "\t" + baseCommissionEmployee.getPhoneNo() + ", \n" +
                    "\t " + baseCommissionEmployee.getGrossSell() + ", \n" +
                    "\t " + baseCommissionEmployee.getCommissionRate() + " , \n" +
                    "\t" + baseCommissionEmployee.getBaseSalary() + " , \n" +
                    "\t NULL , \n" +
                    "\t NULL , \n" +
                    "\t" + Type.BASE_PLUS_COMMISSION_EMPLOYEE.ordinal() + "\n" +
                    "\t);\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<BaseCommissionEmployeeDetails> getMyReports() {
        try {
            Class.forName(Constants.ClassName);
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Practice", "root", "root"
            );
            Statement statement = connection.createStatement();

            List<BaseCommissionEmployeeDetails> list = new ArrayList<>();
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
                    "\t`Practice`.`test` WHERE TYPE = " + Type.BASE_PLUS_COMMISSION_EMPLOYEE.ordinal() + "");
            while (resultSet.next()) {
                BaseCommissionEmployeeDetails baseCommissionEmployeeDetails = new BaseCommissionEmployeeDetails();
                baseCommissionEmployeeDetails.setName(resultSet.getString("Name"));
                baseCommissionEmployeeDetails.setEmployeeId(resultSet.getInt("Emp_Id"));
                baseCommissionEmployeeDetails.setPhoneNo(resultSet.getLong("Phn_No"));
                baseCommissionEmployeeDetails.setCommissionRate(resultSet.getDouble("Commission_Rate"));
                baseCommissionEmployeeDetails.setGrossSell(resultSet.getDouble("Gross_Sell"));
                baseCommissionEmployeeDetails.setSalary(resultSet.getInt("Base_Salary"));
                baseCommissionEmployeeDetails.setType(MyTypes.getMyType((resultSet.getInt("type"))));
                list.add(baseCommissionEmployeeDetails);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    public void showMyReports(List<BaseCommissionEmployeeDetails> baseCommissionEmployeeDetailsList) {
        System.out.println("Name" + Constants.SPACE +
                "EMP ID" + Constants.SPACE +
                "Phone Number" + Constants.SPACE +
                "COmmission Rate" + Constants.SPACE +
                "Gross sell" + Constants.SPACE +
                "Salary"+Constants.SPACE+
                "Type");
        System.out.println(Constants.DASH + Constants.DASH);
        for (BaseCommissionEmployeeDetails baseCommissionEmployeeDetails : baseCommissionEmployeeDetailsList) {
            System.out.println(baseCommissionEmployeeDetails.getName() + Constants.SPACE +
                    baseCommissionEmployeeDetails.getEmployeeId() + Constants.SPACE +
                    baseCommissionEmployeeDetails.getPhoneNo() + Constants.SPACE +
                    baseCommissionEmployeeDetails.getCommissionRate() + Constants.SPACE + Constants.SPACE +
                    baseCommissionEmployeeDetails.getGrossSell() + Constants.SPACE +
                    baseCommissionEmployeeDetails.getSalary()+Constants.SPACE+
                    baseCommissionEmployeeDetails.getType()
            );


        }
    }
}
