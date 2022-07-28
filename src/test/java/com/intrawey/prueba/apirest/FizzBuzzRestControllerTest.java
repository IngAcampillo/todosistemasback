package com.intrawey.prueba.apirest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intrawey.prueba.apirest.controllers.FizzBuzzRestController;
import com.intrawey.prueba.apirest.dto.DatosDTO;
import com.intrawey.prueba.apirest.services.IMultiploService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(FizzBuzzRestController.class)
public class FizzBuzzRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    private final String BASE_ENDPOINT = "http://localhost:8080/intraway/api/fizzbuzz";

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }
    
    
     @Test
    void testGenerarMultiposMinAndMaxOk() throws Exception, JsonProcessingException {

        // Given
         DatosDTO dto = new DatosDTO();
        dto.setMaximo(1);
        dto.setMinimo(16);
        System.out.println(objectMapper.writeValueAsString(dto));

        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", "true");
        response.put("mensaje", "success");
        response.put("transaccion", dto);

        System.out.println(objectMapper.writeValueAsString(response));

        // When
        mockMvc.perform(post(BASE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(dto)))

        // Then
        .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.mensaje").value("success"))
        .andExpect(content().json(objectMapper.writeValueAsString(response)));

    }
    
    @Test
    void testGenerarMultiposMinAndMaxBabRequest() throws Exception, JsonProcessingException {

        // Given
         DatosDTO dto = new DatosDTO();
        dto.setMaximo(1);
        dto.setMinimo(-5);
        System.out.println(objectMapper.writeValueAsString(dto));

        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", "400");
        response.put("error", "Bad Request");
        response.put("message", "Los parámetros enviados son incorrectos");

        System.out.println(objectMapper.writeValueAsString(response));

        // When
        mockMvc.perform(post(BASE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(dto)))

        // Then
        .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Los parámetros enviados son incorrectos"))
        .andExpect(content().json(objectMapper.writeValueAsString(response)));

    }


}
