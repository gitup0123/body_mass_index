<%--
  Created by IntelliJ IDEA.
  User: François
  Date: 14/12/2020
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>C'est la page suivante</h1>
<jsp:useBean id="imcBean" class="fr.fs.imcbean.ImcBean" scope="request"/>

<h1>
    Bonjour votre imc est de <%= imcBean.getImc().getValue()%>
</h1>
<h2>
    Interprétation : <%= imcBean.getImc().getInterpretation()%>
</h2>
</body>
</html>
