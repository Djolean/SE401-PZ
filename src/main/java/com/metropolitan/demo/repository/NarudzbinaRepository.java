package com.metropolitan.demo.repository;

import com.metropolitan.demo.entity.Narudzbina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarudzbinaRepository extends JpaRepository<Narudzbina, Integer> {

}