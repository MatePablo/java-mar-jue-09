
package ar.com.eduit.curso.java.repositories.interfaces;

import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import java.util.List;

public interface I_AlumnoRepository {
    
    //  Leer interfaz de Curso para explicacion mas detallada.
    
    void save(Alumno alumno);       //  INSERT
    void remove(Alumno alumno);     //  DELETE
    void update(Alumno alumno);     //  UPDATE
    
    List<Alumno> getAll();          // SELECT *
    Alumno getById(int id);         // SELECT WHERE
    Alumno getLikeApellido(String apellido);
    Alumno getLikeCurso(Curso curso);
}
