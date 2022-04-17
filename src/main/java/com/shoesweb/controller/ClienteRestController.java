package com.shoesweb.controller;

import com.shoesweb.domain.*;

import com.shoesweb.dto.ClienteDTO;

import com.shoesweb.mapper.ClienteMapper;

import com.shoesweb.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@RestController
@RequestMapping("/api/v1/cliente")
@CrossOrigin(origins = "*")
@Slf4j
public class ClienteRestController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteMapper clienteMapper;

    @GetMapping(value = "/{cedula}")
    public ResponseEntity<?> findById(@PathVariable("cedula")
    Long cedula) throws Exception {
        log.debug("Request to findById() Cliente");

        Cliente cliente = (clienteService.findById(cedula).isPresent() == true)
            ? clienteService.findById(cedula).get() : null;

        return ResponseEntity.ok()
                             .body(clienteMapper.clienteToClienteDTO(cliente));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Cliente");

        return ResponseEntity.ok()
                             .body(clienteMapper.listClienteToListClienteDTO(
                clienteService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    ClienteDTO clienteDTO) throws Exception {
        log.debug("Request to save Cliente: {}", clienteDTO);

        Cliente cliente = clienteMapper.clienteDTOToCliente(clienteDTO);
        cliente = clienteService.save(cliente);

        return ResponseEntity.ok()
                             .body(clienteMapper.clienteToClienteDTO(cliente));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    ClienteDTO clienteDTO) throws Exception {
        log.debug("Request to update Cliente: {}", clienteDTO);

        Cliente cliente = clienteMapper.clienteDTOToCliente(clienteDTO);
        cliente = clienteService.update(cliente);

        return ResponseEntity.ok()
                             .body(clienteMapper.clienteToClienteDTO(cliente));
    }

    @DeleteMapping(value = "/{cedula}")
    public ResponseEntity<?> delete(@PathVariable("cedula")
    Long cedula) throws Exception {
        log.debug("Request to delete Cliente");

        clienteService.deleteById(cedula);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(clienteService.count());
    }
    
	@PostMapping("/consultarCliente")
	public ResponseEntity<?> consultarClientePorEmailYContra(@RequestBody ClienteDTO clienteDTO){
		try {
			return ResponseEntity.ok().body(clienteService.loginCliente(clienteDTO));
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
