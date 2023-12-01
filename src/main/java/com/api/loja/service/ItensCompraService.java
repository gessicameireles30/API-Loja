package com.api.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.loja.model.ItensCompra;
import com.api.loja.repository.ItensCompraRepository;

@Service
public class ItensCompraService {
	
	@Autowired
	private ItensCompraRepository itensCompraRepository;

	public List<ItensCompra> listar() {
		return itensCompraRepository.findAll();
	}
	
	public ItensCompra salvar(ItensCompra itensCompra) {
		ItensCompra itensCompraAtual =  itensCompraRepository.save(itensCompra);
		return itensCompraAtual;
	}
	
	public ItensCompra buscar(Long id) {
		ItensCompra itensCompraAtual = itensCompraRepository.findById(id).get();
		return itensCompraAtual;
	}
	
	public void excluir(Long id) {
		itensCompraRepository.deleteById(id);
	}
	
}
