/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jama.uteq.social.network.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Comentarios")
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cmt;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String contenido_cmt;

    @Column(name = "fecha_cmt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_cmt;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        fecha_cmt = new Date();
    }
    //Es foranea investegir como se relaciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    @NotNull
    private User id;
    //Es foranea investegir como se relaciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pb")
    @NotNull
    private Publicacion id_pb;

    private String coment_id;

}
