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
        <h1 id="pageTitle">Envio de Mensagem</h1>
    </div>
    <div id="itens" title="Itens" class="panel" selected="true">
        <form id="item-form" action="sentMsg.jsp" method="post">
	        	<label>Nome do destinatário:</label>
	        	<input type="text" name="dest"/>
	        	<label>Mensagem:</label>
	        	<input type="text" name="msg"/>
	        <input type="submit" name="submit" value="Enviar mensagem"/>
        </form>
    </div>
</body>
</html>
