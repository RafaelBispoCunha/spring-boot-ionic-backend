package com.rafaelcunha.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelcunha.cursomc.domain.Categoria;
import com.rafaelcunha.cursomc.repositories.CategoriaRepository;
import com.rafaelcunha.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado ! Id: " + id
					+ ", Tipo: " + Categoria.class.getName());
		}
		return obj.orElse(null);
	}
}
