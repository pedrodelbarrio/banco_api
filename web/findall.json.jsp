<%@page import="com.fpmislata.banco.business.domain.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.business.service.impl.EntidadBancariaServiceImpl"%>
<%@page import="com.fpmislata.banco.business.service.EntidadBancariaService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>

<%
    EntidadBancariaService entidadBancariaService = new EntidadBancariaServiceImpl();
    List<EntidadBancaria> entidadesBancarias = entidadBancariaService.findAll();
    int i = 0;
%>

[

<%
    for (EntidadBancaria entidadBancaria : entidadesBancarias) {
%>

{
"idEntidadBancaria":<%=entidadBancaria.getIdEntidadBancaria()%>, 
"nombre":"<%=entidadBancaria.getNombre()%>", 
"codigoEntidad":"<%=entidadBancaria.getCodigoEntidad()%>", 
"direccion":"<%=entidadBancaria.getDireccion()%>",
"CIF":"<%=entidadBancaria.getCIF()%>", 
"fechaCreacion":"<%=entidadBancaria.getFechaCreacion()%>"
}

<%
    if (i != entidadesBancarias.size() - 1) {
%>

,

<%
        } else {
            //no tengo que hacer nada
        }
        i++;
    }
%>

]

