# PROASISTEMAS_TEST

## 1. Base de datos tienda


### Tablas y Procedimientos almacenados
- Producto
    - sp_Producto_insertar

- Compras
    - sp_Compras_registrarCompra

- Ventas
    - sp_Ventas_registrarVenta    



### Para conocer el estado de resultados

- sp_EstadoDeResultado  


## 2. Sherlock String

- Consumo del servicio

`
 GET  'http:\\localhost:port\sherlocksolutions\{s}'
`

***

- La solucion al problema de hackerrank 

/src/main/java/Logic/Sherlock.java
  
```java
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
```

## 3. Non-Divisible-subset

- Consumo del servicio

`
 POST  'http:\\localhost:port\nondivisible'
`
 

```json
// Content-Type: application/json
// Body Request

{
    "k": 3,
    "S" : [1,7,2,4]
}

```

***


- La solucion al problema de hackerrank

/src/main/java/Logic/NonDivisible.java

```java
        public static int nonDivisibleSubset(int k , int[] S){

       // coleccion de residuos de la  division de cada elemento
       // de S por K
       int[] residuos = new int[k];

       // Contador de los numeros no divisibles por K
       int contador = 0;


       /*
       *  Nota : Para cualquier número K, la suma de 2 valores (A y B)
       *  es divisible de manera uniforme por K si la suma de los restos de
       *  A / K + B / K es K.
       *  (También hay un caso especial donde ambos A y B son uniformemente divisible, dando una suma de 0.)
       *
       *  ref: https://www.hackerrank.com/challenges/non-divisible-subset/forum
       *
       *  Obtine el conteo de residuos de cada categoria
       * */
       for (int i = 0; i < S.length; i++) {
           // residuos.add(a - (a / b) * b)
           residuos[S[i]% k]++;
       }


       // También hay un caso especial donde ambos A y B son uniformemente divisible, dando una suma de 0.
       // por lo que en caso de que exista un numero mayor a 0 en el indice 0 de residuos
       // tambien sera contado como uno de los no divisibles
       contador += Math.min(residuos[0], 1);


       // obtener el conteo de cada categoria
       for (int i=1; i< (k/2+1); i++) {

           // si los residuos tienen la misma cantidad en el conteo de la categoria (i.e k/2+1)
           // solo pude ir uno
           if (i != k-i) {
               // de lo contrario se agrega el residuo con el recuento mas alto
               contador += Math.max(residuos[i], residuos[k-i]);
           }
       }

       // Si hubiesen uno o mas numeros divisibles uniformemente
       // solo se puede contar 1
       if (k%2 == 0) {
           contador++;
       }


       return  contador;
       }
```       