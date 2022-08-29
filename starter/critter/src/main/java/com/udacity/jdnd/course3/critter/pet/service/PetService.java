package com.udacity.jdnd.course3.critter.pet.service;

import com.udacity.jdnd.course3.critter.pet.exception.PetNoFoundException;
import com.udacity.jdnd.course3.critter.pet.modelo.Pet;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.exception.CustomerNoFoundException;
import com.udacity.jdnd.course3.critter.user.modelo.Customer;
import com.udacity.jdnd.course3.critter.user.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository repository;
    @Autowired
    CustomerRepository customerRepository;

    public Pet savePet(Pet pet) {
        Customer customer = customerRepository.findById(pet.getCustomer().getId())
                .orElseThrow(CustomerNoFoundException::new);

        pet.setCustomer(customer);
        Pet savePet = repository.save(pet);
        if (customer.getPets() == null) {
            customer.setPets(new ArrayList<>());
        }
        customer.getPets().add(savePet);
        customerRepository.save(customer);

        return savePet;
    }

    public Pet getPet(long petId) {
        Optional<Pet> pet = repository.findById(petId);

        return pet.orElseThrow(PetNoFoundException::new);
    }

    public List<Pet> getPets() {
        return repository.findAll();
    }

    public List<Pet> getPetsByOwner(long ownerId) {
        return repository.findPetsByCustomer_Id(ownerId);
    }
}
