package com.codegym.hotelmanagement.repository;

import com.codegym.hotelmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("from Customer c where c.fullName = :fullName " +
            "and c.phoneNumber = :phoneNumber " +
            "and c.citizenIdentityCard = :citizenIdentityCard")
    public Customer searchCustomer(@Param("fullName") String fullName,
                                   @Param("phoneNumber") String phoneNumber,
                                   @Param("citizenIdentityCard") String citizenIdentityCard);

    @Query("SELECT max(id) FROM Customer ")
    public Long getNewId();
}
