package com.example.assignment2.Mapper;
import com.example.assignment2.Bean.Student;

public class StudentMapper extends InheritanceMapper {

    public String Find(String studentID) {

        String find="SELECT * FROM student WHERE studentID= '" +studentID+ "'";
        return find;
    }

    public String Insert() {

        String insert="INSERT INTO student (studentID, firstName, lastName, address, email, phoneNumber, dateOfBirth) VALUES  (?, ?, ?, ?, ?,?,?)";
        return insert;
    }


}
