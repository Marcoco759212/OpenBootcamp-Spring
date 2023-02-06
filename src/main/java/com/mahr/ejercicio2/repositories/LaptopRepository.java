package com.mahr.ejercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahr.ejercicio2.entities.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{

}
