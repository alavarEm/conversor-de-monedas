package com.ealavar.main;

import com.ealavar.model.Conversor;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion;
        double cantidad;
        do{
            Scanner lectura = new Scanner(System.in);
            Conversor conversor = new Conversor();
            conversor.menuConversor();
            opcion = lectura.nextInt(); //Almacena la opcion que elija el usuario
            if(opcion==7){
                break;
            }else {
                System.out.println("Ingrese el valor que desea convertir:");
                cantidad = lectura.nextDouble(); //Almacena la cantidad a convertir
                double resultado;
                String money = null;
                switch (opcion) {
                    case 1, 3, 5:
                        money = conversor.asignarMoneda(opcion);
                        resultado = conversor.convertirMoneda(cantidad, opcion, money);
                        System.out.println(cantidad + " USD equivalen a " + resultado + " " + money);
                        break;
                    case 2, 4, 6:
                        money = conversor.asignarMoneda(opcion);
                        resultado = conversor.convertirADolar(cantidad, opcion, money);
                        System.out.println(cantidad + " " + money + " equivalen a " + resultado + " USD");
                        break;
                    default:
                        break;
                }
            }
        }while(opcion!=7);
    }
}