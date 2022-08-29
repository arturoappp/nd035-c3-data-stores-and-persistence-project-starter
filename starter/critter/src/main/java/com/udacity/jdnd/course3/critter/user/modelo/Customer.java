package com.udacity.jdnd.course3.critter.user.modelo;

import com.udacity.jdnd.course3.critter.pet.modelo.Pet;
import com.udacity.jdnd.course3.critter.schedule.modelo.EntityBase;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
@Data
@Entity
public class Customer extends EntityBase {
    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    private String notes;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Pet> pets = Collections.emptyList();
}
