/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiagoDev.cobranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tiagoDev.cobranca.model.Titulo;
import tiagoDev.cobranca.repository.TituloRepository;

/**
 *
 * @author tiago
 */
@Controller
@RequestMapping("/titulo")
public class TituloController {
    
    @Autowired
    private TituloRepository tituloRepository;

    @RequestMapping("/novo")
    public String newTitulo() {
        return "cadastroTitulo";
    }

    @PostMapping("/saveTitulo")
    public String save(Titulo t) {
        tituloRepository.save(t);
        return "cadastroTitulo";
    }
}
