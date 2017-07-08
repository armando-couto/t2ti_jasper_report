<%-- 
    Document   : index
    Created on : 15/09/2008, 21:41:13
    Author     : Cláudio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Curso JasperReports / iReport - T2Ti.com</title>
    </head>
    <body>
        <h2>Curso JasperReports / iReport - T2Ti.com</h2>
        <form action="VisualizaRelatorio" method="post">
            <input type="submit" value="Visualizar Relatório" name="btVisualizaRelatorio"/>
        </form>
        <br>
        <form action="GeraPDF" method="post">
            <input type="submit" value="Gerar PDF" name="btGeraPDF"/>
        </form>
        <br>
        <form action="GeraHTML" method="post">
            <input type="submit" value="Gerar HTML" name="btGeraHTML"/>
        </form>
    </body>
</html>
