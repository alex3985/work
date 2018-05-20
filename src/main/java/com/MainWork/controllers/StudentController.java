package com.MainWork.controllers;


import com.MainWork.modules.users.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/")
    public LinkedList<Student> getAllStudent() throws SQLException {
        Statement stm = dataSource.getConnection().createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM public.student");
        LinkedList<Student> students = new LinkedList<>();
        while (rs.next()){
            students.add(new Student(rs.getInt(1) , rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
        }
        rs.close();
        stm.close();
        dataSource.getConnection().close();
        return students;
    }

    @RequestMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable(value="id") int id) throws SQLException{
        Statement stm = dataSource.getConnection().createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM public.student WHERE studentid="+id);
        rs.next();
        Student student = new Student(rs.getInt(1) , rs.getString(2), rs.getString(3), rs.getString(4),
                rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
        rs.close();
        stm.close();
        dataSource.getConnection().close();
        return student;
    }

    @RequestMapping("/initials/{id}")
    public Student getStudentNameById(@PathVariable(value="id") int id) throws SQLException{
        Statement stm = dataSource.getConnection().createStatement();
        ResultSet rs = stm.executeQuery("SELECT name, surname,patronymic FROM public.student WHERE studentid="+id);
        rs.next();
        Student student = new Student(-1, rs.getString(1), rs.getString(2), rs.getString(3),
                null,null,null,-1);
        rs.close();
        stm.close();
        dataSource.getConnection().close();
        return student;
    }
}
