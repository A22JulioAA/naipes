package org.example;

public class Main {
    public static void main(String[] args) {
        Naipe n1 = new Naipe(Palo.BASTOS, 10);
        System.out.println(n1.getPalo());
        System.out.println(n1.getNumeroAsString());
        System.out.println(n1.getPaloAsString());
        n1.setDescubierta(true);
        System.out.println(n1.toString());
    }
}
