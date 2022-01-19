package tabelahashing;

public class HashingEndFech {
    Lista array[];

    public HashingEndFech(){
        array = new Lista[128];
        criarhashing();
    }

    public void criarhashing(){
        for(int i = 0; i< array.length; i++){
            array[i] = new Lista();
        }
    }

    public int calculoposicao(String key){
        int posicao = (int) (128 * ((Integer.parseInt(key) * 0.6180339887)%1));
        return posicao;
    }

    public void inserirhashing(String valor, String key){
        array[calculoposicao(key)].inseririnicio(valor, key);
    }

    public void listarhashing (){
        for (int i = 0; i<array.length; i++)
            System.out.println(array[i].listar());
    }
}
