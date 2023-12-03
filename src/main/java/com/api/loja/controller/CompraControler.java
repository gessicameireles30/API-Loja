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

import com.api.loja.model.Compra;
import com.api.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraControler {


	
	@Autowired
	private CompraService compraService;

	@GetMapping
	public List<Compra> listar() {
		return compraService.listar();
	}

	@PostMapping
	public Compra adicionar(@RequestBody Compra compra) {
		return compraService.salvar(compra);
	}

	@GetMapping("/{id}")
	public Compra buscar(@PathVariable("id") Long id) {
		return compraService.buscar(id);
	}

	@PutMapping("/{id}")
	public Compra atualizar(@PathVariable("id") Long id, @RequestBody Compra compra) {
		try {
			Compra compraAtual = compraService.buscar(id);

			BeanUtils.copyProperties(compra, compraAtual, "id");

			return compraService.salvar(compraAtual);
		} catch (Exception e) {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable("id") Long id) {
		compraService.excluir(id);
	}

}
