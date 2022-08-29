package com.udacity.jdnd.course3.critter.user.server;

import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.exception.EmployeeNoFoundException;
import com.udacity.jdnd.course3.critter.user.modelo.Employee;
import com.udacity.jdnd.course3.critter.user.modelo.EmployeeRequest;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Users.
 * <p>
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    PetRepository petRepository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee getEmployee(long employeeId) {
        return repository.findById(employeeId).orElseThrow(EmployeeNoFoundException::new);
    }

    public Employee setAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = repository.findById(employeeId).orElseThrow(EmployeeNoFoundException::new);
        employee.setDaysAvailable(daysAvailable);

        return repository.save(employee);
    }

    public List<Employee> findEmployeesForService(EmployeeRequest employeeRequest) {
        List<Employee> availableEmployees =
                repository.findAllByDaysAvailable(employeeRequest.getDate().getDayOfWeek());

        val result = availableEmployees.stream()
                .filter(employee -> employee.getSkills().containsAll(employeeRequest.getSkills()))
                .collect(Collectors.toList());
        return result;
    }
}
