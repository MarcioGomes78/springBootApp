package com.mjgomes.springBootApp.controller;

import com.mjgomes.springBootApp.modelo.Usuario;
import com.mjgomes.springBootApp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/novo")
    public String adicionarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/publica-criar-usuario";
    }
    @PostMapping("/salvar")
    public String salvarUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "/publica-criar-usuario";
        }
        usuarioRepository.save(usuario);
        attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso");
        return "redirect:/usuario/novo";
    }
    @RequestMapping("/admin/listar")
    public String listarUsuario(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "/auth/admin/admin-listar-usuario";
    }
}
