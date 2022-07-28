package com.intrawey.prueba.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Multiplos")
@Table(name = "multiplos")
public class Multiplos implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "minimo no puede ser vacio")
    @Column(nullable = false)
    private Integer minimo;

    @NotNull(message = "maximo no puede ser vacio")
    @Column(nullable = false)
    private Integer maximo;

    @NotEmpty(message = "list no puede ser vacio")
    @Column(nullable = false,length = 100000)
    private String list;
    
    @NotEmpty(message = "code no puede ser vacio")
    @Column(nullable = false)
    private String code;
    
    @Column(nullable = true)
    private String descripcion;


   

}
