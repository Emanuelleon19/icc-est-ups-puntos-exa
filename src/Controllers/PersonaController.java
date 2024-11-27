package Controllers;

import Models.Persona;

/**
 * Controlador para manejar la lógica de operaciones sobre arrays de Carross.
 * 
 * 
 * Generar los metdoos necesarions para ordenar un array de personas por edad en
 * orden descendente
 * y para la busqueda binaria de una persona por edad.
 * 
 */
public class PersonaController {

    public void sortByAgeWithSelection(Persona[] personas) {
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(personas[j].getEdad() < personas[minIndex].getEdad()){
                    minIndex = j;
                }
            }
            Persona temp = personas[i];
            personas[i] = personas[minIndex];
            personas[minIndex] = temp;
        }
    }
    

    public void sortByNameWithInsertion(Persona[] personas) {
        int n = personas.length;
        for (int i = 1; i < n; i++) {
            Persona key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getNombre().compareTo(key.getNombre()) > 0) {
                personas[j + 1] = personas[j];
                j = j - 1;
            }
            personas[j + 1] = key;
        }

    }

    public int searchBinaryByAge(Persona[] personas, int edad) {
        int left = 0;
        int right = personas.length - 1;
        while (left <= right) {
            int mitad = left + (right - left) / 2;
            if (personas[mitad].getEdad() == edad) {
                return mitad; 
            }
            if (personas[mitad].getEdad() > edad) {
                right = mitad - 1; 
            } else {
                left = mitad + 1; 
            }
        }
        return -1; 
    }
    
    

    public int searchBinaryByName(Persona[] personas, String nombre) {
        int left = 0;
        int right = personas.length - 1;

        while (left <= right) {
            int mitad = left + (right - left) / 2;
            int comparacion = personas[mitad].getNombre().compareToIgnoreCase(nombre);

            if (comparacion == 0) {
                return mitad;
            } else if (comparacion < 0) {
                left = mitad + 1;
            } else{
                right = mitad -1;
            }
        }
        return -1; 
    }


}
