/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jama.uteq.social.network.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import com.jama.uteq.social.network.DAO.IPublicacion;
import com.jama.uteq.social.network.entities.Publicacion;
import com.jama.uteq.social.network.entities.User;
import com.jama.uteq.social.network.service.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Ricardo
 */
@Service
public class PublicacionServiceImp implements IPublicacionService {

    @Autowired
    private IPublicacion publicacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Publicacion> getAll() {
        return (List<Publicacion>) publicacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Publicacion> getAllByUsuario(String email) {
        return (List<Publicacion>) publicacionDao.getAllByUsuario(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Publicacion> getAllDisponiblesByUsuario(String email) {
        return null;
    }

    @Override
    @Transactional
    public void guardarImagen(String ruta, MultipartFile file, String nomArchivo) throws IOException {
        Path path = Paths.get(ruta, nomArchivo);
        Files.write(path, file.getBytes());
    }

    @Override
    @Transactional
    public void insert(Publicacion publicacion) {
        publicacionDao.save(publicacion);
    }

    @Override
    @Transactional
    public void insertar(int idUsua, String descPubl, String url) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        publicacionDao.insertar(idUsua, descPubl, url, sqlDate);
    }

    @Override
    @Transactional
    public void delete(Publicacion publicacion) {
        publicacionDao.delete(publicacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion findById(Publicacion publicacion) {
        return publicacionDao.findById(publicacion.getIdPubl()).orElse(null);
    }

}
