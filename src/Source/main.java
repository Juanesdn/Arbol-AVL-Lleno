package Source;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int op = 3;
        ArrayList<Integer> v = new ArrayList<>();
        ArbolAVL arbol = new ArbolAVL();
        Nodo raiz = null;
        Scanner scan = new Scanner(System.in);


        while(op != 0){
            System.out.println("====================================================");
            System.out.println("Digite el número de la opción deseada:");
            System.out.println("1. generar un arbolAVL y validar si es lleno");
            System.out.println("2. ingresar un arbolAVL y validar si es lleno");
            System.out.println("0. Salir del programa");
            System.out.println("====================================================");
            op = scan.nextInt();

            switch (op){
                case 1:
                    int n = (int) (Math.random()*(10-1) + 1);

                    for (int i = 0; i < n; i++) {
                        v.add((int) (Math.random()*100));
                    }

                    System.out.println("Vector generado" + v);

                    for (int i = 0; i < n ; i++) {
                        raiz = arbol.insertar(raiz, v.get(i));
                    }

                    System.out.println("Arbol generado (recorrido inOrden): ");
                    arbol.InOrden(raiz);
                    System.out.println("");

                    if(arbol.esEstricto(raiz)){
                        System.out.println("El arbol es Lleno");
                    }else {
                        System.out.println("El arbol no es Lleno");
                    }
                    v.clear();
                    raiz = null;
                    break;

                case 2:
                    System.out.println("====================================================");
                    System.out.println("Los nodos ingresados seran ordenados en un arbolAVL");
                    System.out.println("====================================================");
                    System.out.println("Digite la cantidad de nodos del arbol: ");
                    n = scan.nextInt();

                    for (int i = 0; i < n ; i++) {
                        System.out.println("Nodo " + (i+1) );
                        v.add(scan.nextInt());
                    }

                    System.out.println("Vector" + v);

                    for (int i = 0; i < n ; i++) {
                        raiz = arbol.insertar(raiz, v.get(i));
                    }

                    System.out.println("Arbol ordenado (recorrido inOrden): ");
                    arbol.InOrden(raiz);
                    System.out.println("");


                    if(arbol.esLleno(raiz)){
                        System.out.println("El arbol es Lleno");
                    }else {
                        System.out.println("El arbol no es Lleno");
                    }

                    v.clear();
                    raiz = null;
                    break;
            }

        }

    }
}
