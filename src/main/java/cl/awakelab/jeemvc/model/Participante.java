package cl.awakelab.jeemvc.model;

public class Participante {
    private String rut;
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private boolean aprobado;
    private String urlImg;

    public Participante() {
    }

    public Participante(String rut, String nombre, String apellido, int edad, String email, boolean aprobado) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.aprobado = aprobado;
    }

    public Participante(String rut, String nombre, String apellido, int edad, String email, boolean aprobado, String urlImg) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.aprobado = aprobado;
        this.urlImg = urlImg;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }


    @Override
    public String toString() {
        return "Participante{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", aprobado=" + aprobado +
                ", urlImg='" + urlImg + '\'' +
                '}';
    }
}
