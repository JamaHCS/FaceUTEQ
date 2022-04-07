/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jama.uteq.social.network.entities;

import java.io.Serializable;


public class Response implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1793052093561825995L;

    /** The respuesta. */
    private boolean respuesta;

    /** The descripcion. */
    private String descripcion;

    /**
     * Instantiates a new respuesta operacion model.
     */
    public Response() {
        super();
    }

    /**
     * Checks if is respuesta.
     *
     * @return true, if is respuesta
     */
    public boolean isRespuesta() {
        return respuesta;
    }

    /**
     * Sets the respuesta.
     *
     * @param respuesta the new respuesta
     */
    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * Gets the descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the descripcion.
     *
     * @param descripcion the new descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RespuestaOperacionModel [respuesta=").append(respuesta).append(", descripcion=")
                .append(descripcion).append("]");
        return builder.toString();
    }

}