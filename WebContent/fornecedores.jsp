<%@ page import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="include/header_imports.jsp" %>
    <link rel="stylesheet" href="css/vendor.css">
    <title>Fornecedores</title>
</head>

<body>

    <jsp:include page="include/menu.jsp" >
	  <jsp:param name="casamentos" value="" />
	  <jsp:param name="fornecedores" value="ativo" />
	</jsp:include>

    <main>
        <!-- Rentabilidade de Fornecedores -->
        <div class="container mt-3 span-two">
            <div class="titulo">
                <div class="left-symbol-title">
                    <img src="img/barraMenu.png">
                </div>
                <div class="box-text-title">
                    <p>Rentabilidade dos Fornecedores</p>
                </div>
            </div>

            <form method="" action="" class="mb-2 align-items-center">
                <fieldset>
                    <legend>Periodo Inicial</legend>
                    <input class="ml-3" type="date" name="data-inicio" id="rentability-date-start">
                </fieldset>

                <fieldset>
                    <legend>Periodo Final</legend>
                    <input class="ml-3" type="date" name="data-fim" id="rentability-date-final">
                </fieldset>
                <br/>

                <fieldset class="option-fieldset">
                    <legend class="mb-0">Ordernar Por</legend>
                    <select class="ml-3" name="order-by" id="rentability-orderby">
                        <option value="profit_margin">Margem</option>
                        <option value="total_profit">Lucro</option>
                    </select>
                </fieldset>

                <fieldset class="option-fieldset">
                    <legend class="mb-0">Ordem</legend>
                    <select class="ml-3" name="order" id="rentability-order">
                        <option value="desc">Descrescente</option>
                        <option value="asc">Crescente</option>
                    </select>
                </fieldset>
                <label class="label-custom" style="display: none;">
                    <br/><br/>
                    <input type="checkbox" name="desconsiderar-zero" id="rentability-disregard-zero" checked="checked" /> Desconsiderar valores zerados
                </label>
                <br/>
                <input class="btn btn-filtrar mb-4" type="submit" value="Filtrar" id="btnRentabilityVendors">
                <input class="btn btn-limpar mb-4" type="reset" value="Limpar">
            </form>

            <div class="grafico m-auto span-two" id="rentability-ranking">
                <div class="box-ranking">
                    <div class="box-ranking-podium">
                        <div class="box-item-podium fourty">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="rent-id-vendor-fourty">...</span></div>
                                <div class="box-line-vendor-data"><strong>TOTAL: </strong><span id="rent-total-fourty">...</span></div>
                                <div class="box-line-vendor-data"><strong>T. FOR: </strong><span id="rent-total-vendor-fourty">...</span></div>
                                <div class="box-line-vendor-data"><strong>LUCRO: </strong><span id="rent-profit-vendor-fourty">...</span></div>
                                <div class="box-line-vendor-data"><strong>MARGEM: </strong><span id="rent-margin-vendor-fourty">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-4-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>

                        <div class="box-item-podium seccond">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="rent-id-vendor-seccond">...</span></div>
                                <div class="box-line-vendor-data"><strong>TOTAL: </strong><span id="rent-total-seccond">...</span></div>
                                <div class="box-line-vendor-data"><strong>T. FOR: </strong><span id="rent-total-vendor-seccond">...</span></div>
                                <div class="box-line-vendor-data"><strong>LUCRO: </strong><span id="rent-profit-vendor-seccond">...</span></div>
                                <div class="box-line-vendor-data"><strong>MARGEM: </strong><span id="rent-margin-vendor-seccond">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-2-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>

                        <div class="box-item-podium first">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="rent-id-vendor-first">...</span></div>
                                <div class="box-line-vendor-data"><strong>TOTAL: </strong><span id="rent-total-first">...</span></div>
                                <div class="box-line-vendor-data"><strong>T. FOR: </strong><span id="rent-total-vendor-first">...</span></div>
                                <div class="box-line-vendor-data"><strong>LUCRO: </strong><span id="rent-profit-vendor-first">...</span></div>
                                <div class="box-line-vendor-data"><strong>MARGEM: </strong><span id="rent-margin-vendor-first">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-1-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>

                        <div class="box-item-podium third">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="rent-id-vendor-third">...</span></div>
                                <div class="box-line-vendor-data"><strong>TOTAL: </strong><span id="rent-total-third">...</span></div>
                                <div class="box-line-vendor-data"><strong>T. FOR: </strong><span id="rent-total-vendor-third">...</span></div>
                                <div class="box-line-vendor-data"><strong>LUCRO: </strong><span id="rent-profit-vendor-third">...</span></div>
                                <div class="box-line-vendor-data"><strong>MARGEM: </strong><span id="rent-margin-vendor-third">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-3-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>

                        <div class="box-item-podium fifty">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="rent-id-vendor-fifty">...</span></div>
                                <div class="box-line-vendor-data"><strong>TOTAL: </strong><span id="rent-total-fifty">...</span></div>
                                <div class="box-line-vendor-data"><strong>T. FOR: </strong><span id="rent-total-vendor-fifty">...</span></div>
                                <div class="box-line-vendor-data"><strong>LUCRO: </strong><span id="rent-profit-vendor-fifty">...</span></div>
                                <div class="box-line-vendor-data"><strong>MARGEM: </strong><span id="rent-margin-vendor-fifty">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-5-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        
        <!-- Contratos de Fornecedores -->
        <div class="container mt-3 span-two">
            <div class="titulo">
                <div class="left-symbol-title">
                    <img src="img/barraMenu.png">
                </div>
                <div class="box-text-title">
                    <p>Orçamentos dos Fornecedores</p>
                </div>
            </div>

            <form method="" action="" class="mb-2 align-items-center">
                <fieldset>
                    <legend>Periodo Inicial</legend>
                    <input class="ml-3" type="date" name="data-inicio" id="invoices-date-start">
                </fieldset>

                <fieldset>
                    <legend>Periodo Final</legend>
                    <input class="ml-3" type="date" name="data-fim" id="invoices-date-final">
                </fieldset>
                <br/>

                <fieldset class="option-fieldset">
                    <legend class="mb-0">Ordernar Por</legend>
                    <select class="ml-3" name="order-by" id="invoices-orderby">
                        <option value="accepted_invoices">Aceitos</option>
                        <option value="declined_invoices">Não aceitos</option>
                    </select>
                </fieldset>

                <fieldset class="option-fieldset">
                    <legend class="mb-0">Ordem</legend>
                    <select class="ml-3" name="order" id="invoices-order">
                        <option value="desc">Descrescente</option>
                        <option value="asc">Crescente</option>
                    </select>
                </fieldset>
                
                <label class="label-custom" style="display: none;">
                    <br/><br/>
                    <input type="checkbox" name="desconsiderar-zero" id="invoices-disregard-zero" checked="checked"/> Desconsiderar valores zerados
                </label>
                <br/>
                <input class="btn btn-filtrar mb-4" type="submit" value="Filtrar" id="btnInvoicesVendors">
                <input class="btn btn-limpar mb-4" type="reset" value="Limpar">
            </form>

            <div class="grafico m-auto span-two" id="invoices-ranking">
                <div class="box-ranking">
                    <div class="box-ranking-podium">
                        <div class="box-item-podium fourty">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="invoice-id-vendor-fourty">...</span></div>
                                <div class="box-line-vendor-data"><strong>ACEITAS: </strong><span id="invoice-accepted-vendor-fourty">...</span></div>
                                <div class="box-line-vendor-data"><strong>NÃO ACEITAS: </strong><span id="invoice-declined-vendor-fourty">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-4-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>

                        <div class="box-item-podium seccond">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="invoice-id-vendor-seccond">...</span></div>
                                <div class="box-line-vendor-data"><strong>ACEITAS: </strong><span id="invoice-accepted-vendor-seccond">...</span></div>
                                <div class="box-line-vendor-data"><strong>NÃO ACEITAS: </strong><span id="invoice-declined-vendor-seccond">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-2-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>

                        <div class="box-item-podium first">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="invoice-id-vendor-first">...</span></div>
                                <div class="box-line-vendor-data"><strong>ACEITAS: </strong><span id="invoice-accepted-vendor-first">...</span></div>
                                <div class="box-line-vendor-data"><strong>NÃO ACEITAS: </strong><span id="invoice-declined-vendor-first">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-1-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>

                        <div class="box-item-podium third">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="invoice-id-vendor-third">...</span></div>
                                <div class="box-line-vendor-data"><strong>ACEITAS: </strong><span id="invoice-accepted-vendor-third">...</span></div>
                                <div class="box-line-vendor-data"><strong>NÃO ACEITAS: </strong><span id="invoice-declined-vendor-third">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-3-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>

                        <div class="box-item-podium fifty">
                            <div class="box-vendor-data">
                                <div class="box-line-vendor-data"><strong>ID: </strong><span id="invoice-id-vendor-fifty">...</span></div>
                                <div class="box-line-vendor-data"><strong>ACEITAS: </strong><span id="invoice-accepted-vendor-fifty">...</span></div>
                                <div class="box-line-vendor-data"><strong>NÃO ACEITAS: </strong><span id="invoice-declined-vendor-fifty">...</span></div>
                            </div>
                            <div class="box-vendor-bar"></div>
                            <div class="box-ic-vendor-position">
                                <img src="img/ic-5-lugar.png" alt="Ícone de Segundo Lugar">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!--Fim indicador de status-->

    </main>


    <footer class="mt-3"></footer>

    <%@ include file="include/footer_imports.jsp" %>

    <script src="js/vendor-page/vendor.js"></script>
</body>

</html>