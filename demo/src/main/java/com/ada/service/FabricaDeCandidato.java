package com.ada.service;

import com.ada.enums.Cargo;
import com.ada.model.Candidato;

public class FabricaDeCandidato {

    public static Candidato criar(String nome, Cargo cargo, int numero, int votos) {
        Candidato c = new Candidato();
        c.setNome(nome);
        c.setCargo(cargo);
        c.setNumero(numero);
        c.setVotos(votos);
        return c;
    }
}
