package com.intrawey.prueba.apirest.converters;

import com.intrawey.prueba.apirest.dto.MultiploDTO;
import com.intrawey.prueba.apirest.entity.Multiplos;

public class MultiploConverter extends AbstractConverter<Multiplos, MultiploDTO> {

    @Override
    public MultiploDTO fromEntity(Multiplos entity) {
        if (entity == null) {
            return null;
        }
        return MultiploDTO.builder()
                .id(entity.getId())
                .list(entity.getList())
                .code(entity.getCode())
                .descripcion(entity.getDescripcion())
                .build();
    }
    
    public Multiplos fromDTO(MultiploDTO dto, Integer minimo, Integer maximo) {
        if (dto == null) {
            return null;
        }
        return Multiplos.builder()
                .id(dto.getId())
                .minimo(minimo)
                .maximo(maximo)
                .list(dto.getList())
                .code(dto.getCode())
                .descripcion(dto.getDescripcion())
                .build();
    }

    @Override
    public Multiplos fromDTO(MultiploDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    

}
