/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intrawey.prueba.apirest.validators;

import com.intrawey.prueba.apirest.entity.Multiplos;
import com.intrawey.prueba.apirest.exceptions.ValidateServiceException;


/**
 *
 * @author ar_pr
 */
public class MultipoValidator {
    

    public static void save(Multiplos multiplo) {
        if (multiplo.getMinimo() == null) {
            throw new ValidateServiceException("El minimo es requerido");
        }
        if (multiplo.getMaximo() == null) {
            throw new ValidateServiceException("El máximo es requerido");
        }
        if (multiplo.getList()== null) {
            throw new ValidateServiceException("El resultado de los multiplos es requerido");
        }

    }

}
