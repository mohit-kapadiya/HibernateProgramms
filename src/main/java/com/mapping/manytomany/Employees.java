package com.mapping.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Employees {
    @Id
    int id;
    String name;
    @ManyToMany
    List<Projects> projects;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }
}
