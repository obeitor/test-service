package com.softobt.testservice.apimodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestModel{

    private String firstname;
    private String surname;
    private int age;
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty(value = "nameFromEmail")
    public String getFullName(){
        String name = email.replaceAll("@.*$","");
        name = name.replaceAll("\\."," ");
        return name;
    }

    public static TestModel createDummy(){
        TestModel tm = new TestModel();
        tm.age = 26;
        tm.firstname = "Abdulgafar";
        tm.surname = "Obeitor";
        tm.email = "aobeitor@yahoo.com";
        return tm;
    }

}
