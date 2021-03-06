package com.fpmislata.banco_api.presentation.controladores;

import com.fpmislata.banco_api.presentation.JsonTransformer;
import com.fpmislata.banco_service.business.domain.EntidadBancaria;
import com.fpmislata.banco_service.business.service.EntidadBancariaService;
import com.fpmislata.banco_service.core.BusinessException;
import com.fpmislata.banco_service.core.BusinessMessage;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/entidadbancaria", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(@RequestBody String jsonEntrada, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            EntidadBancaria entidadBancaria = jsonTransformer.fromJson(jsonEntrada, EntidadBancaria.class);
            String jsonSalida = jsonTransformer.toJson(entidadBancariaService.insert(entidadBancaria));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BusinessException ex) {
            List<BusinessMessage> businessMessages = ex.getBusinessMessages();
            String jsonSalida = jsonTransformer.toJson(businessMessages);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ex.printStackTrace(httpServletResponse.getWriter());
        }
    }

    @RequestMapping(value = "/entidadbancaria", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void update(@RequestBody String jsonEntrada, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            EntidadBancaria entidadBancaria = jsonTransformer.fromJson(jsonEntrada, EntidadBancaria.class);
            String jsonSalida = jsonTransformer.toJson(entidadBancariaService.update(entidadBancaria));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            ex.printStackTrace(httpServletResponse.getWriter());
        }
    }

    @RequestMapping(value = "/entidadbancaria/{idEntidadBancaria}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("idEntidadBancaria") int idEntidadBancaria, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            if (!entidadBancariaService.delete(idEntidadBancaria)) {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch (Exception ex) {
            ex.printStackTrace(httpServletResponse.getWriter());
        }
    }

    @RequestMapping(value = "/entidadbancaria", method = RequestMethod.GET, produces = "application/json")
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            String jsonEntidadesBancarias;
            if (httpServletRequest.getParameter("nombre") != null) {
                jsonEntidadesBancarias = jsonTransformer.toJson(entidadBancariaService.findByNombre(httpServletRequest.getParameter("nombre")));
            } else {
                jsonEntidadesBancarias = jsonTransformer.toJson(entidadBancariaService.findAll());
            }
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonEntidadesBancarias);
        } catch (Exception ex) {
            ex.printStackTrace(httpServletResponse.getWriter());
        }
    }

    @RequestMapping(value = "/entidadbancaria/defaultvalue", method = RequestMethod.GET, produces = "application/json")
    public void getDefault(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            EntidadBancaria entidadBancaria = entidadBancariaService.getDefault();

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
