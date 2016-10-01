/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Existe uma exceção não tratada no algoritmo de ordenção por ponteiros, 
quando menor valor encontra-se na segunda posição o programa entra em loop 
infinito
*/

package selection.sort;

import java.util.Random;

/**
 *
 * @author Rafael
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char [] alfabeto =  {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                             'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                             'V', 'X', 'Y', 'Z'};
        char [] nome = new char[10];
        String name;
        int n = 0;
        int alunosCriados;
        
        Selection classList = new Selection();
        Random rnd = new Random();
        boolean geraNome = false;
        
        System.out.println("Lista Encadeada");
        for(alunosCriados = 0; alunosCriados < 30; alunosCriados++){
            while(!geraNome){
                int letra = rnd.nextInt(24);
                nome[n] = alfabeto[letra];
                if(n == 6)
                    geraNome = true;
                n++;
            }
            
            name = String.copyValueOf(nome);
            
            int nota1 = rnd.nextInt(100);
            int nota2 = rnd.nextInt(100);
            int nota3 = rnd.nextInt(100);
            int valor = rnd.nextInt(100);
            int num = classList.criaListaEncadeada(valor, name, nota1, nota2, nota3);
            
            if(num == 0)
                alunosCriados--;
            
            geraNome = false;
            n = 0;
        }
        
        System.out.println("----------------------------PRINT---------------------------------");
        classList.printList();
        
        System.out.println("");
        
        System.out.println("-------------------------SELECTION SORT---------------------------");
        classList.ChangeByKeys(alunosCriados);
        //classList.ChangeByPointer(alunosCriados);
        
        classList.printList();
    }
}
