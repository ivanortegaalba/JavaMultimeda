package aplicacionaula;


public class AplicacionAula {

    public static void main(String[] args) {
        Profesor jesus,joaquin;
        Alumno juan,beatriz;
        Persona per;
        Delegado [] vectorDel;

        jesus   = new Profesor("Jesus");
        joaquin = new Profesor("Joaquin","B7"); 
        juan  = new Alumno("Juan");
        beatriz = new Alumno("Beatriz",4,5);
        per = new Persona();
        vectorDel = new Delegado[10];
        for (int i = 0; i < 10; i++){
            vectorDel[i] = new Delegado("Delegado"+i);
        }
        per.altura=3.3F;
        System.out.println("\n"+jesus.toString());   // Mostramos a los profesores
        System.out.println(joaquin.toString());
        jesus.setDespacho("C7");                     // Cambiamos el despacho de Jesus
        System.out.println(jesus.toString()+"\n");   // Comprobamos la nueva informacion
        
        jesus.darClase();                               // Jesus comineza la clase
        jesus.habla();
        juan.pregunta("¿Que es un objeto?");             // El alumno juan pregunta
        jesus.responderPregunta("¿Que es un objeto?");   // Jesus contesta
        beatriz.pregunta("¿Es lo mismo clase y objeto?");
        jesus.responderPregunta("¿Es lo mismo clase y objeto?");
        jesus.pregunta("¿Os habeis enterado?");
        
    
        for (int i = 0; i < 10; i++){
            vectorDel[i].pregunta(vectorDel[i].Mandar());
        }
        
        System.out.println(juan.numAsignaturas);//protected numAsignaturas
        jesus.cambiaAsig(juan); //Pueden cambiarlo en paquete.
        System.out.println(juan.numAsignaturas);
        System.out.println(Persona.ndedos);//ndedos al ser static hemos de acceder desde clase
        Persona.ndedos=21;
        System.out.println(Alumno.ndedos);//Se cambia en todas las calses heredadas
        
        //PRUEBAS CON JAVA.LANG
        //Los métodos se encuentra dentro de las clases Integer, Float, Boolean, etc.
        
        //Calcular el valor absoluto y la raiz cuadrada usando Math
        Float num = new Float(3.7);
        System.out.println(Math.abs(num));
        System.out.println(Math.sqrt(Math.abs(num)));
        
        //Comprobar si un caracter es minuscula
        Character car = new Character('a');
        if(Character.isUpperCase(car)) 
            System.out.println("Es mayuscula");
        else 
            System.out.println("Es minuscula");
        
        //Pasar de entero a String y viceversa.
        Integer entero = new Integer(5);
        System.out.println("Entero: "+entero);
        String cadena5 = new String("");
        cadena5 = entero.toString();
        System.out.println("String: "+cadena5);
        entero = Integer.parseInt(cadena5);
        System.out.println("String pasado a entero: "+entero);
        
        //Pasar numero de coma flotante a String
        Double numd = 5.5;
        System.out.println(numd.toString());
        
        //Máximo valor coma flotante
        System.out.println("Maximo coma flotante:"+Float.MAX_VALUE);
        
        //Imprimir segundo caracter de hola
        String stHola = new String("Hola");
        System.out.println("Segundo caracter de \"Hola\": "+stHola.charAt(1));
        
        //Comparacion de hola y Hola.
        String stHolaMin = new String(stHola.toLowerCase());
        System.out.println("Comparacion de Hola y hola: "+stHola.compareTo(stHolaMin));
        
        //Crear hola y añadir adios.
        stHolaMin=stHolaMin.concat("Adiós");
        System.out.println(stHolaMin);
    }
    
}
