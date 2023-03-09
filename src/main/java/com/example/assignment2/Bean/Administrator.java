package com.example.assignment2.Bean;

import java.io.Serializable;

public class Administrator extends Person implements Serializable {

    private static final long serialVersionUID = 1;

    String ID;

    public String getEmploymentID() {
        return ID;
    }
    public void setEmploymentID(String ID) {
        this.ID = ID;
    }
}
