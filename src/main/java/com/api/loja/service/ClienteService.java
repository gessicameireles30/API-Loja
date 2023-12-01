package com.api.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.loja.model.Cliente;
import com.api.loja.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	public Cliente salvar(Cliente cliente) {
		Cliente clienteAtual =  clienteRepository.save(cliente);
		return clienteAtual;
	}
	
	public Cliente buscar(Long id) {
		Cliente clienteAtual = clienteRepository.findById(id).get();
		return clienteAtual;
	}
	
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
