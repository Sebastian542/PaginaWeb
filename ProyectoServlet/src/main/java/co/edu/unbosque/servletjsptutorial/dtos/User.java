package co.edu.unbosque.servletjsptutorial.dtos;

import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName(column = "username")
    private String username;

    @CsvBindByName(column = "password")
    private String password;

    @CsvBindByName(column = "role")
    private String role;

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
