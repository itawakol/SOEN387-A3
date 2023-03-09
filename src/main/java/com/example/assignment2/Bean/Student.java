package com.example.assignment2.Bean;

import java.io.Serializable;

public class Student extends Person implements Serializable {

    private static final long serialVersionUID = 1;
    String ID;


    public String getStudentID() {
        return ID;
    }

    public void setStudentID(String ID) {
        this.ID = ID;
    }
}


