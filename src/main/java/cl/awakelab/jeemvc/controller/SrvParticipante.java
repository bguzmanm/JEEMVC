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

        //obtengo parámetro que me indica que resultado se espera (ver, editar, crear)
        String resultado = request.getParameter("result");

        if (resultado.equals("ver") || resultado.equals("edit")){
            //leo un rut que viene como parámetro en el request.
            String rut = request.getParameter("rut");
            //Participante p = sac.buscarParticipante(rut);

            ParticipanteDAO pDAO = new ParticipanteDAO();
            Participante p = pDAO.readOne(rut);

            request.setAttribute("p", p);
        }

        switch (resultado){
            case "edit":
                request.setAttribute("accion", "editar");
                getServletContext().getRequestDispatcher("/view/editarParticipante.jsp").forward(request, response);
                break;
            case "crear":
                request.setAttribute("accion", "crear");
                getServletContext().getRequestDispatcher("/view/editarParticipante.jsp").forward(request, response);
                break;
            case "del":
                String rut = request.getParameter("rut");
                ParticipanteDAO pDAO = new ParticipanteDAO();
                pDAO.borrarParticipante(rut);
                getServletContext().getRequestDispatcher("/srvCurso").forward(request, response);

                break;
            default:
                getServletContext().getRequestDispatcher("/view/participante.jsp").forward(request, response);
                break;

        }

      /*  if (resultado.equals("ver")){

        } else {
            if (resultado.equals("edit")) {
                request.setAttribute("accion", "editar");
                getServletContext().getRequestDispatcher("/view/editarParticipante.jsp").forward(request, response);
            } else {
                request.setAttribute("accion", "crear");
                getServletContext().getRequestDispatcher("/view/editarParticipante.jsp").forward(request, response);
            }

        }*/
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

        String accion = request.getParameter("accion");

        ParticipanteDAO pDAO = new ParticipanteDAO();

        if (accion.equals("editar")) {
            pDAO.actualizarParticipante(p);
        } else {
            pDAO.crearParticipante(p);
        }

        getServletContext().getRequestDispatcher("/srvCurso").forward(request, response);

    }
}
