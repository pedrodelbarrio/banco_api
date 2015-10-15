package com.fpmislata.banco_api.presentation.controladores;

import com.fpmislata.banco_api.presentation.JsonTransformer;
import com.fpmislata.banco_api.presentation.jackson.JsonTransformerImplJackson;
import com.fpmislata.banco_service.business.domain.EntidadBancaria;
import com.fpmislata.banco_service.business.service.EntidadBancariaService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = {"/findall"})
    public void findAll(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws IOException {
        List<EntidadBancaria> entidadesBancarias = entidadBancariaService.findAll();
        String jsonEntidadesBancarias = jsonTransformer.toJson(entidadesBancarias);
        httpServletResponse.getWriter().println(jsonEntidadesBancarias);
    }

    @RequestMapping(value = {"/get"})
    public void get(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws IOException {
        EntidadBancaria entidadBancaria = entidadBancariaService.get(Integer.parseInt(httpRequest.getParameter("idEntidadBancaria")));
        String jsonEntidadBancaria = jsonTransformer.toJson(entidadBancaria);
        httpServletResponse.getWriter().println(jsonEntidadBancaria);
    }
}
