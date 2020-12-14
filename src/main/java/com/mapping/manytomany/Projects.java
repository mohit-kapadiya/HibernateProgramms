package com.mapping.manytomany;

import com.embedding.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Projects {
    @Id
    int id;
    String projectName;
    @ManyToMany
    List<Employees> employeeList;

    public void setId(int id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setEmployeeList(List<Employees> employeeList) {
        this.employeeList = employeeList;
    }
}
