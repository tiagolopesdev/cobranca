/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiagoDev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tiagoDev.cobranca.repository.TituloRepository;
import tiagoDev.cobranca.model.Titulo;

/**
 *
 * @author tiagolopes
 */
@Service
public class TituloService {
   
    @Autowired
    private TituloRepository tituloRepository;
    
    public void saveTituloService(Titulo t){
        try {
            tituloRepository.save(t);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválida.");
        }
    }
    
}
