/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiagoDev.cobranca.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tiagoDev.cobranca.model.Cartao;
import tiagoDev.cobranca.repository.CartaoRepository;

@SpringBootTest
public class CartaoServiceTest {
    
    @MockBean
    Cartao cartao;
    
    @Autowired
    CartaoRepository cartaoRepository;
    
    @Autowired
    CartaoService cartaoService;
    
    @BeforeEach
    void setup(){
        cartao = new Cartao("PicPay");
    }
    
    @Test
    @DisplayName("Adicionando cartão")
    void addCartaoTest(){
    	cartaoRepository.save(cartao);
        Assertions.assertNotNull(cartaoService.findAllCartaoService());
        Assertions.assertFalse(cartaoService.findAllCartaoService().size() > 2);
    }
    
}
