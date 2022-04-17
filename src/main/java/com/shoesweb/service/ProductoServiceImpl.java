package com.shoesweb.service;

import com.shoesweb.domain.*;

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
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(Producto producto) throws ConstraintViolationException {
        Set<ConstraintViolation<Producto>> constraintViolations = validator.validate(producto);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return productoRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        log.debug("finding all Producto instances");

        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Producto save(Producto entity) throws Exception {
        log.debug("saving Producto instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Producto");
        }

        validate(entity);

        if (productoRepository.existsById(entity.getIdproducto())) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return productoRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Producto entity) throws Exception {
        log.debug("deleting Producto instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Producto");
        }

        if (entity.getIdproducto() == null) {
            throw new ZMessManager().new EmptyFieldException("idproducto");
        }

        if (productoRepository.existsById(entity.getIdproducto()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        productoRepository.deleteById(entity.getIdproducto());
        log.debug("delete Producto successful");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Long id) throws Exception {
        log.debug("deleting Producto instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("idproducto");
        }

        if (productoRepository.existsById(id)) {
            delete(productoRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Producto update(Producto entity) throws Exception {
        log.debug("updating Producto instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Producto");
        }

        validate(entity);

        if (productoRepository.existsById(entity.getIdproducto()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return productoRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long idproducto) {
        log.debug("getting Producto instance");

        return productoRepository.findById(idproducto);
    }
}
