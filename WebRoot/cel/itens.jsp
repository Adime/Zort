<%@page import="br.com.zort.service.interfaces.IUserService"%>
<%@page import="br.com.zort.util.Util"%>
<%@page import="br.com.zort.model.User"%>
<%@page import="br.com.zort.model.Item"%>
<%@page import="java.util.List"%>
<%
	String login = (String) request.getSession().getAttribute("userName");
	String pass = (String) request.getSession().getAttribute("password");
	
	String result = "";
	
	IUserService us = ((IUserService) Util.getBean("userService"));
	User u = us.getUserByLoginAndPass(login, pass);
	
	List<Item> items = us.getItemsByUser(u);
	
	for (Item i : items)
	{
		result += "<div class=\"row\">";
		result += "<label>" + i.getName() +"</label>";
		result += "<INPUT TYPE=radio NAME='item' VALUE='" + i.getId() +"'/>";
		result += "<img src='../br/com/zort/assets/items/" + i.getImage() + ".png' width='30' height='30'/>";
		result += "</div>";
	}
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
  	  <a class="button" href="login.jsp">Voltar</a>
        <h1 id="pageTitle">Lista de Itens</h1>
    </div>
    <div id="itens" title="Itens" class="panel" selected="true">
        <h2>Itens</h2>
        <form id="item-form" action="sendItem.jsp" method="post">
	        	<%= result %>
	        <input type="submit" name="submit" value="Enviar para um amigo"/>
        </form>
    </div>
</body>
</html>
