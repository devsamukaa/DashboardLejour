<%@ page import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="include/header_imports.jsp" %>
    <title>Casamentos</title>
</head>

<body>

    <jsp:include page="include/menu.jsp" >
	  <jsp:param name="casamentos" value="ativo" />
	  <jsp:param name="fornecedores" value="" />
	</jsp:include>

    <main>
        <!--Indicador de estilos de casamento por ano-->
        <div class="container mt-3 span-two">
            <div class="titulo">
                <div class="left-symbol-title">
                    <img src="img/barraMenu.png">
                </div>
                <div class="box-text-title">
                    <p>Casamentos durante o ano</p>
                </div>
            </div>

            <form method="" action="" class="mb-2 align-items-center">
                <fieldset>
                    <legend>Ano</legend>
                    <select class="ml-3" name="periodo" id = "year-value">
                        <option value="todos">Todos</option>
                        <option value="2020">2020</option>
                        <option value="2019">2019</option>
                        <option value="2018">2018</option>
                    </select>
                </fieldset>



                <fieldset>
                    <legend>Estilo</legend>
                    <select class="ml-3" name="estilo" id="style-weddings-year">
                        <option value="todos">Todos</option>
                        <option value="classico">Clássico</option>
                        <option value="moderno">Moderno</option>
                        <option value="rustico">Rústico</option>
                    </select>
                </fieldset>

                <label class="label-custom">
                    <input type="checkbox" name="mostrar-sem-data" id="mostrar-sem-data" /> s/ data
                </label>
                <br/>
                <input class="btn btn-filtrar mb-4" type="submit" value="Filtrar" id="btnYear">
                <input class="btn btn-limpar mb-4" type="reset" value="Limpar">
            </form>

            <div class="grafico m-auto loading span-two" id="weddings-during-year">
                <canvas id="wedding-year" width="1000" height="600"></canvas>
            </div>

        </div>
        <!--Fim indicador de estilos de casamento por ano-->

        <!--Indicador de budget -->
        <div class="container mt-3 budget">
            <div class="titulo">
                <div class="left-symbol-title">
                    <img class="border m-0" src="img/barraMenu.png">
                </div>
                <div class="box-text-title">
                    <p>Casamentos com o budget acima de (R$)</p>
                </div>
            </div>

            <form action="" method="">
                <fieldset>
                    <legend>Periodo Inicial</legend>
                    <input class="ml-3" type="date" name="" id="initial-period">
                </fieldset>

                <fieldset>
                    <legend>Periodo Final</legend>
                    <input class="ml-3" type="date" name="" id="final-period">
                </fieldset>
                <br/>
                <input type="range" class="bar" id="budget" value="100000" min = "0" max = "1000000">
                <b>R$</b><span>100000</span>
                <br/>
                <input class="btn btn-filtrar mb-3" type="submit" value="Filtrar" id="btnBudget">
                <input class="btn btn-limpar mb-4" type="reset" value="Limpar">
            </form>

            <div class="grafico loading" id="budget-chart">
                <canvas id="wedding-budget" width="290" height="210"></canvas>
            </div>
        </div>
        <!--Fim indicador de budget -->

        <!--Indicador de status-->
        <div class="container mt-3">
            <div class="titulo">
                <div class="left-symbol-title">
                    <img src="img/barraMenu.png">
                </div>
                <div class="box-text-title">
                    <p>Status dos casamentos</p>
                </div>
            </div>

            <form method="" action="">
                <fieldset>
                    <legend>Periodo Inicial</legend>
                    <input class="ml-3" type="date" name="" id="inicio">
                </fieldset>

                <fieldset>
                    <legend>Periodo Final</legend>
                    <input class="ml-3" type="date" name="" id="final">
                </fieldset>

                <fieldset class="option-fieldset">
                    <legend class="mb-0">Estilo</legend>
                    <select class="ml-3" name="estilo" id="style-status">
                        <option value="todos">Todos</option>
                        <option value="classico">Clássico</option>
                        <option value="moderno">Moderno</option>
                        <option value="rustico">Rústico</option>
                    </select>
                </fieldset>
                <br/>
                <input class="btn btn-filtrar mb-4" type="submit" value="Filtrar" id="btnStatus">
                <input class="btn btn-limpar mb-4" type="reset" value="Limpar">
            </form>

            <div class="grafico loading" id="status-wedding-chart">
                <canvas id="wedding-status" width="290" height="210"></canvas>
            </div>
        </div>
        <!--Fim indicador de status-->

    </main>


    <footer class="mt-3"></footer>

    <%@ include file="include/footer_imports.jsp" %>
    
    <script src="js/wedding-page/wedding-charts.js"></script>
</body>

</html>