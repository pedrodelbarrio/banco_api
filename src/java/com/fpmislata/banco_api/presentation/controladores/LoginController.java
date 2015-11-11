package com.fpmislata.banco_api.presentation.controladores;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PEDRO DEL BARRIO
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void login(@RequestBody String jsonEntrada, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {

        } catch (Exception ex) {
            ex.printStackTrace(httpServletResponse.getWriter());
        }
    }
}
