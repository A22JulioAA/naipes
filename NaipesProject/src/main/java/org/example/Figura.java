//Enumeración FIgura que almacena los posibles valores de las figuras de las cartas

package org.example;

public enum Figura {

    //Declaración de constantes enumeradas
    SOTA(10), CABALLO(11), REY(12),
    JACK(11), QUEEN(12), KING(13),
    JOKER(0);

    //Declaración de atributos
    private int numero;

    //Constructor
    private Figura(int numero){
        this.numero = numero;
    }

    //Métodos get y set
    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }





}
