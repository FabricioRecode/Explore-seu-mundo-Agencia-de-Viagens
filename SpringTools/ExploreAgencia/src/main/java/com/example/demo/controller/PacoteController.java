package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Pacote;
import com.example.demo.repository.CidadeRepository;
import com.example.demo.repository.PacoteRepository;

@Controller
@RequestMapping(path = "/admin/pacote")
public class PacoteController {

	@Autowired
	private PacoteRepository pacoteRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping(path = "/listar")
	public String listar(Model model) {
		List<Pacote> pacotes = pacoteRepository.findAll();
		model.addAttribute("pacotes", pacotes);
		model.addAttribute("pacote", new Pacote());
		return "cadastro_pacote";
	}

	@GetMapping(path = "/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		try {
			pacoteRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/pacote/listar";
	}

	@GetMapping(path = "/edit/{id}")
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		Pacote pacote = pacoteRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Pacote não encontrada"));
		model.addAttribute("pacote", pacote);

		return "editar_pacote";
	}

	@PostMapping(path = "/inserir")
	public String insert(@ModelAttribute Pacote pacote, @RequestParam(name = "id_cidade") Long id_cidade,@RequestParam(name = "cafe_manha") Boolean cafe_manha) {
		try {
			pacote.setCafe_manha(cafe_manha);
			pacote.setCidade(cidadeRepository.findById(id_cidade).get());
			pacoteRepository.save(pacote);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/pacote/listar";
	}

	@PostMapping(path = "uptade")
	public String uptade(@ModelAttribute Pacote pacote,@RequestParam(name = "id_cidade") Long id_cidade,@RequestParam(name = "cafe_manha") Boolean cafe_manha) {
		try {
			pacote.setCafe_manha(cafe_manha);
			pacote.setCidade(cidadeRepository.findById(id_cidade).get());
			pacoteRepository.save(pacote);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/pacote/listar";
	}

}
