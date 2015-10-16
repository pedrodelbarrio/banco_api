package com.fpmislata.banco_api.presentation.controladores;

import com.fpmislata.banco_api.presentation.JsonTransformer;
import com.fpmislata.banco_service.business.domain.EntidadBancaria;
import com.fpmislata.banco_service.business.service.EntidadBancariaService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PEDRO DEL BARRIO
 */
@Controller
public class EntidadBancariaController {

    @Autowired
    private EntidadBancariaService entidadBancariaService;
    @Autowired
    private JsonTransformer jsonTransformer;

    @RequestMapping(value = "/entidadbancaria", method = RequestMethod.GET, produces = "application/json")
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            String jsonEntidadesBancarias = jsonTransformer.toJson(entidadBancariaService.findAll());
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonEntidadesBancarias);
        } catch (Exception ex) {
            ex.printStackTrace(httpServletResponse.getWriter());
        }
    }

    @RequestMapping(value = "/entidadbancaria/{idEntidadBancaria}", method = RequestMethod.GET, produces = "application/json")
    public void get(@PathVariable("idEntidadBancaria") int idEntidadBancaria, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            EntidadBancaria entidadBancaria = entidadBancariaService.get(idEntidadBancaria);

            if (entidadBancaria == null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                String jsonEntidadBancaria = jsonTransformer.toJson(entidadBancaria);
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonEntidadBancaria);
            }
        } catch (Exception ex) {
            ex.printStackTrace(httpServletResponse.getWriter());
        }
    }
}
