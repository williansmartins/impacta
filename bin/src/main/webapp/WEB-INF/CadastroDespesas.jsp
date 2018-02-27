<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8" />
	<title>Insert title here</title>
	<link href="/css/bootstrap.css" rel="stylesheet" />
	<link href="/css/styles.css" rel="stylesheet" />
	<link href="/css/bootstrap-datepicker.min.css" rel="stylesheet" />
</head>
<body>
	<c:if test="${!empty mensagem}">
		<div class="alert alert-success">
			<span>${mensagem}</span>
		</div>
	</c:if>

	<div id="login-modal" class="base">
		<div class="modal-dialog">
			<div class="loginmodal-container">
				<h1>Nova Despesa</h1>
				<br />
				<spring:form class="form-horizontal" method="POST" action="/despesas" commandName="despesa">
					<div class="form-group">
						<label for="descricao" class="control-label">Descricao:</label>
						<div class="col-sm-12">
							<spring:input type="text" name="descricao" placeholder="descricao"  class="form-control" path="descricao"/>
							<spring:errors path="descricao" cssClass="error" /> 
						</div>
					</div>
					<div class="form-group">
					  <label for="categoria" class="control-label">Categoria:</label>
					  <div class="col-sm-12">
						  <select class="form-control" id="categoria" name="categoria">
						   	<c:forEach items="${todasCategorias}" var="categoria">
							    <option value="${categoria}">${categoria}</option>
						   	</c:forEach>
						  </select>
					  </div>
					</div>
					<div class="form-group">
						<label for="descricao" class="control-label">Data:</label>
						<div class="col-sm-12">
							<spring:input type="text" name="data" placeholder="data" class="form-control" path="data"
								data-provide="datepicker" 
								data-date-autoclose="true"
								data-date-orientation="bottom"/> 
							<spring:errors path="data" cssClass="error" /> 
						</div>
					</div>
					<div class="form-group">
						<label for="valor" class="control-label">Valor:</label>
						<div class="col-sm-12">
							<spring:input type="text" name="valor" placeholder="valor" class="form-control" path="valor"/> 
							<spring:errors path="valor" cssClass="error" /> 
						</div>
					</div>
					<div class="form-group">
						<label for="observacoes" class="control-label">Observacoes:</label>
						<div class="col-sm-12">
							<input type="text" name="observacoes" placeholder="observacoes" class="form-control"/> 
						</div>
					</div>
					<input type="submit" name="login" class="login loginmodal-submit" value="salvar" />
				</spring:form>
			</div>
		</div>
	</div>
	
	<div class="base">
		<div class="modal-dialog">
			<form method="get" action="/despesas" >
				<div class="form-group">
					<div class="col-sm-4">
						<div class="input-group">
							<input class="form-control"
								placeholder="..."
								autoFocus="autofocus"
								name="descricao" />
							<span class="input-group-btn">
								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
					</div>
				</div>
			</form>
			<div class="listagem">
				<h1>Listagem</h1>
				<div id="lista">
					<table class="table">
						<tr>
							<th>#</th>
							<th>descricao</th>
							<th>categoria</th>
							<th>data</th>
							<th>valor</th>
							<th>acoes</th>
						</tr>
				      <c:forEach items="${despesas}" var="despesa">
					      <tr>
					         <td>${despesa.codigo}</td>
					         <td>${despesa.descricao}</td>
					         <td>${despesa.categoria}</td>
					         <td><fmt:formatDate value="${despesa.data}" type="date" pattern="dd/MM/yyyy"/></td>
					         <td><fmt:formatNumber value="${despesa.valor}" type="currency" /></td>
					         <td>
					         	<a class="btn btn-link btn-xs" data-toggle="modal" data-target="#confirmaRemocaoModal" data-whatever="${despesa.codigo}">
					         		<span class="glyphicon glyphicon-remove"></span>
					         	</a>
					         </td>
					      </tr>
				   	</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="confirmaRemocaoModal" tabindex="-1" data-keyboard="false" data-backdrop="static">
		<div class="modal-dialog">
			<form action="/despesas" method=POST>
				<input type="hidden" name="_method" value="DELETE">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Confirmacao</h4>
					</div>
				</div>
				<div class="modal-body">
					<span>Deseja realmente remover esta despesa?</span>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-link" data-dimiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-primary">Confirmar</button>
				</div>
			</form>
		</div>
	</div>
	<script
	  src="https://code.jquery.com/jquery-3.2.1.js"
	  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	  crossorigin="anonymous"></script>
	<script type="text/javascript" src="/js/bootstrap.js"></script>
	<script type="text/javascript" src="/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="/js/despesas.js"></script>
</body>
</html>