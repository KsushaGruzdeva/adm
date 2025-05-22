package com.example.adm;

import com.example.adm.model.Attendance;
import com.example.adm.model.BeautySalon;
import com.example.adm.repository.AttendanceRepository;
import com.example.adm.repository.BeautySalonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AttendanceRepository attendanceRepository;
    private final BeautySalonRepository beautySalonRepository;

    public DataLoader(AttendanceRepository attendanceRepository, BeautySalonRepository beautySalonRepository) {
        this.attendanceRepository = attendanceRepository;
        this.beautySalonRepository = beautySalonRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Attendance attendance1 = new Attendance(1, "Маникюр", 1000);
        Attendance attendance2 = new Attendance(2, "Массаж", 1500);
        Attendance attendance3 = new Attendance(3, "Педикюр", 2000);
        Attendance attendance4 = new Attendance(4, "Стрижка", 1400);
        attendanceRepository.create(attendance1);
        attendanceRepository.create(attendance2);
        attendanceRepository.create(attendance3);
        attendanceRepository.create(attendance4);

        beautySalonRepository.create(new BeautySalon(1, "Алмаз", "какой-то адрес", "almaz@mail.com"));
        beautySalonRepository.addAttendance(1, attendance1);
        beautySalonRepository.addAttendance(1, attendance2);
        beautySalonRepository.create(new BeautySalon(2, "Beauty", "какой-то адрес", "beauty@mail.com"));
        beautySalonRepository.addAttendance(2, attendance3);
        beautySalonRepository.addAttendance(2, attendance2);
        beautySalonRepository.addAttendance(2, attendance4);
    }
}
