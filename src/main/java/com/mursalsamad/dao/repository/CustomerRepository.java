package com.mursalsamad.dao.repository;

import com.mursalsamad.dao.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    Optional<CustomerEntity> findByPinAndFullNameAndPhoneNumber(String pin,String fullName,String phoneNumber);
    Optional<CustomerEntity> findByPinOrFullNameOrPhoneNumber(String pin,String fullName,String phoneNumber);
    Optional<CustomerEntity> findByPin(String pin);
    Optional<CustomerEntity> findByFullName(String fullName);
    Optional<CustomerEntity> findByPhoneNumber(String phoneNumber);

}
