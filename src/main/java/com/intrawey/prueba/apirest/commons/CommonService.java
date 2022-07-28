package com.intrawey.prueba.apirest.commons;

import java.io.Serializable;
import java.util.List;

/**
 * @author Augusto
 * @param <T> objeto para uso genérico de servicios
 * @param <ID> tipo de datos del identificador de entidad principal
 */
public interface CommonService<T, ID extends Serializable> {

    List<T> findAll();

    T findById(ID id);

    T save(T t);
    
    T edit(T t);

    void deleteById(ID id);

}
