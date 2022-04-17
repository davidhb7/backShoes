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
@Table(name = "cliente", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cedula", unique = true, nullable = false)
    @NotNull
    private Long cedula;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "contra")
    private String contra;
    @Column(name = "email")
    private String email;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechacreacion")
    private Date fechacreacion;
    @Column(name = "fechamodificacion")
    private Date fechamodificacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "usuariocreador")
    private String usuariocreador;
    @Column(name = "usuariomodificador")
    private String usuariomodificador;
}
