package com.MainWork.modules.authorization;

public class User {
    private int Id;
    private String Login;
    private String Password;
    private int Id_student;
    private int Id_coach;
    private int Id_admin;

    public User(int id, String login, String password, int id_student, int id_coach, int id_admin) {
        Id = id;
        Login = login;
        Password = password;
        Id_student = id_student;
        Id_coach = id_coach;
        Id_admin = id_admin;
    }

    public int getId_admin() {
        return Id_admin;
    }

    public void setId_admin(int id_admin) {
        Id_admin = id_admin;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId_student() {
        return Id_student;
    }

    public void setId_student(int id_student) {
        Id_student = id_student;
    }

    public int getId_coach() {
        return Id_coach;
    }

    public void setId_coach(int id_coach) {
        Id_coach = id_coach;
    }
}
