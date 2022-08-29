package com.udacity.jdnd.course3.critter.pet.modelo;

import com.udacity.jdnd.course3.critter.schedule.modelo.EntityBase;
import com.udacity.jdnd.course3.critter.user.modelo.Customer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents the form that pet request and response data takes. Does not map
 * to the database directly.
 */
@Data
@Entity
public class Pet extends EntityBase implements Serializable {

    private PetType type;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne( cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Customer customer;

    private LocalDate birthDate;

    private String notes;
}
