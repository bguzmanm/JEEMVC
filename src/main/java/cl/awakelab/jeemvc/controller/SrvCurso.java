package cl.awakelab.jeemvc.controller;

import cl.awakelab.jeemvc.model.Algoritmo;
import cl.awakelab.jeemvc.model.Conexion;
import cl.awakelab.jeemvc.model.Curso;
import cl.awakelab.jeemvc.model.SimulaAccesoDatos;
import cl.awakelab.jeemvc.model.dao.ParticipanteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "srvCurso", value = "/srvCurso")
public class SrvCurso extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //creo objeto que simula el acceso a la base de datos, y obtengo los datos del curso.
        //SimulaAccesoDatos sac = new SimulaAccesoDatos();
        //Curso c = sac.llenaCurso();

        ParticipanteDAO pDAO = new ParticipanteDAO();
        Curso c = new Curso();
        c.setCodigo("0156-2");
        c.setParticipantes(pDAO.readAll());

        //creo objeto que calcula el % de éxito del curso
        Algoritmo agm = new Algoritmo();
        //calculo % de aprobación
        double aprobacion = agm.calculaExitoCurso(c);

        //paso atributos a la vista.
        request.setAttribute("codigoCurso", c.getCodigo());
        request.setAttribute("participantes", c.getParticipantes());
        request.setAttribute("aprobacion", aprobacion);

        //llamo a la vista
        getServletContext().getRequestDispatcher("/view/listaCurso.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
