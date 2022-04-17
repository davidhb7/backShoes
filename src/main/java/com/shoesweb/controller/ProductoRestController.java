package com.shoesweb.controller;

import com.shoesweb.domain.*;

import com.shoesweb.dto.ProductoDTO;

import com.shoesweb.mapper.ProductoMapper;

import com.shoesweb.service.ProductoService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

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
@RequestMapping("/api/v1/producto")
@CrossOrigin(origins = "*")
@Slf4j
public class ProductoRestController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ProductoMapper productoMapper;

    @GetMapping(value = "/{idproducto}")
    public ResponseEntity<?> findById(
        @PathVariable("idproducto")
    Long idproducto) throws Exception {
        log.debug("Request to findById() Producto");

        Producto producto = (productoService.findById(idproducto).isPresent() == true)
            ? productoService.findById(idproducto).get() : null;

        return ResponseEntity.ok()
                             .body(productoMapper.productoToProductoDTO(
                producto));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Producto");

        return ResponseEntity.ok()
                             .body(productoMapper.listProductoToListProductoDTO(
                productoService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    ProductoDTO productoDTO) throws Exception {
        log.debug("Request to save Producto: {}", productoDTO);

        Producto producto = productoMapper.productoDTOToProducto(productoDTO);
        producto = productoService.save(producto);

        return ResponseEntity.ok()
                             .body(productoMapper.productoToProductoDTO(
                producto));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    ProductoDTO productoDTO) throws Exception {
        log.debug("Request to update Producto: {}", productoDTO);

        Producto producto = productoMapper.productoDTOToProducto(productoDTO);
        producto = productoService.update(producto);

        return ResponseEntity.ok()
                             .body(productoMapper.productoToProductoDTO(
                producto));
    }

    @DeleteMapping(value = "/{idproducto}")
    public ResponseEntity<?> delete(@PathVariable("idproducto")
    Long idproducto) throws Exception {
        log.debug("Request to delete Producto");

        productoService.deleteById(idproducto);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(productoService.count());
    }
}
