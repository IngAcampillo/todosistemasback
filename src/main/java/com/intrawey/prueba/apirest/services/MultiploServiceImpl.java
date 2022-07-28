package com.intrawey.prueba.apirest.services;

import com.intrawey.prueba.apirest.converters.MultiploConverter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intrawey.prueba.apirest.dao.IMultipoDao;
import com.intrawey.prueba.apirest.dto.MultiploDTO;
import com.intrawey.prueba.apirest.entity.Multiplos;
import com.intrawey.prueba.apirest.exceptions.GeneralServiceException;
import com.intrawey.prueba.apirest.exceptions.NoDataFoundException;
import com.intrawey.prueba.apirest.exceptions.ValidateServiceException;
import com.intrawey.prueba.apirest.utils.Generals;
import com.intrawey.prueba.apirest.validators.MultipoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MultiploServiceImpl implements IMultiploService {

 @Autowired
    private IMultipoDao multiploDao;
   @Autowired
    private MultiploConverter multiploConverter;
    
    public MultiploServiceImpl(MultiploConverter multiploConverter, IMultipoDao multiploDao) {
        this.multiploConverter = multiploConverter;
        this.multiploDao = multiploDao;
    }

    private void valideNumbers(Integer minimo, Integer maximo) {
        if (minimo > maximo) {
            throw new ValidateServiceException("Los parámetros enviados son incorrectos");
        }
    }

    /**
     * Este método generar los multiplos de dos numeros y asigna descripción
     * según el miltipo de 3 0 5
     *
     * @param minimo
     * @param maximo
     * @return
     */
    public MultiploDTO generarMultiplos(Integer minimo, Integer maximo) {
        String resultado = "";
        String descripcion = "";
        for (int x = minimo; x <= maximo; x++) {
            if (Generals.esMultiplo(x, 3) && Generals.esMultiplo(x, 5)) {
                resultado += "Fizzbuzz,";
                descripcion = "se encontraron múltiplos de 3 y de 5";
            } else if (Generals.esMultiplo(x, 3)) {
                resultado += "Fizz,";
                descripcion = "se encontraron múltiplos de 3";
            } else if (Generals.esMultiplo(x, 5)) {
                resultado += "Buzz,";
                descripcion = "se encontraron múltiplos de 5";
            } else {
                resultado += x + ",";
            }
        }
        if (resultado.length() > 0) {
            int Position = resultado.length();
            resultado = resultado.substring(0, Position - 1);
        }
        MultiploDTO dto = new MultiploDTO();
        dto.setList(resultado);
        dto.setDescripcion(descripcion);
        return dto;
    }

    /**
     * Este metodo guarda los multiplos en base de datos y retorn la respuesta
     * en MultiploDTO
     *
     * @param minimo
     * @param maximo
     * @return
     */
    @Override
    public MultiploDTO save(Integer minimo, Integer maximo) {
        try {
            this.valideNumbers(minimo, maximo);
            MultiploDTO multiploDTO = this.generarMultiplos(minimo, maximo);            
            Multiplos accesoEntity = new Multiplos();
            //Multiplos accesoEntity = this.multiploConverter.fromDTO(multiploDTO, minimo, maximo);
            accesoEntity.setMinimo(minimo);
             accesoEntity.setMaximo(maximo);
             accesoEntity.setList(multiploDTO.getList());
              //accesoEntity.setCode(multiploDTO.getCode());
              accesoEntity.setDescripcion(multiploDTO.getDescripcion());
            accesoEntity.setCode("00" + (this.multiploDao.count() + 1L));
            MultipoValidator.save(accesoEntity);
            Multiplos accesoSave = this.multiploDao.save(accesoEntity);
            multiploDTO.setCode(accesoSave.getCode());
            multiploDTO.setDescripcion(accesoSave.getDescripcion());
            
            //return multiploConverter.fromEntity(accesoSave);
            return multiploDTO;

        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }

    }

    @Override
    public List<MultiploDTO> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultiploDTO findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultiploDTO edit(MultiploDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultiploDTO save(MultiploDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
