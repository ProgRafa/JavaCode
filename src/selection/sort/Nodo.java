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
public class Nodo {
    String name;
    Nodo proxN;
    int codA;
    float notaA;
    float notaB;
    float notaC;
    
    public Nodo(int valor, String nome, float A, float B, float C){
           this.name = nome;
           this.codA = valor;
           this.notaA = A;
           this.notaB = B;
           this.notaC = C;
           this.proxN = null;
           
    }
}
