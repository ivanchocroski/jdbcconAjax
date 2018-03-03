<%-- 
    Document   : VistaContacto
    Created on : 24/02/2018, 03:00:04 PM
    Author     : Usuario
--%>
<%@page import= "java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP formulario</title>
        
        <script src="..//js/jquery-1.7.2.min.js"></script>
        <script src="..//js/spin.min.js"></script>
        
        <script>
           $(document).ready(function(){
               $("#btn").click(function(e){
                   $.ajax({
                       url: './demo',
                       type: 'post',
                       data: $("#form1").serialize(),
                       success:function(rea,iv,ol){
                           alert("perfecto")
                       },
                       error:function(err,status){
                           alert(status)
                       }
                   })
               })
           })
        </script>
        <script>
            function validaForm(){
                //aqui validaremos los campos de texto que tenga el formulario
                if($("#nombre").val()== ""){
                    alert("tiene que llenar el campo nombre")
                    $("#nombre").focus();
                    return false;
                }
                if($("#apellido").val()== ""){
                    alert("tiene que llenar el campo apellido")
                    $("#apellido").focus();
                    return false;
                }
                if($("#correo").val()== ""){
                    alert("tiene que llenar el campo correo")
                    $("#correo").focus();
                    return false;
                }
                
            }
        </script>
    </head>
    
    <body>
        <form method="post" action="/ServletContacto">
            <table>
                <tr>
                    <td>Id:</td>
                    <input type="text" name="id">
                </tr>
                <tr>
                    <td>nombre:</td>
                    <input type="text" name="nombre">
                </tr>
                <tr>
                    <td>apellido:</td>
                    <input type="text" name="apellido">
                </tr>
                <tr>
                    <td>correo:</td>
                    <input type="email" name="correo">
                </tr>
                <input type="submit" name="btn" value="enviar">
            </table>
        </form>
      
    </body>
</html>
