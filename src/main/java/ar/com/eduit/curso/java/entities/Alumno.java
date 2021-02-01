package ar.com.eduit.curso.java.entities;
public class Alumno {
    
    // DAO
    
    // Esta clase refleja la tabla Alumnos de la DB.
    // Los atributos reflejan a los campos de la tabla.
    
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    
    // Foreign Key
    Curso curso;

    // Constructor vacio para APIS y Frameworks
    public Alumno() {
    }

    // Constructor con todo menos ID para INSERTS, ya que el ID se lo pone la DB, no el usuario.
    public Alumno(String nombre, String apellido, int edad, Curso curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.curso = curso;
    }

    // Constructor completo para los SELECT.
    public Alumno(int id, String nombre, String apellido, int edad, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", curso=" + curso + '}';
    }
    
}
