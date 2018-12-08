package Logic;

import java.util.*;


public class Sherlock {

    /**
     * <h1> Valida un String </h1>
     * es válida si todos los caraccteres de la cadena aparecen el mismo
     * número de veces.
     * También es válido si puede eliminar solo 1 caracter de un subconjunto
     * de repeticiones de la cadena
     */
    public static String isValid(String s){
        // Crear un diccionario de <clave, valor>
        Map<Integer, Integer> frequencia = new HashMap<>();
        boolean resultado;

        // convertir el string en un array de caracteres unicode y recorrerlo
        for (char c: s.toCharArray()) {
            // obtener el valor unicode que la letra en el indice actual del array
            int key = (int) c;

            // valida si el caracter ya se encuentra en el diccionario como clave
            // suma 1 en el valor del correspondiente caracter (key)
            // agrega un nuevo (key) al diccionario con el correspondiente valor de 1
            frequencia.put(key, frequencia.containsKey(key) ? frequencia.get(key) + 1 : 1);
        }

        // obtener la cantidad de los repetidos
        List<Integer> valores = new ArrayList<>(frequencia.values());

        // ordenar la lista
        Collections.sort(valores);

        /* obtener todos los valores que se repitan el mismo numero de veces
         *tomando como referencia el minimo de veces de repeticion
         */
        long primerValor = valores.stream().filter(x -> x == valores.get(0)).count();

        /* obtener todos los valores que se repitan el mismo numero de veces
         * tomando como referencia el maximo de veces de repeticion
         */
        long ultimoValor = valores.stream().filter(x -> x == valores.get(valores.size()-1)).count();


        /*
         * -Si todos los valores tienen el mismo numero de repetido que el primer valor del arreglo
         *
         * -Si todos los valores menos el ultimo tienen el mismo numero de repetido que el primer valor del arreglo
         *  y si la cantidad de repetidos del ultimo indice del array menos el penultimo indice es igual a uno ,lo
         *  que indicaria que podria ser restado una de las repeticiones del ultimo indice
         *
         * - Si todos los valores en el arraglo concuerdan con el maximo de repeticiones
         * excepto el valor del primer indice que se repite una sola vez
         */
        resultado= primerValor == valores.size() ||
                   primerValor == valores.size() - 1 && valores.get(valores.size()-1) - valores.get(valores.size()-2) == 1 ||
                   ultimoValor == valores.size() - 1 && valores.get(0) == 1;


        return (resultado)?"YES":"NO";
    }


}
