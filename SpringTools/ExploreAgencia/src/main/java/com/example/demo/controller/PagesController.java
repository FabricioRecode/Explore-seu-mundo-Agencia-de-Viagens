package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.enums.RoleName;
import com.example.demo.model.Cargo;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.utils.PasswordEncoderUtils;

@Controller
@RequestMapping(path = "/pages")
public class PagesController  {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping(path = "/cadastro")
	public String signup(@ModelAttribute Usuario usuario) {
		try {
			String passwordEncoder = PasswordEncoderUtils.encode(usuario.getPassword());
			usuario.setPassword(passwordEncoder);

			Cargo cargo = new Cargo();
			cargo.setId(2);
			cargo.setNome(RoleName.ROLE_ADMIN);
			usuario.setCargo(cargo);

			usuarioRepository.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/pages/login";
	}

	@GetMapping(path = { "", "/", "/index" })
	public String home() {
		return "index";
	}

	@GetMapping(path = "/destino")
	public String destino() {
		return "destinos";
	}
	
	@GetMapping(path = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(path = "/cadastro")
	public String cadastro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastro";
	}

	@GetMapping(path = "/promocao")
	public String promocao() {
		return "promocao";
	}

	@GetMapping(path = "/contato")
	public String contato() {
		return "contato";
	}

}
