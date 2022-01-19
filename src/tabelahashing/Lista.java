package tabelahashing;

import java.util.ArrayList;

public class Lista {
    No primeiro, ultimo;
    int tam = 0;

    public int getTam() {
        return tam;
    }
    
    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }
    
    public Lista(){
        this.primeiro = this.ultimo = null;
}
    
    public ArrayList<String> listar(){
        ArrayList<String> lista = new ArrayList<>();      
        if(primeiro == null){
            lista.add("Lista vazia");
        }else{
            No aux = getPrimeiro();         
            while(aux != null){
                String valor = aux.getChave() + " " + aux.getDado();
                lista.add(valor);
                aux = aux.getProximo();
            }
        }
        return lista;
    }
    
    public boolean procurar(String valor){
        if(primeiro == null)
            return false;
        No aux = getPrimeiro();   
        while(aux != null){
            if(valor.equals(aux.getDado())){
                return true;
            }
        aux = aux.getProximo();
        }
    return false;
    }
    
    public void inseririnicio(String valor, String key){
        No novo = new No();
        novo.setDado(valor);
        novo.setChave(key);
        if(primeiro == null){
            setPrimeiro(novo);
            setUltimo(novo);
        }else{
            primeiro.setAnterior(novo);
            novo.setProximo(primeiro);
            setPrimeiro(novo);
        }
        tam++;
    }
    
    /*public void InserirMeio(int posicao, String valor){
        if(primeiro == null){
            InserirInicio(valor);
        }else{
            if(posicao <= 1){
                InserirInicio(valor);
            }else if(posicao >= tam){
                InserirFim(valor);
            }else{
               No novo = new No();
               No aux = getPrimeiro();
               novo.setDado(valor);
               int count = 1;
               while(count != this.tam-1){
                   aux = aux.getProximo();
                   count++;
               }
               novo.setAnterior(aux);
               novo.setProximo(aux.proximo);
               aux.setProximo(novo);
               aux = aux.getProximo();
               aux.setAnterior(novo);
               tam++;
            }
        }
    }*/
    
    public void inserirfim(String valor, String key){
        No novo = new No();
        novo.setDado(valor);
        novo.setChave(key);
        if(primeiro == null){
            primeiro = novo;
            ultimo = novo;
        }
        else{
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
        tam++;
    }
    
    public void removerinicio(){
        if(primeiro == null){
            System.out.print("Lista Vazia");
        }else{
            if(primeiro == ultimo){
                primeiro = null;
                ultimo = null;
            }else{
                primeiro = primeiro.getProximo();
            }
            tam--;
        }
    }
    
    public void removerfim(){
        if(primeiro == null){
            System.out.print("Lista Vazia");
        }else{
            if(primeiro == ultimo){
                primeiro = null;
                ultimo = null;
            }else{
                ultimo = ultimo.getAnterior();
            }
            this.tam--;
        }
    }
}
