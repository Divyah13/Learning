package Streams;

import java.math.BigDecimal;
import java.util.List;

public class Employee {
    String fname;
    String lname;
    BigDecimal salary;
    List<String> projects;

    public Employee(String fname, String lname, BigDecimal salary, List<String> projects) {
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.projects = projects;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}


