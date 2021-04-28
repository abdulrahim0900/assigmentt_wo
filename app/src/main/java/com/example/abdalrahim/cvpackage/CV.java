package com.example.abdalrahim.cvpackage;

public class CV {
    private String Name;
    private String Email;


    public CV(){}
    public CV(String Name, String Email){
        this.Name = Name;
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public void setTitle(String title) {
        this.Name = title;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
