/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiagoDev.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tiagoDev.cobranca.model.Titulo;

/**
 *
 * @author tiago
 */
public interface TituloRepository extends JpaRepository<Titulo, Integer>{
    
}
