package com.api.loja.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.loja.model.Cidade;
import com.api.loja.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeControler {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> listar(){
		return cidadeService.listar();
	}
	
	@PostMapping
	public Cidade adicionar(@RequestBody Cidade cidade) {
		return cidadeService.salvar(cidade);
	}
	
	@GetMapping("/{id}")
	public Cidade buscar(@PathVariable("id") Long id) {
		return cidadeService.buscar(id);
	}
	
	@PutMapping("/{id}")
	public Cidade atualizar(@PathVariable("id") Long id, 
							@RequestBody Cidade cidade) {
		try {
			Cidade cidadeAtual = cidadeService.buscar(id);
			
			BeanUtils.copyProperties(cidade, cidadeAtual, "id");
			
			return cidadeService.salvar(cidadeAtual);
		} catch (Exception e) {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable("id") Long id) {
		cidadeService.excluir(id);
	}
}
