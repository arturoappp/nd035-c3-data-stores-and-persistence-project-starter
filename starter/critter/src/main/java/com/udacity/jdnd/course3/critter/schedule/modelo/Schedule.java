package com.udacity.jdnd.course3.critter.schedule.modelo;

import com.udacity.jdnd.course3.critter.pet.modelo.Pet;
import com.udacity.jdnd.course3.critter.user.modelo.Employee;
import com.udacity.jdnd.course3.critter.user.modelo.EmployeeSkill;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Represents the form that schedule request and response data takes. Does not map
 * to the database directly.
 */
@Data
@Entity
public class Schedule extends EntityBase {

    @Column(nullable = false)
    @ManyToMany
    @JoinColumn(name="employees")
    private List<Employee> employees;

    @Column(nullable = false)
    @ManyToMany
    @JoinColumn(name="pets")
    private List<Pet> pets;

    @Column(nullable = false)
    private LocalDate date;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> activities;



}
