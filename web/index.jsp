<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  ~   This Source Code Form is subject to the terms of the Mozilla Public
  ~   License, v. 2.0. If a copy of the MPL was not distributed with this
  ~   file, You can obtain one at http://mozilla.org/MPL/2.0/.
  --%>

<html>
<head>
    <title>/ FATEC H1E / Projetos /</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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

<section id="hpasection3" style="width:37%; background: darkolivegreen; color:whitesmoke;">
    <h3>Exibindo integrantes deste projeto</h3>


    <script src="hpa_js/hpa.js"></script>
    <button id="hpabuttonasync" style="border:none;width:60%;font-size:large;"
            onclick="hparun.hpa_requisitarListagemIntegrantes()"
    >Listar!
    </button>


    <div id="hpa1lista" style="width:91%; background: darkgrey;color:white;">
    </div>

</section>


</body>
</html>
