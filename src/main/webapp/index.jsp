<%@ page import="fr.fs.imcbean.ImcBean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Exercice 05</title>
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="imcBean" class="fr.fs.imcbean.ImcBean" scope="request">
        <jsp:setProperty name="imcBean" property="*"/>
    </jsp:useBean>
</head>
<body>

<% if (imcBean.validate()) {%>
<jsp:forward page="pageSuivante.jsp"/>
<% } %>
<br/>

<h1>Calcul de l'IMC</h1>
<br>

<form action="index.jsp" method="post">

    <h2>Vos données</h2>
    <br>
    <div>
        <label for="taille">Taille en cm :</label>
        <input type="text" id="taille" name="taille"
               value="<jsp:getProperty name="imcBean" property="taille" />">
        <div class="errormessage">
            <%= imcBean.getError(ImcBean.TAILLE_KEY)%>
        </div>
    </div>
    <div>
        <label for="poids">Poids en Kg :</label>
        <input type="text" id="poids" name="poids"
               value="<jsp:getProperty name="imcBean" property="poids" />">
        <div class="errormessage">
            <%= imcBean.getError(ImcBean.POIDS_KEY)%>
        </div>
    </div>
    <input type="hidden" id="cpt" name="cpt" value="<jsp:getProperty name="imcBean" property="cpt"/>">
    <br>
    <button class="myButton" type="submit">Valider</button>

</form>
</body>
</html>