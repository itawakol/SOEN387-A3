package com.example.assignment2.Mapper;

public class CourseMapper extends InheritanceMapper {

    public String Insert() {

        String insert = "INSERT INTO course (courseCode, title, semester, days, times, instructor, room, startDate, endDate) VALUES  (?, ?, ?, ?, ?,?,?,?,?)";
        return insert;
    }

}
