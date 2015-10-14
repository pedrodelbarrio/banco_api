<%@page import="com.fpmislata.banco_api.presentation.JsonTransformer"%>
<%@page import="com.fpmislata.banco_api.presentation.jackson.JsonTransformerImplJackson"%>
<%@page import="com.fpmislata.banco_service.business.domain.EntidadBancaria"%>
<%@page import="com.fpmislata.banco_service.business.service.EntidadBancariaService"%>
<%@page import="com.fpmislata.banco_service.business.service.impl.EntidadBancariaServiceImpl"%>
<%@page import="java.util.List"%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>

<%
    JsonTransformer jsonTransformer = new JsonTransformerImplJackson();
    EntidadBancariaService entidadBancariaService = new EntidadBancariaServiceImpl();
    List<EntidadBancaria> entidadesBancarias = entidadBancariaService.findAll();

    String jsonEntidadesBancarias = jsonTransformer.toJson(entidadesBancarias);
    out.println(jsonEntidadesBancarias);
%>
