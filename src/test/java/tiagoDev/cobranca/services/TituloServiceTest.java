/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiagoDev.cobranca.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tiagoDev.cobranca.model.Cartao;
import tiagoDev.cobranca.model.StatusTipoTitulo;
import tiagoDev.cobranca.model.StatusTitulo;
import tiagoDev.cobranca.model.Titulo;
import tiagoDev.cobranca.repository.TituloRepository;

@SpringBootTest
public class TituloServiceTest {

    @Autowired
    TituloService tituloService;

    @MockBean
    TituloRepository tituloRepository;        

    @Test
    @DisplayName("Retorna o preço total de despesas")
    void shouldReturnListPriceDespesa() {        
        when(tituloRepository.findByStatusTipoTitulo(StatusTipoTitulo.DESPESA)).thenReturn(listTitulos());
        Number responseDespesa = ResponseTypeTitulo(StatusTipoTitulo.DESPESA);        
        assertThat(responseDespesa).isEqualTo(200.0);        
    }

    @Test
    @DisplayName("Retorna lista não nula de despesas")
    void shouldReturnListPriceDespesaNotNull() {        
        when(tituloRepository.findByStatusTipoTitulo(StatusTipoTitulo.DESPESA)).thenReturn(listTitulos());
        Number responseDespesa = ResponseTypeTitulo(StatusTipoTitulo.DESPESA);        
        assertNotNull(responseDespesa);       
    }

    @Test
    @DisplayName("Retorna o preço total de receitas")    
    void shouldReturnListPriceReceita() {                        
        Number responseReceita = ResponseTypeTitulo(StatusTipoTitulo.RECEITA);        
        assertThat(responseReceita).isEqualTo(0.00);        
    }
    
    @Test
    @DisplayName("Retorna lista não nula de receitas")    
    void shouldReturnListPriceReceitaNotNull() {                        
        Number responseReceita = ResponseTypeTitulo(StatusTipoTitulo.RECEITA);
        assertNotEquals(null, responseReceita);        
    }
    
    Number ResponseTypeTitulo(StatusTipoTitulo typeTitulo) {
        return tituloService.AllTipoTituloService(typeTitulo);
    }

    static List<Titulo> listTitulos() {
        Titulo instanOne = new Titulo("Compras mercado", new Date(), 100.00,
                StatusTitulo.PENDENTE, StatusTipoTitulo.DESPESA, new Cartao("Nubank"));
        Titulo instanTwo = new Titulo("Compras farmacia", new Date(), 100.00,
                StatusTitulo.PENDENTE, StatusTipoTitulo.DESPESA, new Cartao("Nubank"));
        return new ArrayList<Titulo>(Arrays.asList(instanOne, instanTwo));
    }
}
