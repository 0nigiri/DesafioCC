package com.desafiocc.desafio.service;

import com.desafiocc.desafio.model.Numero;
import com.desafiocc.desafio.repository.NumeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NumeroServiceImp implements NumeroService{

    @Autowired
    private NumeroRepository numeroRepository;


    @Override
    public Numero saveNumero(Numero numero) {
        return numeroRepository.save(numero);
    }


    @Override
    public ArrayList<Numero> getAllNumeros(){
        return (ArrayList<Numero>) numeroRepository.findAll();
    }

}
