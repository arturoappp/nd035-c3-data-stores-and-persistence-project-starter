package com.udacity.jdnd.course3.critter.user.repository;

import com.udacity.jdnd.course3.critter.user.modelo.Employee;
import com.udacity.jdnd.course3.critter.user.modelo.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee>  findAllByDaysAvailable( DayOfWeek dayOfWeek);

    List<Employee>  getEmployeesByIdIn( List<Long> ids);

}
