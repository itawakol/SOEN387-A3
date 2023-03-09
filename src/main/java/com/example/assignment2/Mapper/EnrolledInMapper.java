package com.example.assignment2.Mapper;
import com.example.assignment2.Bean.EnrolledIn;
import com.example.assignment2.Bean.Student;

public class EnrolledInMapper extends InheritanceMapper{


    public static String Insert(EnrolledIn enrolledIn, String courseCode, String courseNumber) {
        String insert = "UPDATE enrolledIn SET "+ courseNumber + " '=' " +courseCode+"' WHERE studentID='" + enrolledIn.getStudentID()+"'";
        return insert;
    }

    public String InsertStudent(Student student){

        String insert = "INSERT INTO enrolledIn(studentID, courseCode1, courseCode2, courseCode3, courseCode4, courseCode5) VALUES ('"+student.getStudentID()+"','','','','','')";
        return insert;
    }


    public static String Delete(EnrolledIn student, String courseNumber, String courseCode ) {

        String delete= "UPDATE enrolledIn SET " +courseNumber+ " = ' '   WHERE studentID='"+student.getStudentID()+"'AND courseCode1 ='" + courseCode+"'";
        return delete;
    }


    public String Find (EnrolledIn enrolledIn) {
        String find = "SELECT studentID, courseCode1, courseCode2, courseCode3, courseCode4,courseCode5 FROM enrolledIn WHERE studentID ="+enrolledIn.getStudentID();
        return find;
    }

    public String FindCourseList(EnrolledIn enrolledIn) {
        String find = "SELECT studentID, courseCode1, courseCode2, courseCode3, courseCode4, courseCode5 FROM enrolledIn WHERE studentID=" + enrolledIn.getStudentID();
        return find;
    }


}

