package com.mahr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahr.entities.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{

}
