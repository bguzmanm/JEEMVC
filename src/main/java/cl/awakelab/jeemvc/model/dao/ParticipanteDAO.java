package cl.awakelab.jeemvc.model.dao;

import cl.awakelab.jeemvc.model.Conexion;
import cl.awakelab.jeemvc.model.Participante;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAO implements IParticipanteDAO{
    @Override
    public void crearParticipante(Participante p) {

        int aprueba = p.isAprobado() ? 1 : 0;
        String sql = "insert into participantes (rut, nombre, apellido, edad, email, aprobado, urlimg) " +
                "values ('" + p.getRut()+ "', '" + p.getNombre() +"', '" + p.getApellido() + "', " + p.getEdad() +
                ", '" + p.getEmail() +"', " + aprueba + ", '" + p.getUrlImg() + "')";
        try{
            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();
            cn.setAutoCommit(true);

            s.execute(sql);
            s.close();
        } catch (SQLException e){
            System.out.println("ERROR AL HACER INSERT");
            e.printStackTrace();
        }
    }

    @Override
    public List<Participante> readAll() {

        List<Participante> lista = new ArrayList<Participante>();

        try {

            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();
            String sql = "select rut, nombre, apellido, edad, email, aprobado, urlimg from participantes";

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()){
                lista.add(new Participante(rs.getString("rut"), rs.getString("nombre"),
                        rs.getString("apellido"), rs.getInt("edad"), rs.getString("email"),
                        rs.getBoolean("aprobado"), rs.getString("urlimg")));

            }

        } catch (SQLException e){
            System.out.println("Error de SQLException");
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public Participante readOne(String rut) {
        Participante p = null;
        String sql = "select rut, nombre, apellido, edad, email, aprobado, urlimg from participantes " +
                "where rut = '" + rut + "'";

        try {
            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();

            ResultSet rs = s.executeQuery(sql);
            rs.next();
            p = new Participante(rs.getString("rut"), rs.getString("nombre"),
                    rs.getString("apellido"), rs.getInt("edad"), rs.getString("email"),
                    rs.getBoolean("aprobado"), rs.getString("urlimg"));
        } catch (SQLException e){
            System.out.println("ERROR EN readOne");
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public void actualizarParticipante(Participante p) {

        System.out.println(p.getNombre() + " está aprobado? :" + p.isAprobado());
        int aprueba = p.isAprobado() ? 1 : 0;

        String sql = "update  participantes set nombre = '" + p.getNombre() +
                    "', apellido = '"+ p.getApellido() + "', edad = "+p.getEdad() + ", email = '"+ p.getEmail() +
                    "', aprobado = " + aprueba + ", urlimg = '" + p.getUrlImg() + "'  where   rut = '"+ p.getRut() + "'";

        System.out.println(sql);

        try {

            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();
            cn.setAutoCommit(true);
            s.executeQuery(sql);

            s.close();


        } catch (SQLException e){
            System.out.println("ERROR en actualizaParticipante");
            e.printStackTrace();
        }
    }

    @Override
    public void borrarParticipante(Participante p) {
        borrarParticipante(p.getRut());
    }

    @Override
    public void borrarParticipante(String rut) {
        String sql = "delete from participantes where rut = '" + rut + "'";
        try{

            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();
            cn.setAutoCommit(true);
            s.execute(sql);
            s.close();

        } catch (Exception e){
            System.out.println("ERROR AL BORRAR PARTICIPANTE");
            e.printStackTrace();
        }
    }
}
