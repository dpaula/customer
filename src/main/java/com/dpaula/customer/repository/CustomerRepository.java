package com.dpaula.customer.repository;

import com.dpaula.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fernando de Lima on 29/07/22
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
