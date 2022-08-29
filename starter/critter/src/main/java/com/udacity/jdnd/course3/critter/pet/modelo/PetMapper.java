package com.udacity.jdnd.course3.critter.pet.modelo;

import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import com.udacity.jdnd.course3.critter.ModelMapper;
import com.udacity.jdnd.course3.critter.schedule.modelo.Schedule;
import com.udacity.jdnd.course3.critter.schedule.modelo.ScheduleDTO;
import com.udacity.jdnd.course3.critter.user.modelo.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper extends ModelMapper<Pet, PetDTO> {

    @Mapping(target = "ownerId", source = "pet.customer.id")
    PetDTO toDto(Pet pet);

    @Mapping(target = "customer.id", source = "petDTO.ownerId")
    Pet toEntity(PetDTO petDTO);

}
