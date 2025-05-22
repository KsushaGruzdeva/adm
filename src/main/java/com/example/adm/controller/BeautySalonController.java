package com.example.adm.controller;

import com.example.adm.model.BeautySalon;
import com.example.adm.repository.BeautySalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/beautySalon")
public class BeautySalonController {
    private final BeautySalonRepository beautySalonRepository;

    @Autowired
    public BeautySalonController(BeautySalonRepository beautySalonRepository) {
        this.beautySalonRepository = beautySalonRepository;
    }

    @GetMapping
    public String getAllAttendances(Model model) {
        List<BeautySalon> beautySalons = beautySalonRepository.getBeautySalons();
        model.addAttribute("beautySalons", beautySalons);
        return "beautySalons/list";
    }

    @GetMapping("/{id}")
    public String getAllAttendanceById(@PathVariable int id, Model model) {
        BeautySalon beautySalon = beautySalonRepository.getBeautySalonById(id);
        if (beautySalon != null) {
            model.addAttribute("beautySalon", beautySalon);
            return "beautySalons/detail";
        }
        return "error";
    }
}