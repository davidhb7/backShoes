package com.shoesweb.repository;

import com.shoesweb.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	/**
	 * 
	 * @param email
	 * @param contra
	 * @return Un usuario con el correo y contraseña
	 */
	Optional<Cliente> findByEmailAndContra(String email, String contra);
}
