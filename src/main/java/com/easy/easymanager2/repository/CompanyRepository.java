package com.easy.easymanager2.repository;

import com.easy.easymanager2.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "SELECT dc.* FROM dim_companies dc JOIN dim_user_companies duc ON dc.id = duc.company_id WHERE duc.user_id = :userId", nativeQuery = true)
    List<Company> findByUserId(@Param("userId") int userId);
}
