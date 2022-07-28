package com.intrawey.prueba.apirest.services;

import com.intrawey.prueba.apirest.commons.CommonService;
import com.intrawey.prueba.apirest.dto.MultiploDTO;

public interface IMultiploService extends CommonService<MultiploDTO, Long> {
   public MultiploDTO save(Integer minimo, Integer maximo);
   public MultiploDTO generarMultiplos(Integer minimo, Integer maximo);
}
