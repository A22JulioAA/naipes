//Clase Naipe que implementa Comparable<Naipe> y Serializable

package org.example;

import java.io.Serializable;

public class Naipe implements Comparable<Naipe>, Serializable {

    //Atributos de la clase Naipe
    private Palo palo;
    private int numero;
    private boolean descubierta = false;
    private boolean espanhola = false;

    //Constructores de la clase Naipe
    public Naipe(Palo palo, int numero){
        if (palo == Palo.OROS || palo == Palo.ESPADAS || palo == Palo.COPAS || palo == Palo.BASTOS){
            espanhola = true;
        }
        if (numero < 1 || numero > 13){
            System.out.println("El valor del número no es válido...");
        }else {
            this.numero = numero;
        }
        this.palo = palo;
    }

    public Naipe(Palo palo){
        if (palo == Palo.JOKER_AZUL || palo == Palo.JOKER_ROJO){
            this.palo = palo;
        }else {
            this.palo = Palo.JOKER_AZUL;
        }
        numero = Figura.JOKER.getNumero();
    }

    //Métodos get y set
    public int getNumero(){
        return numero;
    }

    public Palo getPalo(){
        return palo;
    }

    public boolean isDescubierta(){
        return descubierta;
    }

    public boolean isEspanhola(){
        return espanhola;
    }

    public void setDescubierta(boolean descubierta){
        this.descubierta = descubierta;
    }

    //Métodos de la clase
    public String getPaloAsString(){
        switch (palo){
            case COPAS: return "copas";
            case ESPADAS: return "espadas";
            case BASTOS: return "bastos";
            case OROS: return "oros";
            case DIAMANTES: return "diamantes";
            case PICAS: return "picas";
            case CORAZONES: return "corazones";
            case TREBOLES: return "treboles";
            case JOKER_AZUL: return "comodín azul";
            case JOKER_ROJO: return "comodín rojo";
            default: return "valor desconocido";
        }
    }

    public String getNumeroAsString(){
        if (numero == 1){
            return "as";
        }else if(numero == 2){
            return "dos";
        }else if(numero == 3){
            return "tres";
        }else if(numero == 4){
            return "cuatro";
        }else if(numero == 5){
            return "cinco";
        }else if(numero == 6){
            return "seis";
        }else if(numero == 7){
            return "siete";
        }else if(numero == 8){
            return "ocho";
        }else if(numero == 9){
            return "nueve";
        }else if (espanhola == true && numero == Figura.SOTA.getNumero()){
            return "sota";
        }else if(espanhola == true && numero == Figura.CABALLO.getNumero()){
            return "caballo";
        }else if(espanhola == true && numero == Figura.REY.getNumero()){
            return "rey";
        } else if (espanhola == false && numero == Figura.JACK.getNumero()) {
            return "jack";
        }else if(espanhola == false && numero == Figura.QUEEN.getNumero()){
            return "queen";
        }else if (espanhola == false && numero == Figura.KING.getNumero()){
            return "king";
        }else {
            return "valor no válido";
        }
    }

    public double getValor(){
        if (espanhola == false){
            if (numero == 1){
                return 11;
            }else if (numero == Figura.JACK.getNumero() || numero == Figura.QUEEN.getNumero() || numero == Figura.KING.getNumero()){
                return 10;
            }else {
                return numero;
            }
        }else {
            if (numero == Figura.SOTA.getNumero() || numero == Figura.CABALLO.getNumero() || numero == Figura.REY.getNumero()){
                return 0.5;
            }else {
                return numero;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(getNumeroAsString());
        sb.append(" de ");
        sb.append(getPaloAsString());

        if (descubierta == true){
            sb.append(" [*]");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return (getPalo() == this.getPalo() && getNumero() == this.getNumero());
    }

    @Override
    public int compareTo(Naipe n) {
        if (n.getPalo() == this.getPalo()){
            if (n.getNumero() == this.getNumero()){
                return 1;
            }
        }
        return 0;
    }
}
