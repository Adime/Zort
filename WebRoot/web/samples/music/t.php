<!DOCTYPE html>
<html manifest="music.manifest">
<head>
<title>Zort</title>
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;"/>
<link rel="apple-touch-icon" href="../../iui/iui-logo-touch-icon.png" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../../iui/iui.css" type="text/css" />
<link rel="stylesheet" href="../../iui/iui-moz.css" type="text/css" />
<link rel="stylesheet" title="Default" href="../../iui/t/default/default-theme.css"  type="text/css"/>
<link rel="alternate stylesheet" title="iPhoneDevCamp" href="../../iui/t/ipdc/ipdc-theme.css"  type="text/css"/>
<script type="application/x-javascript" src="../../iui/iui.js"></script>
<script type="application/x-javascript" src="../../iui/js/iui-theme-switcher.js"></script>
<script type="application/x-javascript" src="music-app.js"></script>

</head>

<body>
<div class="toolbar">
        <h1 id="pageTitle"></h1>
</div>
<ul id="home" title="<?php echo $_POST['userName']; ?>" selected="true">
        <li><a href="#artists">Mensagem</a></li>
        <li><a href="#settings">Itens</a></li>
</ul>
    
</body>
</html>