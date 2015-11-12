package com.fpmislata.banco_api.presentation.controladores;

import com.fpmislata.banco_api.presentation.security.WebSession;
import com.fpmislata.banco_service.business.domain.Rol;
import com.fpmislata.banco_service.business.domain.Usuario;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PEDRO DEL BARRIO
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            Usuario usuario = new Usuario(1, "usuario1", "password1", Rol.ADMINISTRADOR);
            WebSession webSession = new WebSession(usuario, new Date());
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute("webSession", webSession);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            ex.printStackTrace(httpServletResponse.getWriter());
        }
    }
}
