package com.embedding;

import javax.persistence.Embeddable;

@Embeddable
public class Car {
    private String carName;
    private String price;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}


