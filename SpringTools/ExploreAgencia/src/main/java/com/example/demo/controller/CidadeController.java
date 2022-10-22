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

import com.example.demo.model.Cidade;
import com.example.demo.repository.CidadeRepository;

@Controller
@RequestMapping(path = "/admin/cidade")
public class CidadeController {
	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping(path = "/listar")
	public String listar(Model model) {
		List<Cidade> cidades = cidadeRepository.findAll();
		model.addAttribute("cidades", cidades);
		model.addAttribute("cidade", new Cidade());
		return "cadastro_cidade";
	}

	


	@GetMapping(path = "/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		try {
			cidadeRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/cidade/listar";
	}
	
	
	@GetMapping(path = "/edit/{id}")
	public String edit(Model model,@PathVariable(name = "id") Long id) {
		Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Cidade não encontrada"));
        model.addAttribute("cidade",cidade);

		
		return "editar_cidade";
	}
	
	@PostMapping(path = "/inserir")
    public String insert(@ModelAttribute Cidade cidade){
        try{
            cidadeRepository.save(cidade);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/cidade/listar";
    }

	@PostMapping(path = "uptade")
	public String uptade (@ModelAttribute Cidade cidade) {
		 try {
	            cidadeRepository.save(cidade);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return "redirect:/admin/cidade/listar";
	}
	
	
	
}
