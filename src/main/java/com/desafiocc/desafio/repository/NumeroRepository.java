package com.desafiocc.desafio.repository;

import com.desafiocc.desafio.model.Numero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumeroRepository extends JpaRepository<Numero, Integer> {

}
