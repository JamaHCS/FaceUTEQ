package com.jama.uteq.social.network.DAO;

import com.jama.uteq.social.network.entities.Publicacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublicacionDao extends JpaRepository<Publicacion, Long> {
    //List<Publicacion> findById_usu (String Id_usu);
}
