/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.jama.uteq.social.network.controllers;

import com.jama.uteq.social.network.entities.*;
import com.jama.uteq.social.network.repositories.FriendshipRepository;
import com.jama.uteq.social.network.repositories.UserRepository;
import com.jama.uteq.social.network.service.IPublicacionService;
import com.jama.uteq.social.network.service.impl.FriendsServiceImpl;
import com.jama.uteq.social.network.service.impl.IComentariosServiceImp;
import com.jama.uteq.social.network.service.impl.IPublicacionServiceImp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.jama.uteq.social.network.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author playe
 */
@org.springframework.stereotype.Controller
@Slf4j
public class ControllerPublicacion {

    @Autowired
    IPublicacionService publicacionService;

    @Autowired
    UserServiceImpl usuarioService;

    @GetMapping("/publicaciones")
    public String page(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Publicacion> publicaciones = publicacionService.getAll();
        model.addAttribute("publicaciones", publicaciones);
        return "publicaciones";
    }

    @PostMapping(path = "/insert")
    @ResponseBody
    public ModelAndView subirImagen(@RequestParam("url") String url, @RequestParam("publicacion") String publicacion, HttpServletRequest request, HttpServletResponse response) {

        Response respuesta = new Response();

        respuesta.setRespuesta(true);

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            int random = new Random().nextInt();

            publicacionService.insertar(usuarioService.getUserByEmail(authentication.getName()).getId().intValue(), publicacion, url);

            //Delay para que alcance a subirse la imágen al servidor y cargue correctamente
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            respuesta.setRespuesta(false);
            respuesta.setDescripcion("Error al subir imagen" + e.toString());
        }

        return new ModelAndView("redirect:/publicaciones");
    }
}