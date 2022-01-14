/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiagoDev.cobranca.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tiagoDev.cobranca.model.StatusTitulo;
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
    
    private static final String CADASTRO_VIEW = "cadastroTitulo";

    @RequestMapping("/new")
    public ModelAndView newTitulo() {
        ModelAndView mav = new ModelAndView(CADASTRO_VIEW);
        mav.addObject(new Titulo());
        return mav;
    }

    @PostMapping("/save")
    public String save(@Validated Titulo t, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return CADASTRO_VIEW;
        }
        tituloRepository.save(t);
        attributes.addFlashAttribute("mensagem", "Título salvo com sucesso!");
        return "redirect:/titulo/new";
    }

    @RequestMapping
    public ModelAndView search() {
        List<Titulo> allTitulos = tituloRepository.findAll();
        ModelAndView andView = new ModelAndView("pesquisaTitulo");
        andView.addObject("titulos", allTitulos);
        return andView;
    }
    
    @RequestMapping("/{codigo}")
    public ModelAndView edit(@PathVariable("codigo") Titulo titulo){
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(titulo);
        return mv;
    }

    @ModelAttribute("allStatusTitle")
    public List<StatusTitulo> AllStatusTitle() {
        return Arrays.asList(StatusTitulo.values());
    }
}
