package com.example.adm.controller;

import com.example.adm.model.Attendance;
import com.example.adm.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping
    public String getAllAttendances(Model model) {
        List<Attendance> attendances = attendanceRepository.getAttendances();
        model.addAttribute("attendances", attendances);
        return "attendances/list";
    }

    @GetMapping("/{id}")
    public String getAllAttendanceById(@PathVariable int id, Model model) {
        Attendance attendance = attendanceRepository.getAttendanceById(id);
        if (attendance != null) {
            model.addAttribute("attendance", attendance);
            return "attendances/detail";
        }
        return "error";
    }
}
