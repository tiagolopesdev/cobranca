 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiagoDev.cobranca.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiagoDev.cobranca.model.Cartao;
import tiagoDev.cobranca.repository.CartaoRepository;

/**
 *
 * @author tiagolopes
 */
@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public void saveCartaoService(Cartao c) {
        cartaoRepository.save(c);
    }
    
    public List<Cartao> findAllCartaoService(){
        return cartaoRepository.findAll();
    }

}
