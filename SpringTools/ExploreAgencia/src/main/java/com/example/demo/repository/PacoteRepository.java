package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Pacote;

public interface PacoteRepository  extends JpaRepository<Pacote, Long>{

}
