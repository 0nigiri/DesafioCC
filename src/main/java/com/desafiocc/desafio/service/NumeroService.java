package com.desafiocc.desafio.service;

import com.desafiocc.desafio.model.Numero;

import java.util.ArrayList;

public interface NumeroService {
    public Numero saveNumero(Numero numero);
    public ArrayList<Numero> getAllNumeros();



}
