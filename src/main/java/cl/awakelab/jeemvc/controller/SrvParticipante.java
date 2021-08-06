package cl.awakelab.jeemvc.controller;

import cl.awakelab.jeemvc.model.Participante;
import cl.awakelab.jeemvc.model.SimulaAccesoDatos;
import cl.awakelab.jeemvc.model.dao.ParticipanteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "srvParticipante", value = "/srvParticipante")
public class SrvParticipante extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //SimulaAccesoDatos sac = new SimulaAccesoDatos();

        //leo un rut que viene como parámetro en el request.
        String rut = request.getParameter("rut");
        //Participante p = sac.buscarParticipante(rut);

        ParticipanteDAO pDAO = new ParticipanteDAO();
        Participante p = pDAO.readOne(rut);

        String resultado = request.getParameter("result");
        request.setAttribute("p", p);
        if (resultado.equals("ver")){
            getServletContext().getRequestDispatcher("/view/participante.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/view/editarParticipante.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Participante p = new Participante();


        p.setRut(request.getParameter("rut"));
        p.setNombre(request.getParameter("nombre"));
        p.setApellido(request.getParameter("apellido"));
        p.setEdad(Integer.parseInt(request.getParameter("edad")));
        p.setEmail(request.getParameter("email"));

        boolean aprobado = false;
        if (request.getParameter("aprobado") !=  null){
            aprobado = true;
        }
        p.setAprobado(aprobado);

        p.setUrlImg(request.getParameter("urlimg"));


        System.out.println(p.toString());

        ParticipanteDAO pDAO = new ParticipanteDAO();
        pDAO.actualizarParticipante(p);

        getServletContext().getRequestDispatcher("/srvCurso").forward(request, response);

    }
}
