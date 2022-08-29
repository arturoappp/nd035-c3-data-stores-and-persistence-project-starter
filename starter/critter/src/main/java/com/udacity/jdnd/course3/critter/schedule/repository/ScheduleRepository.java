package com.udacity.jdnd.course3.critter.schedule.repository;

import com.udacity.jdnd.course3.critter.pet.modelo.Pet;
import com.udacity.jdnd.course3.critter.schedule.modelo.Schedule;
import com.udacity.jdnd.course3.critter.user.modelo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> getSchedulesByPetsContains(Pet pet);

    List<Schedule> getSchedulesByPetsIn(List<Pet> pets);
    List<Schedule> getSchedulesByEmployeesContains(Employee employee);

}
