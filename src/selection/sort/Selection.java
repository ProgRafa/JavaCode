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
public class Selection extends SelectionF{
    Nodo aux;
    String name;
    float n1, n2, n3;
    int cod;
    int positionList, positSmallValor, arrayPosition, smallerKey;
    int [] modificados;
    int maiorNum;
    /*
    @aux ponteiro auxiliar nodo que será modificado
    @positList posição atual do começo da lista (posição para inserção dos valores menores)
    @positSmallValor posição do menor valor encontrado, utilizado para percorrer a lista e encontra-lo
    @arrayPosition posição da lista encadeada atual
    @smallerKey menor valor encontrado entre as chaves pesquisadas
    @maiorNum maior numero da lista, usado para iniciar o vetor de chaves modificadas
    */
    
    //Algoritmo Selction Sort mudando chaves 
    public void ChangeByKeys(int lendgthList){
        Nodo begin = nodoInicial;
        aux = nodoInicial;
        positionList = 0; 
        int runner; 
        modificados =  new int[lendgthList];
        int count = 0;
        maiorNum = biggerKey(aux)+1;
        
        for(runner = 0; runner < lendgthList; runner++){
            modificados[runner] = maiorNum;
        }  
        
        while(count < quantNodo){
            positSmallValor = 0;
            smallerKey = maiorNum;
            arrayPosition = 0;
            aux = begin;
            //encontra menor chave e sua posição
            while(arrayPosition < quantNodo){
                if(smallerKey > aux.codA && exist(aux.codA, modificados)){
                    smallerKey = aux.codA;
                    positSmallValor = arrayPosition;
                    if(aux.proxN == null)
                        break;    
                    aux = aux.proxN;                    
                }else{                       
                    if(aux.proxN == null)
                       break;
                    aux = aux.proxN;
                }
                arrayPosition++;
            }
            //caso a menor chave encontrada seja igual a maior chave a lista está ordenada
            if(arrayPosition == quantNodo-1 && smallerKey == maiorNum)
                break;
            
            modificados[count] = smallerKey;           
            //se posição do menor valor for igual a posição atual da lista não se modifica nada
            if(!(positSmallValor == positionList)){           

                aux = begin;

                for(runner = 0; runner < positSmallValor; runner++){
                    if(aux.proxN == null)
                        break;
                    aux = aux.proxN;
                }                      

                nodoInicial = begin;

                for(runner = 0; runner < positionList; runner++){
                    if(nodoInicial.proxN == null)
                        break;
                    nodoInicial = nodoInicial.proxN;
                }
                
                cod = nodoInicial.codA;
                name = nodoInicial.name;
                n1 = nodoInicial.notaA;
                n2 = nodoInicial.notaB;
                n3 = nodoInicial.notaC;

                nodoInicial.codA = aux.codA;
                nodoInicial.name = aux.name;
                nodoInicial.notaA = aux.notaA;
                nodoInicial.notaB = aux.notaB;
                nodoInicial.notaC = aux.notaC;
                nodoInicial = begin;

                for(runner = 0; runner < positSmallValor; runner++){
                    if(nodoInicial.proxN == null)
                        break;
                    nodoInicial = nodoInicial.proxN;   
                }
                nodoInicial.codA = cod;
                nodoInicial.name = name;
                nodoInicial.notaA = n1;
                nodoInicial.notaB = n2;
                nodoInicial.notaC = n3;
                nodoInicial = begin;
            }
            positionList++; 
            count++;
        }
    }
    
    //Algoritmo Selection Sort mudando os apontamentos
    public void ChangeByPointer(int lendgthList){
        aux = nodoInicial;
        Nodo temp;
        Nodo temp2;
        Nodo begin = nodoInicial;
        boolean sideS;
        int runner;
        positionList = 0;
        modificados = new int [lendgthList];
        maiorNum = biggerKey(aux)+1;
        int count = 0;
        
        for(runner = 0; runner < lendgthList; runner++){
            modificados[runner] = maiorNum;
        } 
        while(count < quantNodo){
            arrayPosition = 0;
            smallerKey = maiorNum;
            positSmallValor = 0;
            aux = begin;
            //encontra menor chave e sua posição
            while(arrayPosition < quantNodo){
                if(smallerKey > aux.codA && exist(aux.codA, modificados)){
                    smallerKey = aux.codA;
                    positSmallValor = arrayPosition;
                    if(aux.proxN == null)
                        break;    
                    aux = aux.proxN;                    
                }else{                       
                    if(aux.proxN == null)
                       break;
                    aux = aux.proxN;
                }
                arrayPosition++;
            }
            //caso a menor chave encontrada seja igual a maior chave a lista está ordenada
            if(arrayPosition == quantNodo-1 && smallerKey == maiorNum)
                break;
            
            modificados[count] = smallerKey;
            //se posição do menor valor for igual a posição atual da lista não se modifica nada
            if(!(positSmallValor == positionList)){ 
                aux = begin;
                //percorre a lista encadeada mudando a chave que será alterada
                for(runner = 0; runner < positionList; runner++){
                    if(nodoInicial.proxN == null)
                        break;
                    nodoInicial = nodoInicial.proxN;
                }
                //guarda o nodo a frente do que será modificado
                temp = nodoInicial.proxN;
                //guarda a chave que será trocada com a menor
                temp2 = nodoInicial;
                //Encontra o nodo anterior ao nodo que será modificado
                for(int i = 0; i < positSmallValor-1-positionList; i++)
                    nodoInicial = nodoInicial.proxN;
                //encontra o nodo que será modificado
                for(int i = 0; i < positSmallValor; i++){
                    if(aux.proxN == null)
                        break;
                    aux = aux.proxN;
                }
                sideS = nodoInicial == temp2;
                nodoInicial.proxN = temp2;
                nodoInicial = temp2;
                nodoInicial.proxN = aux.proxN;
                //se for modificar apartir da segunda posição do vetor deve-se rearranjar os apontamentos anteriores caso contrário precisa apenas modificar os apontamentos do nodo inicial para frente
                if(positionList > 0){
                    nodoInicial = begin;
                    
                    while(nodoInicial.proxN != temp2)
                        nodoInicial = nodoInicial.proxN;
                    nodoInicial.proxN = aux;
                    
                    for(runner = 0; runner < positionList; runner++){
                        if(nodoInicial.proxN == null)
                            break;
                        nodoInicial = nodoInicial.proxN;
                    }
                    
                    nodoInicial = aux;
                    
                    if(sideS){
                        nodoInicial.proxN = temp2;
                    }else{
                        nodoInicial.proxN = temp;
                    }
                    
                    nodoInicial = begin;
                }else{
                
                    for(runner = 0; runner < positionList; runner++){
                        if(nodoInicial.proxN == null)
                            break;
                        nodoInicial = nodoInicial.proxN;
                    }
                    nodoInicial = aux;
                    nodoInicial.proxN = temp;
                    begin = nodoInicial;     
                }       
            }
            positionList++;
            count++;
        } 
    }
}