package com.intrawey.prueba.apirest.controllers;

import com.intrawey.prueba.apirest.dto.DatosDTO;
import com.intrawey.prueba.apirest.dto.MultiploDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import com.intrawey.prueba.apirest.services.IMultiploService;
import com.intrawey.prueba.apirest.utils.WrapperResponse;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FizzBuzzRestController {

    @Autowired
    private IMultiploService multipoService;


     /**
      * Endpoint para guardar un nuevo multiplos de dos numeros minimo y maximo
      * @param minimo
      * @param maximo
      * @return 
      */
    @PostMapping(value = "/fizzbuzz")
    public ResponseEntity<WrapperResponse<MultiploDTO>> create(@RequestBody DatosDTO datosDTO) {
        MultiploDTO dto = multipoService.save(datosDTO.getMinimo(),datosDTO.getMaximo());
        /*Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", "OK");
        response.put("mensaje", "Transferencia realizada con éxito!");
        response.put("transaccion", dto);
        return ResponseEntity.ok(response);*/
        
        
        return new WrapperResponse<>(true, "success", dto).createResponse();
    }

}
