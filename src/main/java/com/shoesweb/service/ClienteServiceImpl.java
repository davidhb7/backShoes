package com.shoesweb.service;

import com.shoesweb.domain.*;
import com.shoesweb.dto.ClienteDTO;
import com.shoesweb.exception.*;

import com.shoesweb.repository.*;

import com.shoesweb.utility.Utilities;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(Cliente cliente) throws ConstraintViolationException {
        Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return clienteRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        log.debug("finding all Cliente instances");

        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Cliente save(Cliente entity) throws Exception {
        log.debug("saving Cliente instance");

		if (entity == null) {
			throw new Exception("El cliente no puede estar vacio.");
		}
		
		if (entity.getNombre().trim().equals("")) {
			throw new Exception("El nombre no puede estar vacio.");
		}

		if (entity.getApellidos().trim().equals("")) {
			throw new Exception("Los apellidos no puede estar vacio.");
		}
		
		if (entity.getEmail().trim().equals("")) {
			throw new Exception("El email no puede estar vacio.");
		}

		if (entity.getEmail().length() < 4 && entity.getEmail().length() > 40) {
			throw new Exception("El email no puede contener menos de 20 caracteres ni mas de 40.");
		}

		if (!entity.getEmail().contains("@")) {
			throw new Exception("El email debe contener un arroba.");
		}
		
		if (entity.getContra().trim().equals("")) {
			throw new Exception("La contraseña no puede estar vacia.");
		}

//        validate(entity);
		entity.setFechacreacion(new Date());
		entity.setUsuariocreador("DHERRERA");

        if (clienteRepository.existsById(entity.getCedula())) {
            throw new ZMessManager("Ya existe una persona con esa cedula.");
        }

        return clienteRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Cliente entity) throws Exception {
        log.debug("deleting Cliente instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Cliente");
        }

        if (entity.getCedula() == null) {
            throw new ZMessManager().new EmptyFieldException("cedula");
        }

        if (clienteRepository.existsById(entity.getCedula()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        clienteRepository.deleteById(entity.getCedula());
        log.debug("delete Cliente successful");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Long id) throws Exception {
        log.debug("deleting Cliente instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("cedula");
        }

        if (clienteRepository.existsById(id)) {
            delete(clienteRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Cliente update(Cliente entity) throws Exception {
        log.debug("updating Cliente instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Cliente");
        }

        validate(entity);

        if (clienteRepository.existsById(entity.getCedula()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return clienteRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long cedula) {
        log.debug("getting Cliente instance");

        return clienteRepository.findById(cedula);
    }

	@Override
	public Cliente loginCliente(ClienteDTO clienteDTO) throws Exception {
		
		if (clienteDTO == null) {
			throw new Exception("El cliente no puede estar vacio.");
		}
		
		if (clienteDTO.getEmail().trim().equals("")) {
			throw new Exception("El email no puede estar vacio.");
		}

		if (clienteDTO.getEmail().length() < 4 && clienteDTO.getEmail().length() > 40) {
			throw new Exception("El email no puede contener menos de 20 caracteres ni mas de 40.");
		}

		if (!clienteDTO.getEmail().contains("@")) {
			throw new Exception("El email debe contener un arroba.");
		}
		
		if (clienteDTO.getContra().trim().equals("")) {
			throw new Exception("La contraseña no puede estar vacia.");
		}
		
		Optional<Cliente> cliente = clienteRepository.findByEmailAndContra(clienteDTO.getEmail(), clienteDTO.getContra());
		
		if (cliente.isPresent()) {
			return cliente.get();
		}else {
			throw new Exception("No se encontro ningun cliente con ese correo y contraseña.");
		}
	}
}
