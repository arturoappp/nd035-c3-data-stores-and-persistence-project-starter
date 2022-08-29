package com.udacity.jdnd.course3.critter.user.modelo;

import com.udacity.jdnd.course3.critter.ModelMapper;
import com.udacity.jdnd.course3.critter.pet.modelo.Pet;
import lombok.val;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends ModelMapper<Customer, CustomerDTO> {

    @Mapping(target = "petIds", source = "pets", qualifiedByName = getIdFromEntity)
    CustomerDTO toDto(Customer customer);

    @Mapping(target = "pets", source = "petIds", qualifiedByName = getEntityFromDtoId)
    Customer toEntity(CustomerDTO customerDTO);

    @Named(getEntityFromDtoId)
    static Pet getEntityFromDtoId(long id) {
        val pet = new Pet();
        pet.setId(id);
        return pet;
    }

}
