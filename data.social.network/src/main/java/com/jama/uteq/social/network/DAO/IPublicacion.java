/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jama.uteq.social.network.DAO;

import java.util.List;
import com.jama.uteq.social.network.entities.Publicacion;
import com.jama.uteq.social.network.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import java.util.Date;
import java.sql.Date;


@Repository
public interface IPublicacion extends JpaRepository<Publicacion, Long> {

    @Query(value = "SELECT * FROM publicacion, user\n"
            + "WHERE publicacion.id = user.id\n"
            + "AND username = ?1\n"
            + "ORDER BY(fa_publ) DESC", nativeQuery = true)
    List<Publicacion> getAllByUsuario(String email);

    @Query(value = "SELECT * FROM publicacion "
            + "ORDER BY(fa_publ) DESC", nativeQuery = true)
    List<Publicacion> getAllDisponiblesByUsuario();

    @Modifying
    @Query(value = "INSERT INTO publicacion(id, desc_publ, foto_publ, fa_publ) VALUES(?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertar(int idUsua, String descPubl, String url, Date date);
}
