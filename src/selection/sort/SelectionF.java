/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selection.sort;
/**
 *
 * @author Rafael
 */
public class SelectionF {       
    Nodo nodoInicial;
    static int quantNodo = 0;
    
    //insere nodos no começo da lista e impede duplicatas de chave
    public int criaListaEncadeada(int valor, String passaN, float a, float b, float c){        
        if(verifyDuplicates(nodoInicial, valor))
            return 0;
        if(quantNodo == 0){
            Nodo nodo = new Nodo(valor, passaN, a, b, c);
            nodoInicial = nodo;
            quantNodo++;
        }else{
            Nodo nodo = new Nodo(valor, passaN, a, b, c);
            nodo.proxN = nodoInicial;
            nodoInicial = nodo;
            quantNodo++;
        }
        return 1;
    }
    
    public void printList(){
        Nodo auxP = nodoInicial;
        while(auxP != null){            
            System.out.println("| Codigo: "+auxP.codA+" Nome: "+auxP.name
                               +" Nota A: "+auxP.notaA+" Nota B: "+auxP.notaB
                               +" Nota C: "+auxP.notaC);            
            auxP = auxP.proxN;            
        }
        System.out.println("-------------------------------------------------------------------");
    }
    
    //verifica a duplicação de chaves na criação de um nodo
    public static boolean verifyDuplicates(Nodo n, int key){
        int num = 0;
        if(n == null){
            return false;
        }else{
            while(num < quantNodo){
                if(key == n.codA){
                    return true;
                }else{
                    n = n.proxN;
                }
                num++;
            }
        }
        return false;
    }
    
    //retorna se o valor da lista já foi considerado como uma chave menor
    public boolean exist(int n, int [] cod) {
        for(int i = 0; i < quantNodo; i++){
            if(cod[i] == n){
                return false;
            }
        }
        return true;
    }
    
    //Encontra o maior valor da lista encadeada
    public int biggerKey(Nodo n){
        int key = 0, i;
        for(i = 0; i < quantNodo;i++){
            if(n.codA > key){
                key = n.codA;
                if(n.proxN == null)
                    break;
                n = n.proxN;
            }else{
                n = n.proxN;
            }
        }  
        return key;
    }
}