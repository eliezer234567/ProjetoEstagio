<%-- 
    Document   : menunutricionista
    Created on : 12/12/2015, 16:55:46
    Author     : Eliezer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>



</head>


<div class="col-md-3 left_col">
    <div class="left_col scroll-view">

        <div class="navbar nav_title" style="border: 0;">
            <a href="<%= request.getContextPath()%>/ListarConsulta?idPessoa=<%=session.getAttribute("id")%>" class="site_title" ><i class="fa fa-home"></i> <span>NutriSIS</span></a>
        </div>
        <div class="clearfix"></div>

        <!-- menu prile quick info -->
        <div class="profile">
            <div class="profile_pic">
                <a href="<%= request.getContextPath()%>/CarregarInformacaoNutricionista">
                    <% String foto2 = session.getAttribute("foto").toString(); %>
                    <img src="<% if(foto2 == null || foto2.equals("")){ 
                                                            out.print(request.getContextPath()+"/production/images/user.png");
                                                        } else {
                                                            out.print(request.getContextPath()+foto2);
                                                        }%>" height="60px" alt="..." class="img-circle profile_img">
                </a>
            </div>
            <div class="profile_info">
                <span>Bem Vindo(a)</span>
                <h2 style="text-transform: capitalize"><%= session.getAttribute("nome")%></h2>
            </div>
        </div>
        <!-- /menu prile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

            <div class="menu_section">
                <h3>Nutricionista</h3>
                <ul class="nav side-menu">
                    <li><a href="<%= request.getContextPath()%>/ListarConsulta?idPessoa=<%=session.getAttribute("id")%>"><i class="fa fa-home"></i> Inicio </a>

                    </li>
                    <li><a><i class="fa fa-edit"></i> Consultas <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <!--Chama o servlet CarregarDadosNutricionistta e através idPessoa eu cadastro o idNutricionista na consulta-->
                            <li><a href="<%= request.getContextPath()%>/CarregarDadosNutricionista?idPessoa=<%=session.getAttribute("id")%>">Cadastrar Consulta</a>
                            </li>
                            <li><a href="<%= request.getContextPath()%>/ListarConsulta?idPessoa=<%=session.getAttribute("id")%>">Listar Consultas Agendadas</a>
                            </li>
                            <li><a href="<%= request.getContextPath()%>/ListarConsultasRealizadas?idPessoa=<%=session.getAttribute("id")%>">Listar Consultas Realizadas</a>
                            </li>


                        </ul>
                    </li>
                    <li><a><i class="fa fa-desktop"></i> Pacientes <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="<%= request.getContextPath()%>/nutricionista/cadastrarpaciente.jsp">Cadastrar Pacientes</a>
                            </li>
                            <li><a href="<%= request.getContextPath()%>/ListarPaciente?idPessoa=<%=session.getAttribute("id")%>">Listar Pacientes</a>
                            </li>
                            <li><a href="<%= request.getContextPath()%>/nutricionista/cadastrarfrequenciaalimentar.jsp">Cadastrar Frequencia Alimentar</a>
                            </li>

                        </ul>
                    </li>
                    <li><a><i class="fa fa-table"></i> Cardapio <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="<%= request.getContextPath()%>/DadosCardapio">Cadastrar Cardápio</a>
                            </li>
                            <li><a href="<%=request.getContextPath()%>/ListarCardapio">Listar Cardápio</a>
                            </li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-bar-chart-o"></i> Alimentos <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">

                            <li> <a href="<%= request.getContextPath()%>/nutricionista/cadastraralimento.jsp">Cadastrar Alimentos</a></li>

                            <li><a href="<%= request.getContextPath()%>/ListarAlimentoPorStatus">Listar Alimentos</a>
                            </li>

                        </ul>
                    </li>
                    <li><a><i class="fa fa-bar-chart-o"></i> Patologias <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="chartjs.html">Cadastrar Patologias</a>
                            </li>
                            <li><a href="chartjs2.html">Listar Patologias</a>
                            </li>

                        </ul>
                    </li>
                    <li><a><i class="fa fa-bar-chart-o"></i> Relatórios <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="RelatorioConsulta">Relatório de Consultas</a>
                            </li>
                            <li><a href="RelatorioPaciente">Relatório de Pacientes</a>
                            </li>
                            <li><a href="RelatorioAlimento">Relatório de Alimento</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="menu_section">
                <h3>Mais</h3>
                <ul class="nav side-menu">
                    <li><a>Outras Ações <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="#">Relatórios</a>
                            </li>
                            <li><a href="<%=request.getContextPath()%>/nutricionista/cadastrartiporefeicao.jsp">Cadastrar Tipo De Refeição</a>
                            </li>
                            <li><a href="project_detail.html">Listar Tipos De Refeições</a>
                            </li>
                            <li><a href="contacts.html">Cadastrar Medicamento/Suplemento</a>
                            </li>
                            <li><a href="profile.html">Listar Medicamento/Suplemento</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>

        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>
<!-- top navigation -->
<div class="top_nav">

    <div class="nav_menu">
        <nav class="" role="navigation">
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <% String foto3 = session.getAttribute("foto").toString(); %>
                        <img src="<% if(foto3 == null || foto3.equals("")){ 
                                                            out.print(request.getContextPath()+"/production/images/user.png");
                                                        } else {
                                                            out.print(request.getContextPath()+foto3);
                                                        }%>" height="60px" alt="">
                        <i style="text-transform: capitalize; font-style: normal"><%= session.getAttribute("nome")%></i>
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                        <li><a href="<%= request.getContextPath()%>/CarregarInformacaoNutricionista">  Perfil</a>
                        </li>
                        <li>
                            <a href="javascript:;">
                                <span>Configurações</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;">Ajuda</a>
                        </li>
                        <li><a href="<%= request.getContextPath()%>/LogarUsuario?acao=logout"><i class="fa fa-sign-out pull-right"></i>Sair</a>
                        </li>
                    </ul>
                </li>

            </ul>
        </nav>
    </div>

</div>
<!-- /top navigation -->

