package com.shoesweb.mapper;

import com.shoesweb.domain.Producto;

import com.shoesweb.dto.ProductoDTO;

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
public interface ProductoMapper {
    public ProductoDTO productoToProductoDTO(Producto producto);

    public Producto productoDTOToProducto(ProductoDTO productoDTO);

    public List<ProductoDTO> listProductoToListProductoDTO(
        List<Producto> productos);

    public List<Producto> listProductoDTOToListProducto(
        List<ProductoDTO> productoDTOs);
}
