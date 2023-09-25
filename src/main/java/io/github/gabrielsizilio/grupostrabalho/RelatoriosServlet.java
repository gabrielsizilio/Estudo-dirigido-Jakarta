/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package io.github.gabrielsizilio.grupostrabalho;

import io.github.guisso.hellofirstjakartaee8.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author gabriel
 */
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios"})
@Transactional
public class RelatoriosServlet extends HttpServlet {
    
    @Inject PessoaSessionBeanLocal entityManager;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PessoaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Olá, </h1>");
                
            //<editor-fold defaultstate="collapsed" desc="1">
            
            out.println("<h2>01.a) Quais as pessoas (dados completos) cadastradas por meio de Query?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoaQuery())
                    +"</pre>");
            
            out.println("<h2>01.b) Quais as pessoas (dados completos) cadastradas por meio de TypedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoaTyedQuery())
                    +"</pre>");
            
            out.println("<h2>01.c) Quais as pessoas (dados completos) cadastradas por meio de NamedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoaNamedQuery())
                    +"</pre>");
//</editor-fold>
    
            //<editor-fold defaultstate="collapsed" desc="2">

            out.println("<h2>02.a) Quais os nomes das pessoas por meio de Query?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesQuery())
                    +"</pre>");
            
            out.println("<h2>02.b) Quais os nomes das pessoas por meio de TypedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesTypedQuery())
                    +"</pre>");
            
            out.println("<h2>02.c) Quais os nomes das pessoas por meio de NamedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesNamedQuery())
                    +"</pre>");
            
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="3">

            out.println("<h2>03.a) Quais as pessoas (nome) e seus respectivos endereços (dados completos) por meio de Query?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesEnderecosQuery())
                    +"</pre>");

            out.println("<h2>03.b) Quais as pessoas (nome) e seus respectivos endereços (dados completos) por meio de TypedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesEnderecosTypedQuery())
                    +"</pre>");

            out.println("<h2>03.c) Quais as pessoas (nome) e seus respectivos endereços (dados completos) por meio de NamedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesEnderecosNamedQuery())
                    +"</pre>");
            
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="4">
            
            out.println("<h2>04.a)Quais pessoas (dados completos) moram em avenidas por meio de Query</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasAvenidaQuery())
                    +"</pre>");

            out.println("<h2>04.a)Quais pessoas (dados completos) moram em avenidas por meio de TypedQuery</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasAvenidaTypedQuery())
                    +"</pre>");

            out.println("<h2>04.a)Quais pessoas (dados completos) moram em avenidas por meio de NamedQuery</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasAvenidaNamedQuery())
                    +"</pre>");

            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="5">

            out.println("<h2>05.a) Quais pessoas (dados completos) não moram em praças por meio de Query?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasNaoPracaQuery())
                    +"</pre>");

            out.println("<h2>05.b) Quais pessoas (dados completos) não moram em praças por meio de TypedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasNaoPracaTypedQuery())
                    +"</pre>");

            out.println("<h2>05.c) Quais pessoas (dados completos) não moram em praças por meio de NamedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasNaoPracaNamedQuery())
                    +"</pre>");
            
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="6">

            out.println("<h2>06.a) Quais os nomes das pessoas e seus respectivos telefones (dados completos) por meio de Query?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesTelefonesQuery())
                    +"</pre>");

            out.println("<h2>06.b) Quais os nomes das pessoas e seus respectivos telefones (dados completos) por meio de TypedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesTelefonesTypedQuery())
                    +"</pre>");

            out.println("<h2>06.b) Quais os nomes das pessoas e seus respectivos telefones (dados completos) por meio de NamedQuery?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesTelefonesNamedQuery())
                    +"</pre>");
            
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="7">

            out.println("<h2>07. Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasNascimentoBetween(LocalDate.of(2001, 4, 1), LocalDate.of(2004, 4, 30)))
                    +"</pre>");
            
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="8">

            out.println("<h2>8. Quais pessoas (dados completos) têm telefone do estado do Paraná?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasPorDDD((byte)44))
                    +"</pre>");
            out.println("<h2>8. E do Rio de Janeiro?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasPorDDD((byte)22))
                    +"</pre>");
            
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="9">

            out.println("<h2>9. Quais pessoas (dados completos) não possuem telefone?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllPessoasSemTelefone())
                    +"</pre>");
            
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="10">

            out.println("<h2>10. Quantos telefones cada pessoa (nome) tem?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.countTelefonesPorPessoa())
                    +"</pre>");
            
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="11">

            out.println("<h2>11. Quais grupos (dados completos) não estão ativos?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllGruposAtivos())
                    +"</pre>");
            
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="12">

            out.println("<h2>12. Quais são os líderes (nomes) dos grupos (nomes)?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllLideresGrupos())
                    +"</pre>");
            
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="13">

            out.println("<h2>13. Quais são os membros (nomes) do grupo com nome “Estudo IV” com ordenação alfabética inversa?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllNomesMembrosGruopo("Estudo VI"))
                    +"</pre>");
            
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="14">

            out.println("<h2>14. Quais são os grupos (dados completos) liderados por “Beatriz Yana”?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllGruposByLider("Beatriz Yana"))
                    +"</pre>");
            
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="15">

            out.println("<h2>15. Quais são as datas de início e de término da atuação e os grupos (nomes) nos quais “Cecília Xerxes” é membro?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllAtuacoesGruposNomes("Cecília Xerxes"))
                    +"</pre>");
            
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="16">

            out.println("<h2>16. Quais são os grupos (dados completos) que contêm “II” em seus nomes?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllGruposNameLike("II"))
                    +"</pre>");
            
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="17">

            out.println("<h2>17. Quais são os grupos (nomes) e os respectivos totais de membros distintos já alocados?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllGruposNomesMembrosCount())
                    +"</pre>");
            
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="18">

            out.println("<h2>18. Quais grupos (nomes) têm 3 ou mais atuações de membros e quanto são esses totais de atuações?</h2>");
            out.println("<pre class=\"high\">"+
                    Util.toJson(entityManager.findAllGruposCountAtuacao(3))
                    +"</pre>");
            
            //</editor-fold>

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
