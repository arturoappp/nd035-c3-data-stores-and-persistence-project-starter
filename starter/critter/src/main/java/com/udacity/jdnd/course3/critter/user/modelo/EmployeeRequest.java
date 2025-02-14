package com.udacity.jdnd.course3.critter.user.modelo;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

/**
 * Represents a request to find available employees by skills. Does not map
 * to the database directly.
 */

@Data
public class EmployeeRequest {
    private Set<EmployeeSkill> skills;
    private LocalDate date;
}
