/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiagoDev.cobranca.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tiagoDev.cobranca.CobrancaApplication;

/**
 *
 * @author tiagolopes
 */
@SpringBootTest(classes = CobrancaApplication.class)
@DisplayName("Testes para metodo do model Titulo")
public class TituloTest {

    @Autowired
    Titulo tituloIns;

    @Test
    @DisplayName("Deve retornar o valor 200.00")
    void shouldReturnListExpenses() {
        double expected = 200.00;
        assertEquals(expected, tituloIns.sumTipoTitulo(listTitulos(), StatusTipoTitulo.DESPESA));        
    }
    
    @Test
    @DisplayName("Verifica se o valor é menor que 250.00")
    void shouldTrueGreater() {
        assertTrue(tituloIns.sumTipoTitulo(listTitulos(), StatusTipoTitulo.DESPESA) < 250.00);
    }
    
    @Test
    @DisplayName("Verifica se retorna null")
    void shouldReturnNull() {        
        Titulo instanceNull = new Titulo();
        assertEquals(null, instanceNull.getValor());
    }

    static List<Titulo> listTitulos() {
        Titulo instanOne = new Titulo("Compras mercado", new Date(), 100.00,
                StatusTitulo.PENDENTE, StatusTipoTitulo.DESPESA, new Cartao("Nubank"));
        Titulo instanTwo = new Titulo("Compras farmacia", new Date(), 100.00,
                StatusTitulo.PENDENTE, StatusTipoTitulo.DESPESA, new Cartao("Nubank"));
        return new ArrayList<Titulo>(Arrays.asList(instanOne, instanTwo));
    }

}
