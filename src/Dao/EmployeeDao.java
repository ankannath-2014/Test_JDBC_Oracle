package Dao;

// All the necessary imports
import Entity.Employee;
import JdbcConfig.DataBaseConfig;

import java.sql.*;
import java.util.List;

// Class for all Database operations
public class EmployeeDao {

    private Connection con;
    private Statement statement;
    private PreparedStatement pstmt;
    private ResultSet rs;

    //Constructor to create an Database Config object and initialize the Connection Object to work with it
    public EmployeeDao(){
        DataBaseConfig config = new DataBaseConfig();
        this.con = config.Config();

    }

    // Insert Function takes Employee object and inserts the corresponding attributes
    public void rcrInsert(Employee employee){
        String query="insert into tblemployee values(?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,employee.getEmpid());
            pstmt.setString(2,employee.getEmpname());
            pstmt.setDouble(3,employee.getEmpsalary());
            pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    // Update Function takes Employee object and updates the corresponding attributes
    public void rcrUpdate(Employee employee){

        String query="update tblemployee set empname=?,empsalary=? where empid=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,employee.getEmpname());
            pstmt.setDouble(2,employee.getEmpsalary());
            pstmt.setInt(3,employee.getEmpid());
            pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Delete Function for deletion of a record with a given employee id
    public void rcrDelete(int empid){
        String query="delete from tblemployee where empid=?";
        try {
            pstmt = con.prepareStatement(query);

            pstmt.setInt(1,empid);
            pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    // Retrieving a unique data or record for a given employee id
    public void getEmployee(int empid){
        String query="select *  from tblemployee where empid=?";
        try {
            pstmt = con.prepareStatement(query);

            pstmt.setInt(1,empid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println(rs.getInt("empid")+" "+rs.getString("empname")+" "+rs.getString("empsalary"));
            }
            else {
                System.out.println("Record not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Retrieving all the employee data and showing them
    public void getAllEmployee(){
        String msgsql = "Select * from tblemployee";
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(msgsql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        try {
            while (rs.next()) {

                System.out.println(rs.getInt("empid") + " " + rs.getString("empname") + " " + rs.getString("empsalary"));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }


}
