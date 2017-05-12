/*
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

var HPAhpa = function () {
};

HPAhpa.prototype.hpa_requisitarListagemIntegrantes = function () {

    console.log("#HPAWebContent: Inicializando requisicao async dos integrantes.");

    $.get("hpabi?hpa_obt_oper=3", function (hpa_resposta) {

        $("#hpa1lista").html(hpa_resposta);

    });

    console.log("#HPAWebContent: Encerrando bloco de sub-rotina.");

};

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
var hparun = new HPAhpa();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//hparun.hpa_requisitarListagemIntegrantes();