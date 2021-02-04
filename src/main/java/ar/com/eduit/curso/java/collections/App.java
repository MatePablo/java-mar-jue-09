package ar.com.eduit.curso.java.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        
        
        // ¡¡ Ver imagen en .doc !!       
        
        
        //              Vector - Array
        //  La longitud de los Array es estatica.
        Auto[] autos = new Auto[4];
        
        autos[0]=new Auto("Toyota", "TT", "Negro");
        autos[1]=new Auto("Reno", "Megan", "Blanco");
        autos[2]=new Auto("Fiat", "600", "Naranja");
        autos[3]=new Auto("Peugeot", "Clio", "Amarillo");

        
        System.out.println("\tRecorrido por indices");
        //  Recorrido antiguo por indices
        for (int i=0; i<autos.length; i++){
                System.out.println(autos[i]);
        }
        
        System.out.println("\n\tEstructura forEach");
        //  Estructura forEach (No existe como palabra clave, el mismo for actua como esta estructura)
        
        for(Auto i:autos){
            System.out.println(i);
        }       
        
        // +++ Framework "Collections" +++
        
        //  --- Interface "List" ---
        //  > La longitud de las List es dinamica. (A medida que agrego elementos se reserva espacio en memoria)
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
        
        //recorrido forEach                     (NO RECOMENDADO)
        System.out.println("\n\tRecorrido forEach");
        
        for(Object o: lista1){
            System.out.println(o);
        }
        
        //Metodo default .forEach()             (RECOMENDADO)
        //  lista.forEach( objeto -> { acciones } )
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
        
        lista1.forEach((t) -> {
            if(t instanceof Auto) 
                lista2.add( (Auto) t );
        });
        
        System.out.println("\n\tRecorriendo lista2 luego de copiar datos de lista1");
        
        lista2.forEach(System.out::println);
        
        
        
    }
}
