package com.udacity.jdnd.course3.critter.user.modelo;

import com.udacity.jdnd.course3.critter.schedule.modelo.EntityBase;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.util.Set;

/**
 * Represents the form that employee request and response data takes. Does not map
 * to the database directly.
 */
@Data
@Entity
public class Employee extends EntityBase {

    @NotNull
    private String name;

    @Column(nullable = false)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> skills;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> daysAvailable;
}
