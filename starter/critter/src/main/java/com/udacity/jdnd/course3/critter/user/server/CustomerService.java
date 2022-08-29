package com.udacity.jdnd.course3.critter.user.server;

import com.udacity.jdnd.course3.critter.pet.modelo.Pet;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.exception.CustomerNoFoundException;
import com.udacity.jdnd.course3.critter.user.modelo.Customer;
import com.udacity.jdnd.course3.critter.user.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Handles web requests related to Users.
 * <p>
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    PetRepository petRepository;


    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getOwnerByPet(long petId) {
        Pet pets = petRepository.findById(petId).get();

        return repository.findById(pets.getCustomer().getId()).orElseThrow(CustomerNoFoundException::new);
    }
}
