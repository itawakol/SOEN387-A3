package com.example.assignment2.Mapper;
import com.example.assignment2.Bean.Administrator;

public class AdminMapper extends InheritanceMapper{

    public String Find(String employmentID) {

        String find="SELECT * FROM student WHERE employmentID= '"+employmentID+ "'";
        return find;
    }
    public String Insert() {

        String insert="INSERT INTO administrator (employmentID, firstName, lastName, address, email, phoneNumber, dateOfBirth) VALUES  (?, ?, ?, ?, ?,?,?)";
        return insert;
    }


}
