package Test;

import Dao.EmployeeDao;
import Entity.Employee;
import JdbcConfig.DataBaseConfig;

public class TestJdbc {
    public static void main(String[] args) {
        // Creating a object of Employee Dao Class
        EmployeeDao empdao = new EmployeeDao();

        //Creating Employees and setting their attributes manually
        Employee empobj = new Employee();
        empobj.setEmpid(1);
        empobj.setEmpname("Ankan Nath");
        empobj.setEmpsalary(50000);

        Employee empobj2 = new Employee();
        empobj2.setEmpid(2);
        empobj2.setEmpname("Mini Mathur");
        empobj2.setEmpsalary(700000);

        Employee empobj3 = new Employee();
        empobj3.setEmpid(3);
        empobj3.setEmpname("Rohan Malhotra");
        empobj3.setEmpsalary(756000);

        // performing the various Crud Operations with the Employee Dao Object
        empdao.rcrInsert(empobj);
        empdao.rcrInsert(empobj2);
        empdao.rcrInsert(empobj3);

        System.out.println("Showing All Employee after Insert: ");
        empdao.getAllEmployee();


        empobj3.setEmpid(3);
        empobj3.setEmpname("Sandeep Tiwari");
        empobj3.setEmpsalary(100000);
        empdao.rcrUpdate(empobj3);

        System.out.println("Showing data of empid 3 after updating: ");
        empdao.getAllEmployee();


        empdao.rcrDelete(2);
        System.out.println("Showing data after deletion of empid 2: ");
        empdao.getAllEmployee();

        System.out.println("Showing data of only empid 1: ");
        empdao.getEmployee(1);

        System.out.println("Showing all the data after completing all the CRUD ops: ");
        empdao.getAllEmployee();



    }
}
