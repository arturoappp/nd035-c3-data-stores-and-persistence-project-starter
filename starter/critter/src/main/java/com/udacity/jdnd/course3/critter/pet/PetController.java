package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.pet.modelo.Pet;
import com.udacity.jdnd.course3.critter.pet.modelo.PetDTO;
import com.udacity.jdnd.course3.critter.pet.modelo.PetMapper;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.udacity.jdnd.course3.critter.ResponseUtil.okOrNotFound;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    public PetMapper mapper;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {

        Pet pet = petService.savePet(mapper.toEntity(petDTO));

        PetDTO result = mapper.toDto(pet);
        return okOrNotFound(result).getBody();
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Pet pet = petService.getPet(petId);

        PetDTO result = mapper.toDto(pet);
        return okOrNotFound(result).getBody();
    }

    @GetMapping
    public List<PetDTO> getPets() {
        List<Pet> pets = petService.getPets();
        List<PetDTO> result = mapper.toDto(pets);
        return okOrNotFound(result).getBody();
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> pets = petService.getPetsByOwner(ownerId);
        List<PetDTO> result = mapper.toDto(pets);
        return okOrNotFound(result).getBody();
    }
}
