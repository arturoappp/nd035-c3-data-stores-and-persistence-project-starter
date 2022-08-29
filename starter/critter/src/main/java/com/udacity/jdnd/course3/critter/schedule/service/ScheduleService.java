package com.udacity.jdnd.course3.critter.schedule.service;

import com.google.common.collect.ImmutableList;
import com.udacity.jdnd.course3.critter.pet.exception.PetNoFoundException;
import com.udacity.jdnd.course3.critter.pet.modelo.Pet;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.schedule.modelo.EntityBase;
import com.udacity.jdnd.course3.critter.schedule.modelo.Schedule;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.exception.EmployeeNoFoundException;
import com.udacity.jdnd.course3.critter.user.modelo.Employee;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@Service
@Transactional
public class ScheduleService {
    @Autowired
    private ScheduleRepository repository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    public Schedule createSchedule(Schedule schedule) {
        List<Pet> petsByIdIn = petRepository.getPetsByIdIn(schedule.getPets().stream().map(EntityBase::getId).collect(Collectors.toList()));
        schedule.setPets(petsByIdIn);

        List<Employee> employeesByIdIn = employeeRepository.getEmployeesByIdIn(schedule.getEmployees().stream().map(EntityBase::getId).collect(Collectors.toList()));
        schedule.setEmployees(employeesByIdIn);

        return repository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return repository.findAll();
    }

    public List<Schedule> getScheduleForPet(long petId) {
        Pet pet = petRepository.findById(petId).orElseThrow(PetNoFoundException::new);
        return repository.getSchedulesByPetsContains(pet);
    }

    public List<Schedule> getScheduleForEmployee(long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(EmployeeNoFoundException::new);
        return repository.getSchedulesByEmployeesContains(employee);
    }

    public List<Schedule> getScheduleForCustomer(long customerId) {
        List<Pet> pets = petRepository.findPetsByCustomer_Id(customerId);
        if (pets.isEmpty()) {
            throw new PetNoFoundException();
        }

        return repository.getSchedulesByPetsIn(pets).stream().distinct().collect(Collectors.toList());
    }
}
