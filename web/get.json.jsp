<%@page import="com.fpmislata.banco.business.domain.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.business.service.EntidadBancariaService"%>
<%@page import="com.fpmislata.banco.business.service.impl.EntidadBancariaServiceImpl"%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>

<%
    EntidadBancariaService entidadBancariaService = new EntidadBancariaServiceImpl();
    EntidadBancaria entidadBancaria = entidadBancariaService.get(Integer.parseInt(request.getParameter("idEntidadBancaria")));
%>

{
"idEntidadBancaria":<%=entidadBancaria.getIdEntidadBancaria()%>, 
"nombre":"<%=entidadBancaria.getNombre()%>", 
"codigoEntidad":"<%=entidadBancaria.getCodigoEntidad()%>", 
"direccion":"<%=entidadBancaria.getDireccion()%>",
"CIF":"<%=entidadBancaria.getCIF()%>", 
"fechaCreacion":"<%=entidadBancaria.getFechaCreacion()%>"
}

