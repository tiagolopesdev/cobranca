/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiagoDev.cobranca.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tiagoDev.cobranca.model.Cartao;

import tiagoDev.cobranca.model.StatusTitulo;
import tiagoDev.cobranca.model.Titulo;
import tiagoDev.cobranca.repository.TituloRepository;
import tiagoDev.cobranca.repository.filter.TituloFilter;
import tiagoDev.cobranca.services.CartaoService;
import tiagoDev.cobranca.services.TituloService;

/**
 *
 * @author tiago
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    private TituloService tituloService;

    @Autowired
    private TituloRepository tituloRepository;
    
    @Autowired
    private CartaoService cartaoService;

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
        try {
            tituloService.saveTituloService(t);
            attributes.addFlashAttribute("mensagem", "Título salvo com sucesso!");
            return "redirect:/titulos/new";
        } catch (IllegalArgumentException e) {
            errors.rejectValue("dataVencimento", null, e.getMessage());
            return CADASTRO_VIEW;
        }
    }

    @RequestMapping
    public ModelAndView getAllTitles(@ModelAttribute("filtro") TituloFilter filter) {
        List<Titulo> allTitulos = tituloService.getAllTitles();
        ModelAndView andView = new ModelAndView("pesquisaTitulo");
        andView.addObject("titulos", allTitulos);
        return andView;
    }

    @RequestMapping("/search")
    public ModelAndView search(@ModelAttribute("filtro") TituloFilter filtro) {
        List<Titulo> allTitulos = tituloService.filter(filtro);
        ModelAndView andView = new ModelAndView("pesquisaTitulo");
        andView.addObject("titulos", allTitulos);
        return andView;
    }

    @RequestMapping("/{codigo}")
    public ModelAndView edit(@PathVariable("codigo") Titulo titulo) {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(titulo);
        return mv;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("codigo") Integer codigo, RedirectAttributes attributes) {
        tituloService.deleteTituloService(codigo);
        attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
        return "redirect:/titulos";
    }

    @RequestMapping(value = "/{codigo}/receber", method = RequestMethod.PUT)
    public @ResponseBody
    String changeStatus(@PathVariable("codigo") Integer codigoTitulo) {
        AllStatusTitleRecebidos();
        return tituloService.recebe(codigoTitulo);
    }

    @ModelAttribute("allStatusTitle")
    public List<StatusTitulo> AllStatusTitle() {
        return Arrays.asList(StatusTitulo.values());
    }

    @ModelAttribute("allStatusTitlePendente")
    public Integer AllStatusTitlePendente() {
        return tituloRepository.countByStatus(StatusTitulo.PENDENTE);
    }

    @ModelAttribute("allStatusTitleRecebido")
    public Integer AllStatusTitleRecebidos() {
        return tituloRepository.countByStatus(StatusTitulo.RECEBIDO);
    }
    
    @ModelAttribute("allCartao")
    public List<Cartao> AllCartao() {
        List<Cartao> allCartoes = cartaoService.findAllCartaoService();
        return allCartoes;
    }
    
}
