package com.restapi.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Employee")
public class Employee {

    public  Employee() {

    }

    private  int empid;

    private  String empname;

    private  String empsalary;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(String empsalary) {
        this.empsalary = empsalary;
    }


    public Employee(int empid, String empname, String empsalary) {
        this.empid = empid;
        this.empname = empname;
        this.empsalary = empsalary;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Employee) obj;
        return this.empid == that.empid &&
                Objects.equals(this.empname, that.empname) &&
                Objects.equals(this.empsalary, that.empsalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empid, empname, empsalary);
    }

    @Override
    public String toString() {
        return "Employee[" +
                "empid=" + empid + ", " +
                "empname=" + empname + ", " +
                "empsalary=" + empsalary + ']';
    }


}
