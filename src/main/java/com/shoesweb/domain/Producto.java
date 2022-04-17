package com.shoesweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "producto", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idproducto", unique = true, nullable = false)
    @NotNull
    private Long idproducto;
    @Column(name = "autor")
    private String autor;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechasubida")
    private Date fechasubida;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "nombre")
    private String nombre;
}
