/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiagoDev.cobranca.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tiagoDev.cobranca.model.StatusTitulo;
import tiagoDev.cobranca.repository.TituloRepository;
import tiagoDev.cobranca.model.Titulo;
import tiagoDev.cobranca.repository.filter.TituloFilter;

/**
 *
 * @author tiagolopes
 */
@Service
public class TituloService {

    @Autowired
    private TituloRepository tituloRepository;

    Titulo t = new Titulo();

    public void saveTituloService(Titulo t) {
        try {
            tituloRepository.save(t);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválida.");
        }
    }

    public void deleteTituloService(Integer codigoTitulo) {
        tituloRepository.deleteById(codigoTitulo);
    }

    public String recebe(Integer codigoTitulo) {
        Titulo t = tituloRepository.findById(codigoTitulo).get();
        t.setStatus(StatusTitulo.RECEBIDO);
        tituloRepository.save(t);
        return StatusTitulo.RECEBIDO.getDescricao();
    }
    
    public List<Titulo> filter(TituloFilter tf){
        String descricao = tf.getDescricao() == null ? "%" : tf.getDescricao();
        return tituloRepository.findByDescricaoContaining(descricao);
    }

}
