package Logic;

public class NonDivisible {

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

}
