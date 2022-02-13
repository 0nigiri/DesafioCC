package com.desafiocc.desafio.model;

import javax.persistence.*;

@Entity
public class Numero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(precision=20, scale=2)
    private double numero;

    public Numero(){
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
