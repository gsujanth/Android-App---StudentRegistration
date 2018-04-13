/*
  Author : Sujanth Babu Guntupalli
*/

package com.example.princ.inclass03;

import java.io.Serializable;

public class Student implements Serializable{
    String name;
    String email;
    String department;
    String mood;
    int checkedId;

    public Student(String name, String email, String department, String mood) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.mood = mood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCheckedId() {
        return checkedId;
    }

    public void setCheckedId(int checkedId) {
        this.checkedId = checkedId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
