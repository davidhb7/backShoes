package com.shoesweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String apellidos;
    @NotNull
    private Long cedula;
    private String contra;
    private String email;
    private String estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private String nombre;
    private String telefono;
    private String usuariocreador;
    private String usuariomodificador;
}
