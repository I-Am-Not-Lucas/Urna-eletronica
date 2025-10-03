package com.ada.service;

import com.ada.model.Candidato;

public class BuscaDeCandidato {
    public static Candidato porNumero(Candidato[] lista, int numero) {
        for (Candidato c : lista) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

}
