<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<head>
<meta charset="utf-8" />
<title>::Cadastro de despesas::</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<link rel="stylesheet" type="text/css" href="/css/bootstrap-datepicker.standalone.css" />
</head>
<body>

	<nav class="navbar navbar-inverse navbar-static-top"></nav>
	
	<spring:form class="form-horizontal" method="POST" action="/despesas" commandName="despesa">
		
		<c:if test="${!empty mensagem}">
			<div class="alert alert-success">
				<span>${mensagem}</span>
			</div>
		
		</c:if>

		<div class="panel panel-default">
			<div class="panel-heading">
			    <a class="btn btn-link impacta-link-panel" href="/despesas">Listagem de despesa</a>
				<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
				Nova despesa
			</div>
		</div>

		<div class="form-group">
			<span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span>
			<label for="descricao" class="col-sm-2 control-label">Descrição</label>
			<div class="col-sm-4">
				<spring:input type="text" class="form-control" id="descricao" name="descricao" path="descricao"/>
				<spring:errors path="descricao" cssClass="error"/>
			</div>
		</div>

		<div class="form-group">
			<span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span>
			<label for="descricao" class="col-sm-2 control-label">Categoria</label>
			<div class="col-sm-2">
			    <select class="form-control" name="categoria">
					<c:forEach items="${todasCategorias}" var="categoria">
						<option value="${categoria}">${categoria}</option>
					</c:forEach>
				</select>	
			</div>
		</div>

		<div class="form-group">
			<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
			<label for="data" class="col-sm-2 control-label">Data</label>
			<div class="col-sm-2">
				<spring:input type="text" class="form-control" id="data" name="data" path="data"
						  data-provide="datepicker" format="dd/mm/yyyy" language="pt-BR"   
						  autoclose="true" todayHighlight="true" orientation="bottom"/>
				<spring:errors path="data" cssClass="error"/>
			</div>
		</div>

		<div class="form-group">
			<span class="glyphicon glyphicon-eur" aria-hidden="true"></span> 
			<label for="valor" class="col-sm-2 control-label">Valor</label>
			<div class="col-sm-2">
				<spring:input type="text" class="form-control" id="valor" name="valor" path="valor"/>
				<spring:errors path="valor" cssClass="error"/>
			</div>
		</div>

		<div class="form-group">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 
			<label for="observacoes" class="col-sm-2 control-label">Observações</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="observacoes" name="observacoes"/>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Salvar</button>
			</div>
		</div>

	</spring:form>
	
	<script src="/js/jquery-3.2.0.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/bootstrap-datepicker.min.js"></script>
	<script src="/js/bootstrap-datepicker.pt-BR.min.js"></script>
	
</body>
</html>