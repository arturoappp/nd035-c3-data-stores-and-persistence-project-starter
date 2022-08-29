package com.udacity.jdnd.course3.critter.schedule.modelo;

import com.udacity.jdnd.course3.critter.ModelMapper;
import com.udacity.jdnd.course3.critter.pet.modelo.Pet;
import com.udacity.jdnd.course3.critter.user.modelo.Employee;
import lombok.val;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ScheduleMapper extends ModelMapper<Schedule, ScheduleDTO> {

    @Mapping(target = "employeeIds", source = "employees", qualifiedByName = getIdFromEntity)
    @Mapping(target = "petIds", source = "pets", qualifiedByName = getIdFromEntity)
    ScheduleDTO toDto(Schedule schedule);

    @Mapping(target = "employees", source = "scheduleDTO.employeeIds", qualifiedByName = getEntityFromDtoId)
    @Mapping(target = "pets", source = "scheduleDTO.petIds", qualifiedByName = getEntityFromDtoId)
    Schedule toEntity(ScheduleDTO scheduleDTO);

    @Named(getEntityFromDtoId)
    static Pet getEntityFromDtoIdPet(long id) {
        val pet = new Pet();
        pet.setId(id);
        return pet;
    }

    @Named(getEntityFromDtoId)
    static Employee getEntityFromDtoIdEmployee(long id) {
        val o = new Employee();
        o.setId(id);
        return o;
    }
}
