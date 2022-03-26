/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiagoDev.cobranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tiagoDev.cobranca.model.Cartao;
import tiagoDev.cobranca.model.Titulo;
import tiagoDev.cobranca.services.CartaoService;

/**
 *
 * @author tiagolopes
 */
@Controller
@RequestMapping("/cartao")
public class CartaoController {

    private static final String CADASTRO_VIEW = "cadastroCartao";

    @Autowired
    private CartaoService cartaoService;

    @RequestMapping("/new")
    public ModelAndView newTitulo() {
        ModelAndView mav = new ModelAndView(CADASTRO_VIEW);
        mav.addObject(new Cartao());
        return mav;
    }

    @PostMapping("/save")
    public String save(@Validated Cartao c, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return CADASTRO_VIEW;
        }
        cartaoService.saveCartaoService(c);
        attributes.addFlashAttribute("mensagem", "Cartão salvo com sucesso!");
        return "redirect:/cartao/new";
    }

}
