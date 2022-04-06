package com.jama.uteq.social.network.utils;

import com.jama.uteq.social.network.constants.Constants;
import com.jama.uteq.social.network.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerUtils {

    public static UserDTO getUserFromSession(HttpServletRequest request){
        return (UserDTO) request.getSession().getAttribute("user");
    }

    public static Path getProfileImagesPath() {
        return Paths.get(".").resolve(Constants.PROFILE_IMAGES);
    }
}
