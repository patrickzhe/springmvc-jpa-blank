package com.example.mvc.repository;

import com.example.mvc.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hzchenzhe1 on 2016/5/13.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
