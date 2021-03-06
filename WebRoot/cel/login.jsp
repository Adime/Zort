<%@page import="br.com.zort.service.interfaces.IUserService"%>
<%@page import="br.com.zort.util.Util"%>
<%@page import="br.com.zort.model.User"%>
<%
	
	String login = (String) request.getSession().getAttribute("userName");
	String pass = (String) request.getSession().getAttribute("password");
	
	IUserService us = ((IUserService) Util.getBean("userService"));
	User u = us.getUserByLoginAndPass(login, pass);
	
	String result = "";
	result = u.getNome();
	
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
  	  <a class="button" href="index.html">Voltar</a>
        <h1 id="pageTitle"><%= result %></h1>
    </div>
    <ul id="home" selected="true">
        <li><a href="msg.jsp">Mensagem</a></li>
        <li><a href="itens.jsp">Itens</a></li>
<!--        <li><img src="iui/iui-logo-touch-icon.png"/></li>-->
    </ul>
</body>
</html>
