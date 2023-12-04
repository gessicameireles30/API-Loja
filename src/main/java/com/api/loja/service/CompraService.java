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
        return compraRepository.save(compra);
    }

    public Compra buscar(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        compraRepository.deleteById(id);
    }
}
