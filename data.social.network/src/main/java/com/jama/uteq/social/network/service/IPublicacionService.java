package com.jama.uteq.social.network.service;

import com.jama.uteq.social.network.entities.Publicacion;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPublicacionService {
    public List<Publicacion> getAll();
    public List<Publicacion> getAllByUsuario(String email);
    public List<Publicacion> getAllDisponiblesByUsuario(String email);
    void guardarImagen(String ruta, MultipartFile file, String nomArchivo) throws IOException;
    public void insert(Publicacion publicacion);
    public void insertar(int idUsua, String descPubl, String url);
    public void delete(Publicacion publicacion);
    public Publicacion findById(Publicacion publicacion);
}
