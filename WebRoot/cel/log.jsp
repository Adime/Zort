<%@page import="br.com.zort.service.interfaces.IUserService"%>
<%@page import="br.com.zort.util.Util"%>
<%@page import="br.com.zort.model.User"%>
<%@page import="java.util.Collection"%>
<%
	String login = request.getParameter("userName");
	String pass = request.getParameter("password");
	
	IUserService us = ((IUserService) Util.getBean("userService"));
	User u = us.getUserByLoginAndPass(login, pass);
	
	if (u != null)
	{
		request.getSession().setAttribute("userName", u.getLogin());
		request.getSession().setAttribute("password", u.getPassword());
		response.sendRedirect("login.jsp");
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
  	  <a class="button" href="index.html">Voltar</a>
        <h1 id="pageTitle">Erro</h1>
    </div>
    <ul id="home" selected="true">
        <li>Usu&aacute;rio ou senha inv&aacute;lido.</a></li>
    </ul>
</body>
</html>
