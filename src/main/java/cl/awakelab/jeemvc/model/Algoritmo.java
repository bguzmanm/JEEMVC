package cl.awakelab.jeemvc.model;

public class Algoritmo {

    /***
     * Calcula el % de aprobación del curso
     * @param c curso que se desea evaluar
     * @return % de aprobación del curso.
     */
    public double calculaExitoCurso(Curso c){
        int cantidadAprobados=0;

        for (Participante p: c.getParticipantes()) {
            if (p.isAprobado()){
                cantidadAprobados++;
            }
        }
        System.out.println("Cantidad Estudiantes: " + c.getParticipantes().size());
        System.out.println("Cantidad Aprobados: " + cantidadAprobados);
        double exito = (double)cantidadAprobados / (double)c.getParticipantes().size();
        System.out.println("% de Exito: " + exito);
        return (exito);
    }
}
