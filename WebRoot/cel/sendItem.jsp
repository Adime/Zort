<%@page import="br.com.zort.service.interfaces.IUserService"%>
<%@page import="br.com.zort.util.Util"%>
<%@page import="br.com.zort.model.User"%>
<%@page import="br.com.zort.model.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.Integer"%>
<%

	String itemId = request.getParameter("item");

	IUserService us = ((IUserService) Util.getBean("userService"));
	Item i = us.getItemById(Integer.parseInt(itemId));
	
	String result = "";
	result += "<div class=\"row\">";
	result += "<label>" + i.getName() +"</label>";
	result += "<img src='../br/com/zort/assets/items/" + i.getImage() + ".png' width='30' height='30'/>";
	result += "</div>";
	result += "<div class=\"row\">";
	result += "<label>Ataque: " + i.getAttack() + " Defesa: " + i.getDefense() + "</label>";
	result += "</div>";
	
%>
<!DOCTYPE html>
<head>
<title>Zort</title>
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;"/>
<link rel="apple-touch-icon" href="iui/iui-logo-touch-icon.png" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="iui/iui.css" type="text/css" />
<link rel="stylesheet" href="iui/iui-moz.css" type="text/css" />
<link rel="stylesheet" title="Default" href="iui/t/default/default-theme.css"  type="text/css"/>
<link rel="alternate stylesheet" title="iPhoneDevCamp" href="iui/t/ipdc/ipdc-theme.css"  type="text/css"/>
</head>

<body>
    <div class="toolbar">
  	  <a class="button" href="itens.jsp">Voltar</a>
        <h1 id="pageTitle">Enviar itens</h1>
    </div>
    <div id="send" title="Enviar itens" class="panel" selected="true">
    	
        <form id="send-form" action="dispatchItem.jsp" method="post">
        	<%= result %>
        	<label></label>
        	<label>Nome do destinatário</label>
        	<input type="text" name="dest"/>
        	<input type="hidden" name="item" value="<%=itemId %>"/>
	        <input type="submit" name="submit" value="Confirmar envio!"/>
        </form>
    </div>
</body>
</html>
