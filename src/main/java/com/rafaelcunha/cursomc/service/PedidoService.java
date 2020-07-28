package com.rafaelcunha.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelcunha.cursomc.domain.Pedido;
import com.rafaelcunha.cursomc.repositories.PedidoRepository;
import com.rafaelcunha.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado ! Id: " + id
					+ ", Tipo: " + Pedido.class.getName());
		}
		return obj.orElse(null);
	}
}
