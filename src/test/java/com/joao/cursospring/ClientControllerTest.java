package com.joao.cursospring;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.joao.cursospring.api.controller.ClienteController;
import com.joao.cursospring.domain.entity.Cliente;
import com.joao.cursospring.domain.repository.Clientes;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {

    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private Clientes clienteRepository;

    @InjectMocks
    private ClienteController clienteController;

    Cliente cliente1 = new Cliente(1, "joao");
    Cliente cliente2 = new Cliente(2, "marcos");
    Cliente cliente3 = new Cliente(3, "jose");

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    public void getAllClients() throws Exception {
        List<Cliente> clientes = new ArrayList<>(List.of(cliente1, cliente2, cliente3));

        Mockito.when(clienteRepository.findAll()).thenReturn(clientes);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].nome", is("jose")));
    }

    @Test
    public void getClientById() throws Exception {
        Mockito.when(clienteRepository.findById(cliente1.getId())).thenReturn(Optional.of(cliente1));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/clientes/" + cliente1.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.nome", is("joao")));

    }

    @Test
    public void createCliente() throws Exception {
        Cliente cliente = Cliente.builder().nome("joao").cpf("60792362343").build();
        Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);

        String content = objectWriter.writeValueAsString(cliente);

        System.out.println(content);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/clientes/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.nome", is("joao")));
    }

}
