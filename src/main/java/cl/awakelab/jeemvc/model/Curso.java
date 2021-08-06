package cl.awakelab.jeemvc.model;

import java.util.List;

public class Curso {

    private String codigo;
    private List<Participante> participantes;

    public Curso() {
    }

    public Curso(String codigo, List<Participante> participantes) {
        this.codigo = codigo;

        this.participantes = participantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
