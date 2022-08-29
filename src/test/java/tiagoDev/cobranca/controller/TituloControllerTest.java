/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiagoDev.cobranca.controller;

import io.restassured.http.ContentType;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import tiagoDev.cobranca.controllers.TituloController;
import tiagoDev.cobranca.model.Titulo;
import tiagoDev.cobranca.services.TituloService;
import tiagoDev.cobranca.services.CartaoService;
import tiagoDev.cobranca.repository.TituloRepository;

@WebMvcTest(controllers = TituloController.class)
public class TituloControllerTest {

    @Autowired
    TituloController tituloController;

    @MockBean
    TituloService tituloService;

    @MockBean
    CartaoService cartaoService;

    @MockBean
    TituloRepository tituloRepository;

    @BeforeEach
    void setUp() {
        standaloneSetup(this.tituloController);
    }

    @Test
    void shouldReturnNewTitulo() {

        Mockito.when(this.tituloController.newTitulo()).thenReturn(new 
            ModelAndView().addObject(new Titulo()));

        given().accept(ContentType.JSON).when().get("/titulos/new")
            .then().status(HttpStatus.OK);
    }

}
