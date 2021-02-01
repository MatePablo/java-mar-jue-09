
package ar.com.eduit.curso.java.repositories.interfaces;

import ar.com.eduit.curso.java.entities.Curso;
import java.util.List;

public interface I_CursoRepository {
    
    // Interfaz en la cual describo lo que quiero hacer con alumno. (Crear, leer, actualizar, remover). (CRUD)
    // La idea es poder implementar esta interfaz en cualquier tecnologia de DB.
    
    // Ej: En SQL esto seria SELECT, INSERT, UPDATE, DELETE, SELECT WHERE etc
    
    // Ingresa un curso y lo guarda.    En SQL: INSERT
    void save(Curso curso);
    
    // Borrar un curso.                 En SQL: DELETE
    void remove(Curso curso);
    
    // Actualizo un curso.              En SQL: UPDATE
    void update(Curso curso);
    
    // Obtengo la lista de cursos (clase 8) | En SQL: SELECT * FROM
    List<Curso> getAll();
    
    // Ingreso un parametro (id), lo va a buscar a la base de datos, y devuelve dicho curso.        En SQL: SELECT WHERE
    Curso getById(int id);
    
    // Ingreso un parametro (titulo) y devuelve la lista de coincidencias.                          En SQL: SELECT WHERE
    List<Curso>getLikeTitulo(String titulo);
}
