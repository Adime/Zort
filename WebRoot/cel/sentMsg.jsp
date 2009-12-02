<%@page import="br.com.zort.service.interfaces.IUserService"%>
<%@page import="br.com.zort.service.interfaces.IMessageService"%>
<%@page import="br.com.zort.util.Util"%>
<%@page import="br.com.zort.model.User"%>
<%@page import="br.com.zort.model.Item"%>
<%@page import="java.util.List"%>
<%
	String dest = (String) request.getParameter("dest");
	String msg = (String) request.getParameter("msg");
	
	String login = (String) request.getSession().getAttribute("userName");
	String pass = (String) request.getSession().getAttribute("password");
	
	IMessageService m = ((IMessageService) Util.getBean("messageService"));
	IUserService us = ((IUserService) Util.getBean("userService"));
	User u = us.getUserByLoginAndPass(login, pass);
	
	m.addOrUpdate(dest,u.getNome(),msg);
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
        <h1 id="pageTitle">Mensagem</h1>
    </div>
     <ul id="home" selected="true">
        <li>Mensagem enviada com sucesso.</li>
    </ul>
</body>
</html>
