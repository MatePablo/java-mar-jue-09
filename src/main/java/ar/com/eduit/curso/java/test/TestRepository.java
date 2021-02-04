package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.connectors.Connector;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enums.Dia;
import ar.com.eduit.curso.java.enums.Turno;
import ar.com.eduit.curso.java.repositories.interfaces.I_AlumnoRepository;
import ar.com.eduit.curso.java.repositories.interfaces.I_CursoRepository;
import ar.com.eduit.curso.java.repositories.jdbc.AlumnoRepository;
import ar.com.eduit.curso.java.repositories.jdbc.CursoRepository;
import java.util.List;


public class TestRepository {
    public static void main(String[] args) {
        I_CursoRepository cr = new CursoRepository(Connector.getConnection());
        
        Curso curso = new Curso("HTML", "Ramirez", Dia.VIERNES, Turno.TARDE);
        
        cr.save(curso);
        
        System.out.println(curso);
        
        /*
        List<Curso> list = cr.getAll();
        
        // Recorrido por indices
        
        for(int a=0; a<list.size(); a++){
            System.out.println(list.get(a));
        }        
        */
        
        
        // Recorrrido con .forEach() IMPLICITO
        cr.getAll().forEach( System.out::println );
        
        
        System.out.println("***BUSQUEDA POR ID***");
        
        curso = cr.getById(2);
        System.out.println(curso);
        
        System.out.println("********************");
        
        cr.remove(cr.getById(3));
        
        System.out.println("*********************");
        
        curso = cr.getById(5);
        
        curso.setProfesor("Segovia");
        curso.setDia(Dia.LUNES);
        curso.setTurno(Turno.NOCHE);
        cr.update(curso);
        
        System.out.println("******BUSQUEDA POR TITULO*****");
        
        /*
        list = cr.getLikeTitulo("ja");
        
        for(int a=0; a<list.size(); a++){
            System.out.println(list.get(a));
        } 
        */
        
        cr.getLikeTitulo("ja").forEach( System.out::println );
        
        System.out.println("*********************");
        
        I_AlumnoRepository ar = new AlumnoRepository(Connector.getConnection());
        
        Alumno alumno = new Alumno("Jorge", "Altamirano", 29, 1);
        
        ar.save(alumno);
        
        System.out.println(alumno);
    }
}
