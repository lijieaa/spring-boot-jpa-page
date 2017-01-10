package com.github.lijieaa.dao;

import com.github.lijieaa.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by 95205 on 2017/1/10.
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
