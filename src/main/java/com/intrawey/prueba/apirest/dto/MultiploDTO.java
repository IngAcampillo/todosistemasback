/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intrawey.prueba.apirest.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author Augusto
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultiploDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String descripcion;
    private String list;
    private String code;
    private Long id;

   
    
}
