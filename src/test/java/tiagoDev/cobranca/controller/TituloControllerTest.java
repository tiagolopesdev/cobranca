/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiagoDev.cobranca.controller;

import io.restassured.http.ContentType;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BinaryOperator;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.status.Status;
import tiagoDev.cobranca.controllers.TituloController;
import tiagoDev.cobranca.model.Cartao;
import tiagoDev.cobranca.model.StatusTipoTitulo;
import tiagoDev.cobranca.model.StatusTitulo;
import tiagoDev.cobranca.model.Titulo;
import tiagoDev.cobranca.services.TituloService;
import tiagoDev.cobranca.services.CartaoService;
import tiagoDev.cobranca.repository.TituloRepository;

@WebMvcTest(controllers = TituloController.class)
@AutoConfigureMockMvc
public class TituloControllerTest {

	@Autowired
	TituloController tituloController;

	@MockBean
	TituloService tituloService;

	@MockBean
	CartaoService cartaoService;

	@MockBean
	TituloRepository tituloRepository;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		standaloneSetup(this.tituloController);
	}

	@Test
	@DisplayName("Verifica se é diferente de null")
	void shouldReturnDiferentNull() {
		when(this.tituloController.AllDespesasTitle()).thenReturn(0.00);
		assertTrue(this.tituloController.AllDespesasTitle() != null);
	}	
	
	@Test
	@DisplayName("Verifica o preço total de DESPESAS")
	void shouldReturnSumPriceExpense() {
		
		Number compare = 200.0;
		Number compareTrue = 100.0;
		
		Number getValuesInstance = listTitulos().stream()
			.filter(a -> a.getStatusTipoTitulo() == StatusTipoTitulo.DESPESA)
			.map(a -> a.getValor()).reduce((ac, n) -> ac + n).get();                                 
		
		when(this.tituloService.AllTipoTituloService(StatusTipoTitulo
				.DESPESA)).thenReturn(getValuesInstance);
		
		assertEquals(compare, this.tituloService.AllTipoTituloService(
				StatusTipoTitulo.DESPESA));
		assertTrue(compareTrue.intValue() < this.tituloService.AllTipoTituloService(
				StatusTipoTitulo.DESPESA).intValue());
	}
	
	@Test
	@DisplayName("Verifica o preço total de RECEITAS")
	void shouldReturnSumPriceRevenue() {
		
		Number compare = 150.0;
		Number compareTrue = 200.0;
		
		Number getValuesInstance = listTitulos().stream()
				.filter(a -> a.getStatusTipoTitulo() == StatusTipoTitulo.RECEITA)
				.map(a -> a.getValor()).reduce((ac, n) -> ac + n).get(); 
				
		when(this.tituloService.AllTipoTituloService(StatusTipoTitulo
				.RECEITA)).thenReturn(getValuesInstance);
		
		assertEquals(compare, this.tituloService.AllTipoTituloService(
				StatusTipoTitulo.RECEITA));
		assertTrue(compareTrue.intValue() > this.tituloService.AllTipoTituloService(
				StatusTipoTitulo.RECEITA).intValue());
	}

	static List<Titulo> listTitulos() {		
		Titulo instanOne = new Titulo("Compras mercado", new Date(), 100.00, StatusTitulo.PENDENTE,
				StatusTipoTitulo.DESPESA, new Cartao("Nubank"));
		Titulo instanTwo = new Titulo("Compras farmacia", new Date(), 100.00, StatusTitulo.PENDENTE,
				StatusTipoTitulo.DESPESA, new Cartao("Nubank"));
		Titulo instanThree = new Titulo("Compras farmacia", new Date(), 150.00,
				StatusTitulo.PENDENTE, StatusTipoTitulo.RECEITA, new Cartao("Nubank"));		
		return new ArrayList<Titulo>(Arrays.asList(instanOne, instanTwo, instanThree));
	}
}
