<%@ page import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="fixed-top menu shadow-sm d-block d-xl-none">
    <nav class="navbar justify-content-end">
        <img src="img/logo.png" class="mr-auto" alt="">
        <button class="navbar-toggler " data-toggle="collapse" data-target="#navbarToggleExternalContent"
            aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
            <img src="img/Menu.png" alt="Logo">
        </button>
    </nav>
    <div class="collapse" id="navbarToggleExternalContent">
        <div class="p-4">
            <a href="./index.html" class="menu-item mx-0 my-3 pl-3 pb-1 border-bottom ${param.casamentos}">Casamentos</a>
            <a href="./fornecedores.html" class="menu-item mx-0 my-3 pl-3 pb-1 border-bottom ${param.fornecedores}">Fornecedores</a>
        </div>
    </div>
</div>

<aside class="d-none d-xl-block">
    <div class="p-4">
        <img class="ml-5 my-4" src="img/logo.png" class="mr-auto" alt="">
        <a href="./index.jsp" class="menu-item mx-0 my-3 pl-3 pb-1 border-bottom ${param.casamentos}">Casamentos</a>
        <a href="./fornecedores.jsp" class="menu-item mx-0 my-3 pl-3 pb-1 border-bottom" ${param.fornecedores}">Fornecedores</a>
    </div>
</aside>