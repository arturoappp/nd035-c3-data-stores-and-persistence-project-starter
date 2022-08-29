package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.schedule.modelo.Schedule;
import com.udacity.jdnd.course3.critter.schedule.modelo.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.modelo.ScheduleMapper;
import com.udacity.jdnd.course3.critter.schedule.service.ScheduleService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.udacity.jdnd.course3.critter.ResponseUtil.okOrNotFound;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleMapper mapper;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleService.createSchedule(mapper.toEntity(scheduleDTO));

        val result = mapper.toDto(schedule);
        return okOrNotFound(result).getBody();
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> schedule = scheduleService.getAllSchedules();

        val result = mapper.toDto(schedule);
        return okOrNotFound(result).getBody();
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<Schedule> schedule = scheduleService.getScheduleForPet(petId);

        val result = mapper.toDto(schedule);
        return okOrNotFound(result).getBody();
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<Schedule> schedule = scheduleService.getScheduleForEmployee(employeeId);

        val result = mapper.toDto(schedule);
        return okOrNotFound(result).getBody();
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<Schedule> schedule = scheduleService.getScheduleForCustomer(customerId);

        val result = mapper.toDto(schedule);
        return okOrNotFound(result).getBody();
    }
}
