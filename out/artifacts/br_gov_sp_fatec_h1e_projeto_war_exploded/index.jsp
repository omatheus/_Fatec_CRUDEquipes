<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>/ FATEC H1E / Projetos /</title>
</head>
<body id="hpabody">

<section id="hpasection1">

    <div id="hpadiv1_top" style="background: goldenrod; color:white">

        <h3>
            Gerindo minha equipe!
        </h3>

    </div>


    <div id="hpadiv2_top" style="background: lightcyan; color:black">
        <h4>
            Atraves desta interface, faca qualquer gerenciamento de sua equipe!
        </h4>
    </div>

</section>

<center>

    <section id="hpasection2">

        <form action="hpabi" method="get">
            <input type="hidden" name="hpa_obt_oper" value="2"/>
            <input type="submit"
                   value="Listar alunos disponiveis."
                   style="color:darkgoldenrod;border: none; font-size: larger;">
        </form>


    </section>

</center>

</body>
</html>
