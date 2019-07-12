/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lecom.junitdemo.controller;

import br.com.lecom.junitdemo.model.Person;
import br.com.lecom.junitdemo.usecase.SavePersonUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author ricardo.camargo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private SavePersonUseCase savePersonUseCase;

//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of save method, of class PeopleController.
     * @throws java.lang.Exception
     */
    @Test
    public void testSave() throws Exception {
        Mockito.when(savePersonUseCase.execute(Mockito.any(Person.class))).thenReturn(new Person("Pessoa Teste"));
        MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.post("/persons")
                .content(this.buildContent())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
        Assert.assertTrue(andReturn.getResponse().getContentAsString().contains("Pessoa Teste"));
    }

    private String buildContent() throws JsonProcessingException {
        final Person person = new Person("Pessoa Teste");
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(person);
    }

}
