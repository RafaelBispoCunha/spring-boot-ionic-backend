package com.rafaelcunha.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelcunha.cursomc.domain.Cliente;
import com.rafaelcunha.cursomc.repositories.ClienteRepository;
import com.rafaelcunha.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado ! Id: " + id
					+ ", Tipo: " + Cliente.class.getName());
		}
		return obj.orElse(null);
	}
}
