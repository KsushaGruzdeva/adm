package com.example.adm.repository;

import com.example.adm.model.Attendance;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class AttendanceRepository {
    private HashMap<Integer, Attendance> attendances = new HashMap<>();

    public AttendanceRepository() {}

    public AttendanceRepository(HashMap<Integer, Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<Attendance> getAttendances() {
        return attendances.values().stream().toList();
    }

    public void create (Attendance attendance){
        this.attendances.put(attendance.getId(), attendance);
    }

    public Attendance getAttendanceById(int id) {
        return attendances.get(id);
    }
}
