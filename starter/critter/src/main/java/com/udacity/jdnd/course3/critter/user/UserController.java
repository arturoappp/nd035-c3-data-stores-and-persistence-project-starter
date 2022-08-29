package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.user.modelo.*;
import com.udacity.jdnd.course3.critter.user.server.CustomerService;
import com.udacity.jdnd.course3.critter.user.server.EmployeeService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import static com.udacity.jdnd.course3.critter.ResponseUtil.okOrNotFound;

/**
 * Handles web requests related to Users.
 * <p>
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.saveCustomer(customerMapper.toEntity(customerDTO));

        val result = customerMapper.toDto(customer);
        return okOrNotFound(result).getBody();
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> customers = customerService.getAllCustomers();
        val customerDTOS = customerMapper.toDto(customers);

        return okOrNotFound(customerDTOS).getBody();
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId) {
        Customer customer = customerService.getOwnerByPet(petId);
        val result = customerMapper.toDto(customer);

        return okOrNotFound(result).getBody();
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.saveEmployee(employeeMapper.toEntity(employeeDTO));

        val result = employeeMapper.toDto(employee);
        return okOrNotFound(result).getBody();
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);

        val result = employeeMapper.toDto(employee);
        return okOrNotFound(result).getBody();
    }

    @PutMapping("/employee/{employeeId}")
    public EmployeeDTO setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        Employee employee = employeeService.setAvailability(daysAvailable, employeeId);

        val result = employeeMapper.toDto(employee);
        return okOrNotFound(result).getBody();
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        List<Employee> employees = employeeService.findEmployeesForService(employeeMapper.toEntity(employeeRequestDTO));

        val result = employeeMapper.toDto(employees);
        return okOrNotFound(result).getBody();
    }

}
