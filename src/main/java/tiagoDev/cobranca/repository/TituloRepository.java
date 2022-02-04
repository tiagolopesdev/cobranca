/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiagoDev.cobranca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tiagoDev.cobranca.model.Titulo;

/**
 *
 * @author tiago
 */
@Repository
public interface TituloRepository extends JpaRepository<Titulo, Integer>{
  
    public List<Titulo> findByDescricaoContaining(String descricao);
    
}
