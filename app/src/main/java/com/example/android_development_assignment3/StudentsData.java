package com.example.android_development_assignment3;



public class StudentsData {
    public String name, address, faculty, semester;
    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "StudentsData{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", faculty='" + faculty + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}