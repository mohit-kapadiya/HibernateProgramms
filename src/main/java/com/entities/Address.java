package com.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private boolean isOpen;
    @Transient
    private Double x;
    @Temporal(TemporalType.DATE)
    private Date addDate;


    public void setCity(String city) {
        this.city = city;
    }


    public void setOpen(boolean open) {
        isOpen = open;
    }


    public void setX(Double x) {
        this.x = x;
    }


    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", isOpen=" + isOpen +
                ", x=" + x +
                ", addDate=" + addDate +
                '}';
    }
}
