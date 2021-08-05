package cl.awakelab.jeemvc.model;

import java.util.ArrayList;
import java.util.List;

public class SimulaAccesoDatos {

    public Curso llenaCurso(){
        Curso c = new Curso();
        c.setCodigo("156-2");

        List<Participante> lista = new ArrayList<Participante>();

        lista.add(new Participante("1-1", "Eliseo", "Ávila", 39, "eliseo@gmail.com", true, "/view/img/eliseo.png"));
        lista.add(new Participante("2-2", "Gabriel", "Recabarren", 39, "gabriel@gmail.com", true, "/view/img/gabriel.png"));
        lista.add(new Participante("3-3", "Alejandra", "Vejar", 39, "alejandra@gmail.com", true));
        lista.add(new Participante("4-4", "Juanito", "Monsalve", 39, "juanito@gmail.com", false));
        lista.add(new Participante("5-5", "Felipe", "Kessi", 39, "felipe@gmail.com", true));
        lista.add(new Participante("6-6", "Ronald", "Figueroa", 39, "ronald@gmail.com", true));
        lista.add(new Participante("7-7", "Cristian", "Urra", 39, "cristian@gmail.com", true));
        lista.add(new Participante("8-8", "Natalia", "Aldana", 39, "naty@gmail.com", true));
        lista.add(new Participante("9-9", "Daniel", "Navarrete", 39, "daniel@gmail.com", true, "/view/img/daniel.png"));

        c.setParticipantes(lista);

        return c;
    }

    /***
     * Busca un participante en la lista de participantes del curso
     * @param rut rut que buscará
     * @return el participante identificado por el rut. Si no lo encuentra, returna null
     */
    public Participante buscarParticipante(String rut){
        Curso c = llenaCurso();
        Participante esteEs = null;

        for (Participante p: c.getParticipantes()) {
            if (p.getRut().equals(rut)){
                esteEs = p;
            }
        }

        return esteEs;
    }
}
