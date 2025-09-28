package com.ada.model;

import com.ada.enums.Cargo;

public class Candidato extends Pessoa {
    //Classe Candidato (número, cargo, votos)
    public int numero;
    public Cargo cargo;
    public int votos;

    public Candidato() {

    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}