package cl.awakelab.jeemvc.model.dao;

import cl.awakelab.jeemvc.model.Participante;

import java.util.List;

public interface IParticipanteDAO {

    public void crearParticipante(Participante p);
    public List<Participante> readAll();
    public Participante readOne(String rut);
    public void actualizarParticipante(Participante p);
    public void borrarParticipante(Participante p);
    public void borrarParticipante(String rut);
}
