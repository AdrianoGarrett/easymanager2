package com.easy.easymanager2.repository;

import com.easy.easymanager2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from dim_customers where company_id = :companyId", nativeQuery = true)
    List<Customer> findByCompanyId(int companyId);
}
