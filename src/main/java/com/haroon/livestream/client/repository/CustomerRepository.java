package com.haroon.livestream.client.repository;

import com.haroon.livestream.client.model.CustomerCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerCopy,Long> {
}
