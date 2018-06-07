package com.company;

import com.company.BaseCommissionEmployee.BaseCommissionEmployee;
import com.company.BaseCommissionEmployee.BaseCommissionEmployeeDetails;
import com.company.CommissionEmployee.CommissionEmployeeDetails;
import com.company.CommissionEmployee.CommoissionEmployee;
import com.company.Common.Constants;
import com.company.HourlyEmployee.HourlyEmployee;
import com.company.HourlyEmployee.HourlyEmployeeDetails;
import com.company.SalaryEmployee.SalaryEmployee;
import com.company.SalaryEmployee.SalaryEmployeeDetails;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //Main main=new Main();
        usingSwitch();

    }
    public static void usingSwitch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose::");
        System.out.println("Press 1 for Commission Employee");
        System.out.println("Press 2 for Salary Employee::");
        System.out.println("Press 3 for Hourly Employee::");
        System.out.println("Press 4 for Base Commission Employee::");
        System.out.println("Press 5 for Invoice::");
        System.out.println("Press 6 for Exit");
        switch (scanner.nextInt()) {
            case 1:
                forCommissionEmployee();
                break;
            case 2:
                forSalaryEmployee();
                break;
            case 3:
                forHourlyEmployee();
                break;
            case 4:
                forBaseCommissionEmployee();
                break;
            case 5:
                forInvoice();
                break;
            case 6:
                break;
            default:
                System.out.println("Please Enter a valid case::");
                break;
        }

    }


        /*//Playing with interface..
        Invoice invoice = new Invoice();
        System.out.println("Reading into Invoice");
        invoice.readIntoInvoice();
        invoice.display();
*/

        // Operations With CommoissionEmployee

        /*CommoissionEmployee commissionEmployee = new CommoissionEmployee();
        System.out.println("Reading commission employee detail....");
        //CommoissionEmployee commoissionEmployee1 = commissionEmployee.readCommissionEmployee();


        System.out.println("Inserting into table....");
        //commissionEmployee.InsertingIntoCommissionEmployee(commoissionEmployee1);

        System.out.println("Fetching commission empoyee report...");
        List<CommissionEmployeeDetails> detailsList = commissionEmployee.getMyReport();

        System.out.println("printing report....");
        commissionEmployee.showMyReport(detailsList);


        //Operations With HourlyEmployee
        HourlyEmployee hourlyEmployee=new HourlyEmployee();
        //System.out.println("Reading Hourly employee Details");
        //HourlyEmployee hourlyEmployee1=hourlyEmployee.readHourlyEmployee();

        System.out.println("Inserting into table");
        //hourlyEmployee.insertingIntoHourlyEmployee(hourlyEmployee1);

        System.out.println("Fetching hourly empoyee report...");
        List<HourlyEmployeeDetails> hourlyEmployeeDetailsList = hourlyEmployee.getMyReport();

        System.out.println("printing report....");
        hourlyEmployee.showMyReport(hourlyEmployeeDetailsList);

        //Operations with SalaryEmployee

        SalaryEmployee salaryEmployee=new SalaryEmployee();

        System.out.println("Reading Salary employee detail....");
        //SalaryEmployee salaryEmployee1 = salaryEmployee.readSalaryEmployee();

        System.out.println("Inserting into table");
        //salaryEmployee.insertingIntoSalaryEmployee(salaryEmployee1);

        System.out.println("Fetching salary empoyee report...");
        List<SalaryEmployeeDetails> salaryEmployeeDetailsList = salaryEmployee.getMyReport();

        System.out.println("printing report....");
        salaryEmployee.showMyReport(salaryEmployeeDetailsList);

        //Operation with BaseCommissionEmployee

        BaseCommissionEmployee baseCommissionEmployee=new BaseCommissionEmployee();

        //System.out.println("Reading BaseCommission Employee");
        //BaseCommissionEmployee baseCommissionEmployee1=baseCommissionEmployee.readBaseEmployee();

        System.out.println("Inserting into Table");
        //baseCommissionEmployee.insertingIntoBaseCommissionEmployee(baseCommissionEmployee1);

        System.out.println("Fetching BaseCommissionEmployee report");
        List<BaseCommissionEmployeeDetails> baseCommissionEmployeeDetailsList = baseCommissionEmployee.getMyReports();

        System.out.println("printing report....");
        baseCommissionEmployee.showMyReports(baseCommissionEmployeeDetailsList);
*/



    private static void forHourlyEmployee() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Hourly Employee");
        System.out.println("Press 1 for Reading Value::");
        System.out.println("Press 2 for Displaying Report");
        System.out.println("Press 3 to go Previous page");
        switch (scanner.nextInt()){
            case 1:
                HourlyEmployee hourlyEmployee=new HourlyEmployee();
                Main holder=new Main();
                System.out.println("Reading Hourly employee Details");
                HourlyEmployee hourlyEmployee1=hourlyEmployee.readHourlyEmployee();
                System.out.println("Inserting into table");
                hourlyEmployee.insertingIntoHourlyEmployee(hourlyEmployee1);
                System.out.println("Inserted Successfully");
                System.out.println(Constants.DASH);
                holder.forHourlyEmployee();
                break;
            case 2:
                HourlyEmployee hourlyEmployee2=new HourlyEmployee();
                Main holder1=new Main();
                System.out.println("Fetching hourly empoyee report...");
                List<HourlyEmployeeDetails> hourlyEmployeeDetailsList = hourlyEmployee2.getMyReport();

                System.out.println("printing report....");
                hourlyEmployee2.showMyReport(hourlyEmployeeDetailsList);
                holder1.forHourlyEmployee();
                break;
            case 3:
                Main abc=new Main();
                abc.usingSwitch();
                break;
            default:
                System.out.println("Please Enter Correct option...");
                break;
        }

    }

    private static void forBaseCommissionEmployee() {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Base Commission Employee");
        System.out.println("Press 1 for Reading Value::");
        System.out.println("Press 2 for Displaying Report");
        System.out.println("Press 3 to go Previous page");
        switch (scanner.nextInt()) {
            case 1:
                BaseCommissionEmployee baseCommissionEmployee=new BaseCommissionEmployee();
                System.out.println("Reading BaseCommission Employee");
                BaseCommissionEmployee baseCommissionEmployee1=baseCommissionEmployee.readBaseEmployee();

                System.out.println("Inserting into Table");
                baseCommissionEmployee.insertingIntoBaseCommissionEmployee(baseCommissionEmployee1);
                break;
            case 2:
                BaseCommissionEmployee baseCommissionEmployee2=new BaseCommissionEmployee();
                System.out.println("Fetching BaseCommissionEmployee report");
                List<BaseCommissionEmployeeDetails> baseCommissionEmployeeDetailsList = baseCommissionEmployee2.getMyReports();

                System.out.println("printing report....");
                baseCommissionEmployee2.showMyReports(baseCommissionEmployeeDetailsList);
                break;
            case 3:
                Main abc=new Main();
                abc.usingSwitch();
                break;
            default:
                System.out.println("Please Enter Correct option...");
                break;
        }

    }
    private static void forInvoice() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Invoice");
        System.out.println("Press 1 for Reading Value::");
        System.out.println("Press 2 for Displaying Report");
        System.out.println("Press 3 to go Previous page");
        switch (scanner.nextInt()) {
            case 1:
                Invoice invoice = new Invoice();
                System.out.println("Reading into Invoice");
                invoice.readIntoInvoice();
                break;
            case 2:
                Invoice invoice1 = new Invoice();
                invoice1.display();
                break;
            case 3:
                Main abc=new Main();
                abc.usingSwitch();
                break;
            default:
                System.out.println("Please Enter Correct option...");
                break;

        }

    }

    private static void forSalaryEmployee() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Salary Employee");
        System.out.println("Press 1 for Reading Value::");
        System.out.println("Press 2 for Displaying Report");
        System.out.println("Press 3 to go Previous page");

        switch (scanner.nextInt()){
            case 1:
                SalaryEmployee salaryEmployee=new SalaryEmployee();

                System.out.println("Reading Salary employee detail....");
                SalaryEmployee salaryEmployee1 = salaryEmployee.readSalaryEmployee();

                System.out.println("Inserting into table");
                salaryEmployee.insertingIntoSalaryEmployee(salaryEmployee1);
                break;
            case 2:
                SalaryEmployee salaryEmployee2=new SalaryEmployee();
                System.out.println("Fetching salary empoyee report...");
                List<SalaryEmployeeDetails> salaryEmployeeDetailsList = salaryEmployee2.getMyReport();

                System.out.println("printing report....");
                salaryEmployee2.showMyReport(salaryEmployeeDetailsList);
                break;
            case 3:
                Main abc=new Main();
                abc.usingSwitch();
                break;
            default:
                System.out.println("Please Enter Correct option...");
                break;
        }
    }

    private static void forCommissionEmployee() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Commission Employee");
        System.out.println("Press 1 for Reading Value::");
        System.out.println("Press 2 for Displaying Report");
        System.out.println("Press 3 to go Previous page");

        switch (scanner.nextInt()){
            case 1:
                CommoissionEmployee commissionEmployee = new CommoissionEmployee();
                System.out.println("Reading commission employee detail....");
                CommoissionEmployee commoissionEmployee1 = commissionEmployee.readCommissionEmployee();
                System.out.println("Inserting into table....");
                commissionEmployee.InsertingIntoCommissionEmployee(commoissionEmployee1);
                break;
            case 2:
                CommoissionEmployee commissionEmployee1 = new CommoissionEmployee();
                System.out.println("Fetching commission empoyee report...");
                List<CommissionEmployeeDetails> detailsList = commissionEmployee1.getMyReport();
                System.out.println("printing report....");
                commissionEmployee1.showMyReport(detailsList);
                break;
            case 3:
                Main abc=new Main();
                abc.usingSwitch();
                break;
                default:
                    System.out.println("Please Enter Correct option...");
                    break;
        }
    }
}

