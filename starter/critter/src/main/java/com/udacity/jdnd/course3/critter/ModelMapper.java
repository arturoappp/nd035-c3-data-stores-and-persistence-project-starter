package com.udacity.jdnd.course3.critter;

import com.udacity.jdnd.course3.critter.schedule.modelo.EntityBase;
import org.mapstruct.Named;

import java.util.List;

public interface ModelMapper<T, TDTO> {

    String getIdFromEntity = "getIdFromEntity";
    String getEntityFromDtoId = "getEntityFromDtoId";

    TDTO toDto(T model);

    T toEntity(TDTO modelDTO);

    List<TDTO> toDto(List<T> modelList);

    List<T> toEntity(List<TDTO> modelList);

    @Named(getIdFromEntity)
    static <D extends EntityBase> Long getIdFromEntity(D dependencyModel) {
        return dependencyModel.getId();
    }

}
