<%@page import="com.fpmislata.banco_api.presentation.jackson.JsonTransformerImplJackson"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco_api.presentation.JsonTransformer"%>
<%@page import="com.fpmislata.banco.business.domain.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.business.service.impl.EntidadBancariaServiceImpl"%>
<%@page import="com.fpmislata.banco.business.service.EntidadBancariaService"%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>

<%
    JsonTransformer jsonTransformer = new JsonTransformerImplJackson();
    EntidadBancariaService entidadBancariaService = new EntidadBancariaServiceImpl();
    List<EntidadBancaria> entidadesBancarias = entidadBancariaService.findAll();

    String jsonEntidadesBancarias = jsonTransformer.toJson(entidadesBancarias);
    out.println(jsonEntidadesBancarias);
%>
