package com.jama.uteq.social.network.DAO;

import com.jama.uteq.social.network.entities.Comentarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComentariosDao extends JpaRepository<Comentarios, Long> {

    //List<Comentarios> findByid_cmt(String id_cmt);
}
