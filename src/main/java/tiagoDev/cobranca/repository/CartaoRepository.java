/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tiagoDev.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tiagoDev.cobranca.model.Cartao;

/**
 *
 * @author tiagolopes
 */
@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer>{
    
}