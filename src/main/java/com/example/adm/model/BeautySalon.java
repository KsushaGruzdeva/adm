package com.example.adm.model;

import java.util.ArrayList;
import java.util.List;

public class BeautySalon {
    private int id;
    private String name;
    private String address;
    private String email;
    private List<Attendance> attendances = new ArrayList<>();

    protected BeautySalon() {}

    public BeautySalon (int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances.addAll(attendances);
    }

    public void setAttendance(Attendance attendance) {
        this.attendances.add(attendance);
    }
}
