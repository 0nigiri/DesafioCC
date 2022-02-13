package com.desafiocc.desafio.controller;

import com.desafiocc.desafio.model.Numero;
import com.desafiocc.desafio.service.NumeroService;
import com.desafiocc.desafio.ultils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/numero")
public class NumeroController {

    @Autowired
    private NumeroService numeroService;


    @GetMapping("/iniciar")
    public ArrayList<Numero> extract(){
        Utils util = new Utils();
        util.listNumeros();
        ArrayList<Numero> numeros = new ArrayList<>();

        for (Double num : Utils.ordenarNumeros(util.numeroData)) {
            Numero n = new Numero();

            n.setNumero(num);
            numeros.add(n);

           // Adicionar para o sql
           // numeroService.saveNumero(n);
        }


           //return numeroService.getAllNumeros();

        return numeros;
    }



    @PostMapping("/add")
    public String add(@RequestBody Numero numero){
        numeroService.saveNumero(numero);
        return "Numero adicionado";
    }
    @GetMapping("/getAll")
    public List<Numero> getAllNumero(){
        return numeroService.getAllNumeros();
    }



}
