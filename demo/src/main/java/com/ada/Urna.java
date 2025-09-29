package com.ada;

import java.util.Scanner;

import com.ada.enums.Cargo;
import com.ada.model.Candidato;

public class Urna {
    public static void main(String[] args) {

        int opcao;
        Scanner sc = new Scanner(System.in);

        Candidato prefeitoA = new Candidato();
        prefeitoA.setNome("Prefeito A");
        prefeitoA.setCargo(Cargo.PREFEITO);
        prefeitoA.setNumero(13);
        prefeitoA.setVotos(10);

        Candidato prefeitoB = new Candidato();
        prefeitoB.setNome("Prefeito B");
        prefeitoB.setCargo(Cargo.PREFEITO);
        prefeitoB.setNumero(17);
        prefeitoB.setVotos(10);

        Candidato vereadorA = new Candidato();
        vereadorA.setNome("Vereador A");
        vereadorA.setCargo(Cargo.VEREADOR);
        vereadorA.setNumero(13);
        vereadorA.setVotos(10);

        Candidato vereadorB = new Candidato();
        vereadorB.setNome("Vereador B");
        vereadorB.setCargo(Cargo.VEREADOR);
        vereadorB.setNumero(13);
        vereadorB.setVotos(10);


        System.out.println(" Escolhe votar em Prefeito ou Vereador");
        System.out.println(" [1] Prefeito");
        System.out.println(" [2] Vereador");
        opcao = sc.nextInt();

        switch (opcao) {
        case 1:
            System.out.println(" Qual o número do prefeito (0 pra branco e 1 pra nulo");
            System.out.println();
            break;
        case 2:
            // Code block for value2
            break;
        // Add more cases as needed
        default:
            System.out.println("Opção de Cargo inválida");
        }


        sc.close();

    }
}