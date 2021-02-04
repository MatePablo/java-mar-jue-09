package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {
        
        
        // ¡¡ Ver imagen en .doc !!       
        
        
        //  Vector - Array
        //  > La longitud de los Array es estatica.
        Auto[] autos = new Auto[4];
        
        autos[0]=new Auto("Toyota", "TT", "Negro");
        autos[1]=new Auto("Reno", "Megan", "Blanco");
        autos[2]=new Auto("Fiat", "600", "Naranja");
        autos[3]=new Auto("Peugeot", "Clio", "Amarillo");

        
        //  - Recorrido antiguo por indices -
        System.out.println("\tRecorrido por indices");
        
        for (int i=0; i<autos.length; i++){
                System.out.println(autos[i]);
        }
        
        // - Estructura forEach -
        // > (No existe como palabra clave, el mismo for actua como esta estructura)
        System.out.println("\n\tEstructura forEach");
        
        for(Auto i:autos){
            System.out.println(i);
        }       
        
        
        // +++ Framework "Collections" +++

        //  -- Interface "List" --
        /*
            > Representa una lista tipo vector con indices
            > La longitud de las List es dinamica. (A medida que agrego elementos se reserva espacio en memoria)
        */ 
        
        List lista1;
        
        lista1 = new ArrayList();       //Object
        //lista1 = new LinkedList();
        
        //  >> Metodo .add()
        lista1.add(new Auto("Chevrolet", "Corsa", "Rosado"));       //Indice 0
        lista1.add(new Auto("VW", "UP", "Blanco"));                 //Indice 1
        lista1.add("Hola jorge");                                   //Indice 3
        lista1.add(26);                                             //Indice 4
        
        // Añado el elemento en el indice 2
        lista1.add(2,"Lunes");                                      //Indice 2        
        // Este metodo al ser un metodo con indices, pertenece a la interface List en lugar de Collection.
        
        //  >> Metodo .remove()
        lista1.remove("hola");
        
        // Copiar los autos del vector autos a lista1
        for (Auto i:autos) {
            lista1.add(i);
        }
        
        // Recorriendo List con indices         (NO RECOMENDADO)
        System.out.println("\n\tRecorrido de la lista con indices:");
        for (int i = 0; i < lista1.size(); i++) {
            System.out.println(lista1.get(i));
        }
        
        // Recorrido forEach                     (NO RECOMENDADO)
        System.out.println("\n\tRecorrido forEach");
        
        for(Object o: lista1){
            System.out.println(o);
        }
        
        // Metodo default .forEach()             (RECOMENDADO)
        // >> lista.forEach( objeto -> { acciones } )
        System.out.println("\n\tRecorrido DEFAULT .forEach()");
        
        lista1.forEach(o -> { System.out.println(o); });
        
        // RECORRIDO IMPLICITO
        System.out.println("\n\tRecorrido DEFAULT .forEach() IMPLICITO");
        
        lista1.forEach( System.out::println );
        
        
        
        // Uso de Generics <>   (Lo que va dentro del <> indica el tipo de dato), puede ser int, String, double, objetos de un tipo, etc
        
        List<Auto> lista2 = new ArrayList();    // Lista de tipo autos (Solo puedo agregar objetos autos)
        
        lista2.add(new Auto("Chevrolet", "Hecho mierda", "Bordo"));
        lista2.add(new Auto("Fiat", "En buen estado", "Gris"));
        
        
        // La lista1 es de tipo object, por lo que tengo que castear para poder guardar el elemento de la lista en un objeto auto.
        // La lista2 es de tipo generico Auto, por lo que el IDE sabe que es un auto y no tengo que castearlo.
        Auto auto1 = (Auto) lista1.get(0);
        Auto auto2 = lista2.get(1) ;
        
        
        // Copiar autos de lista1 a lista2
        
        /* METODO 1 */
        
        lista1.forEach((t) -> {
            if(t instanceof Auto) 
                lista2.add( (Auto) t );
        });
        
        
        
        /* METODO 2
        
        for(Object o:lista1){
            if(o instanceof Auto) 
                lista2.add((Auto) o);
        }
        
        */
        
        System.out.println("\n\tRecorriendo lista2 luego de copiar datos de lista1");
        
        lista2.forEach(System.out::println);
        
        
        // --- Interface Set ---
        /*
            > Representa una lista sin indices. (El mismo objeto almacenado es el indice, lo cual implica que no puede haber objetos duplicados).
        */ 
                                                            
        Set<String> interfaceSet;
        
        // - Implementacion HashSet -
        /* 
            >> Almacena y recupera elementos de la forma mas veloz posible. 
            >> No garantiza ningun orden en los elementos.
        */ 
        
        System.out.println("\n\tImplementacion HashSet");
        
        interfaceSet = new HashSet();
        
        interfaceSet.add("Lunes");
        interfaceSet.add("Lunes");
        
        interfaceSet.add("Martes");
        interfaceSet.add("Miercoles");
        interfaceSet.add("Jueves");
        interfaceSet.add("Viernes");        
        
        interfaceSet.forEach(System.out::println);
        
        // - Implementacion LinkedHashSet -
        /*
            >> Almacena los elementos en una lista enlazada POR ORDEN DE INGRESO.
            >> No es tan rapido como HashSet.
        */
        
        System.out.println("\n\t Implementacion LinkedHashSet");
        
        interfaceSet = new LinkedHashSet();
        
        interfaceSet.add("Lunes");
        interfaceSet.add("Lunes");
        
        interfaceSet.add("Martes");
        interfaceSet.add("Miercoles");
        interfaceSet.add("Jueves");
        interfaceSet.add("Viernes");        
        
        interfaceSet.forEach(System.out::println);
        
        // - Implementacion TreeSet:
        /*
            >> Almacena en un arbol por orden natural (por orden alfabetico)
        */
        
        System.out.println("\n\t Implementacion TreeSet");
        
        interfaceSet = new TreeSet();
        
        interfaceSet.add("a");
        interfaceSet.add("a");
        
        interfaceSet.add("d");
        interfaceSet.add("c");
        interfaceSet.add("e");
        interfaceSet.add("b");        
        
        interfaceSet.forEach(System.out::println);
        
        /* Otros usos para el "::" */
        
        // lista2.forEach( a -> lista1.add(a) );
        lista2.forEach(lista1::add);
        
        
        Set<Auto> setAutos;
        
        setAutos = new HashSet();
        
        // Metodo addAll añade todos los items de una lista a otra, considerando que ambas listas permitan los mismos tipos de items.
        
        System.out.println("\n\tSetAutos HashSet");
        
        setAutos.addAll(lista2);
        setAutos.add(new Auto("Sony", "Vegas", "Naranjita"));
        
        setAutos.forEach(System.out::println);
    }
}
