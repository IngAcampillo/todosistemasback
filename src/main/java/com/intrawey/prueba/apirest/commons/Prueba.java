/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intrawey.prueba.apirest.commons;

import com.intrawey.prueba.apirest.utils.Generals;

/**
 *
 * @author ar_pr
 */
public class Prueba {

    public static int main(String[] args) {
        Prueba p = new Prueba();
        p.generarMultiplos(2, 5);
        return 0;
    }

    private String generarMultiplos(Integer minimo, Integer maximo) {
        String resultado = "";
        for (int x = minimo; x < maximo; x++) {
            if (Generals.esMultiplo(3, x) && Generals.esMultiplo(5, x)) {
                resultado += "Fizzbuzz,";
            } else if (Generals.esMultiplo(3, x)) {
                resultado += "Fizz,";
            } else if (Generals.esMultiplo(5, x)) {
                resultado += "Buzz,";
            } else {
                System.out.print(x + ",");
            }
        }
        System.out.print(resultado);
        return "";
    }

}
