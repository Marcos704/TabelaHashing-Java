package tabelahashing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {



    public static void main(String[] args) {
        HashingEndFech conjS = new HashingEndFech();
        HashingEndFech conjT = new HashingEndFech();

        try {
            FileReader arq = new FileReader("ConjuntoS.txt");
            BufferedReader leitura = new BufferedReader(arq);
            try {
                String linha = leitura.readLine();
                while (linha != null) {
                    conjS.inserirhashing(linha.split(" ")[0], linha.split(" ")[1]);
                    linha = leitura.readLine();
                }
            } catch (IOException e){
                System.err.println("Error: " + e);
            }
        } catch (FileNotFoundException e){
            System.err.println("Error: " + e);
        }

        try {
            FileReader arq = new FileReader("ConjuntoT.txt");
            BufferedReader leitura = new BufferedReader(arq);
            try {
                String linha = leitura.readLine();
                while (linha != null) {
                    conjT.inserirhashing(linha.split(" ")[0], linha.split(" ")[1]);
                    linha = leitura.readLine();
                }
            } catch (IOException e){
                System.err.println("Error: " + e);
            }
        } catch (FileNotFoundException e){
            System.err.println("Error: " + e);
        }

        System.out.println("----Conjunto T----");
        conjT.listarhashing();
        System.out.println("\n\n----Conjunto S----");
        conjS.listarhashing();

        int count = 0;
        for (int i = 0; i<conjS.array.length; i++) {
            for(String elemento: conjS.array[i].listar()){
                for (int j = 0; j < conjT.array.length; j++) {
                    if(conjT.array[j].listar().contains(elemento)){
                        count++;
                    }
                }
            }
        }

        if(count == conjS.array.length){
            System.out.println("Conjunto S é um subconjunto de T");
        }else {
            System.out.println("O Conjunto S não é um subconjunto de T");
        }
    }
}
