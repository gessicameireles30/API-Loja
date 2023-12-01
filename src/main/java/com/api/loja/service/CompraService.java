package com.api.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.loja.model.Compra;
import com.api.loja.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository compraRepository;

	public List<Compra> listar() {
		return compraRepository.findAll();
	}
	
	public Compra salvar(Compra compra) {
		Compra compraAtual =  compraRepository.save(compra);
		return compraAtual;
	}
	
	public Compra buscar(Long id) {
		Compra compraAtual = compraRepository.findById(id).get();
		return compraAtual;
	}
	
	public void excluir(Long id) {
		compraRepository.deleteById(id);
	}
}
