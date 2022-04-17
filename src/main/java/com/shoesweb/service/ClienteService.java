package com.shoesweb.service;

import com.shoesweb.domain.Cliente;
import com.shoesweb.dto.ClienteDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ClienteService extends GenericService<Cliente, Long> {
	
	/**
	 * 
	 * @param clienteDTO
	 * @return
	 * @throws Exception
	 */
	Cliente loginCliente(ClienteDTO clienteDTO) throws Exception;
}
