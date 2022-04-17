package com.shoesweb.mapper;

import com.shoesweb.domain.Cliente;

import com.shoesweb.dto.ClienteDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface ClienteMapper {
    public ClienteDTO clienteToClienteDTO(Cliente cliente);

    public Cliente clienteDTOToCliente(ClienteDTO clienteDTO);

    public List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> clientes);

    public List<Cliente> listClienteDTOToListCliente(
        List<ClienteDTO> clienteDTOs);
}
