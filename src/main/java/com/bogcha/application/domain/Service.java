package com.bogcha.application.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Service implements Serializable {
    @Id
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
