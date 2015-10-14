<%@page import="com.fpmislata.banco_api.presentation.JsonTransformer"%>
<%@page import="com.fpmislata.banco_api.presentation.jackson.JsonTransformerImplJackson"%>
<%@page import="com.fpmislata.banco_service.business.domain.EntidadBancaria"%>
<%@page import="com.fpmislata.banco_service.business.service.EntidadBancariaService"%>
<%@page import="com.fpmislata.banco_service.business.service.impl.EntidadBancariaServiceImpl"%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>

<%
    JsonTransformer jsonTransformer = new JsonTransformerImplJackson();
    EntidadBancariaService entidadBancariaService = new EntidadBancariaServiceImpl();
    EntidadBancaria entidadBancaria = entidadBancariaService.get(Integer.parseInt(request.getParameter("idEntidadBancaria")));

    String jsonEntidadBancaria = jsonTransformer.toJson(entidadBancaria);
    out.println(jsonEntidadBancaria);
%>
