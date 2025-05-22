package com.example.adm.repository;

import com.example.adm.model.Attendance;
import com.example.adm.model.BeautySalon;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BeautySalonRepository {
    private HashMap<Integer, BeautySalon> beautySalons = new HashMap<>();

    public BeautySalonRepository() {}

    public BeautySalonRepository(HashMap<Integer, BeautySalon> beautySalons) {
        this.beautySalons = beautySalons;
    }

    public List<BeautySalon> getBeautySalons() {
        return beautySalons.values().stream().toList();
    }

    public void create (BeautySalon beautySalon){
        this.beautySalons.put(beautySalon.getId(), beautySalon);
    }

    public void addAttendance (int beautySalonId, Attendance attendance) {
        BeautySalon beautySalon = this.beautySalons.get(beautySalonId);
        beautySalon.setAttendance(attendance);
    }

    public BeautySalon getBeautySalonById(int id) {
        return beautySalons.get(id);
    }
}
