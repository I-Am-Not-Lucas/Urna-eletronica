package com.ada;

import java.util.Scanner;

import com.ada.enums.Cargo;
import com.ada.model.Candidato;
import com.ada.service.FabricaDeCandidato;
import com.ada.service.BuscaDeCandidato;

public class Urna {
    record Item(String nome, int numero, int votos, double percValidos, double percTotal) {
        @Override
        public String toString() {
            return "N %-6d | %-18s | %5d | %8.2f%% válidos | %6.2f%% total".formatted(numero, nome, votos, percValidos, percTotal);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Candidato[] prefeitos = {
                FabricaDeCandidato.criar("Prefeito A", Cargo.PREFEITO, 13, 0),
                FabricaDeCandidato.criar("Prefeito B", Cargo.PREFEITO, 17, 0)
        };

        Candidato[] vereadores = {
                FabricaDeCandidato.criar("Vereador A", Cargo.VEREADOR, 30, 0),
                FabricaDeCandidato.criar("Vereador B", Cargo.VEREADOR, 20, 0)
        };

        while (true) {
            String menu = """
                    Escolha votar em:
                    Prefeito    [1]
                    Vereador    [2]
                    """;
            int opcao;

            System.out.println(menu);
            opcao = sc.nextInt();

            Candidato[] escolhidos = null;

            String tipo = "";

            switch (opcao) {
                case 1:
                    escolhidos = prefeitos;
                    tipo = "Prefeito";
                    break;
                case 2:
                    escolhidos = vereadores;
                    tipo = "Vereador";
                    break;
                default:
                    System.out.println("Opção de Cargo inválida");
                    continue;
            }

            System.out.println("""
                    Digite o número do candidato:
                    (0 = branco, 1 = nulo)
                    """);

            int numero = sc.nextInt();

            if (numero == 0 || numero == 1) {
                System.out.println("Confirma voto " + (numero == 0 ? "BRANCO" : "NULO") + "? [s/n]");
                if (sc.next().equalsIgnoreCase("s")) {
                    System.out.println("Voto registrado.");
                } else {
                    System.out.println("Voto cancelado.");
                }
            } else {
                Candidato candidato = BuscaDeCandidato.porNumero(escolhidos, numero);
                if (candidato != null) {
                    System.out.println("Confirma voto em " + candidato.getNome() + "? [s/n]");
                    if (sc.next().equalsIgnoreCase("s")) {
                        candidato.setVotos(candidato.getVotos() + 1);
                        System.out.println("Voto registrado.");
                    } else {
                        System.out.println("Candidato não encontrado.");
                    }
                }

                System.out.println("Deseja registrar outro voto? [s/n]");

                String continuar = sc.next();
                if (continuar.equalsIgnoreCase("n")) {
                    System.out.println("\n--- Apuração Final ---");
                    apurar(prefeitos);
                    apurar(vereadores);
                    break; // encerra votação
                }
            }

            // Apuração
//
//            System.out.println("\n--- Apuração ---");
//
//            apurar(prefeitos);
//            apurar(vereadores);
        }
        sc.close();
    }
    private static Item criarItem(Candidato c, int validos, int total){
        double pValidos = validos == 0 ? 0.0 : (100.0 * c.getVotos() / validos);
        double pTotal = total == 0 ? 0.0 : (100.0 * c.getVotos() / total);
        return new Item(c.getNome(), c.getNumero(), c.getVotos(), pValidos, pTotal);
    }

    private static void apurar(Candidato[] lista){
        int validos = 0;
        int total = 0;
        int brancos = 5;
        int nulos = 5;

        for (Candidato c : lista) {
            validos += c.getVotos();
        }

        total = validos + brancos + nulos;

        for (Candidato c : lista){
            Item item = criarItem(c, validos, total);

            System.out.println(item);
        }
    }
}

