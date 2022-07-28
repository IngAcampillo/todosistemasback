package com.intrawey.prueba.apirest.utils;

public class Generals {

    
    /**
     * Verfica que sea multiplo del numero 
     * @param n1
     * @param n2
     * @return 
     */
    public static boolean esMultiplo(int n1, int n2) {
        if (n1 % n2 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
