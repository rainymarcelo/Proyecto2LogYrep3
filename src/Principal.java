import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;

public class Principal {
    public static void main(String[] args) {
        /*  MARCELO DE LA HOZ SIERRA CC 1037669479
         */

        int kLG, kA, kAB, kABB,kLP;
        ListaGeneralizada[] listaLG = new ListaGeneralizada[100];
        kLG = 1;
        Arbol[] listaArbol = new Arbol[100];
        kA = 1;
        ArbolBinario[] listaArbolBinario = new ArbolBinario[100];
        kAB = 1;
        ArbolBinario[] listaABB = new ArbolBinario[100];
        kABB = 1;
        ArbolBinario[] listaParse=new ArbolBinario[100];
        kLP=1;

        String menuPrincipal = "En todos los metodos de contruccion en los que ingrese datos, seran de un solo digito\n" +
                "1.\tListas generalizadas\n" +
                "2.\tArboles ene-arios\n" +
                "3.\tArboles binarios\n" +
                "4. Salir";

        String menuLG = "1.\tConstructor\n" +
                "2.\tMostrar listas\n" +
                "3.\tCopiar lista.\n" +
                "4. Volver";

        String menuA = "1. Contructor\n" +
                "2. Mostrar arboles\n" +
                "3. Copiar arbol\n" +
                "4. Altura,grado y cantidad de hojas de un arbol\n" +
                "5. Determinar si los datos son primos\n" +
                "6. Construir arbol n-ario como binario, muestra la altura,\n" +
                "    cantidad de hojas y grado de el arbol binario creado\n" +
                "   (genera bien el arbol binario, problemas en encontrar los\n" +
                "    otros datos, solucionar)" +
                "7. Volver";

        String menuAB = "1. Construir arbol binario aleatorio\n" +
                "2. Construir arbol binario de busqueda\n" +
                "3. Mostrar recorridos inorden, posorden y preorden de los arboles binarios\n" +
                "4. Mostrar distancia entre cada par de hojas del arbol binario(incompleto)\n" +
                "5. Mostrar distancia entre dos datos seleccionados(incompleto)\n" +
                "6. Volver";

        String opcionPrincipal, opcionLG, opcionA, opcionAB;

        do {
            opcionPrincipal = JOptionPane.showInputDialog(menuPrincipal);

            switch (opcionPrincipal) {

                case "1"://LG
                    do {
                        opcionLG = JOptionPane.showInputDialog(menuLG);

                        switch (opcionLG) {
                            case "1"://constuctpr
                                String datosLG = JOptionPane.showInputDialog("ingrese la lista generalizada(ponga especial" +
                                        "atencion a las comas,´(´ y ´)´, no use espacios)");
                                ListaGeneralizada lG = new ListaGeneralizada(datosLG);
                                listaLG[kLG] = lG;
                                kLG++;
                                JOptionPane.showMessageDialog(null, lG.mostrarLG(lG.primerNodo()));
                                break;

                            case "2"://mostrar LG
                                if (kLG != 1) {
                                    String mostrarLG = "";
                                    for (int i = 1; i < kLG; i++) {
                                        mostrarLG += "Lista generalizada #" + (i) + "\n" +
                                                listaLG[i].mostrarLG(listaLG[i].primerNodo()) + "\n\n";
                                    }
                                    JOptionPane.showMessageDialog(null, mostrarLG);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"No ha ingresado ninguna lista");
                                }
                                break;

                            case "3":// copiaLG

                                if (kLG != 1) {
                                    String mostrarLG = "Seleccione la lista que va a copiar:\n";
                                    for (int i = 1; i < kLG; i++) {
                                        mostrarLG += "Lista generalizada #" + (i) + "\n" +
                                                listaLG[i].mostrarLG(listaLG[i].primerNodo()) + "\n\n";
                                    }
                                    int numeroLG=Integer.parseInt(JOptionPane.showInputDialog(mostrarLG));
                                    ListaGeneralizada copiaLG= listaLG[numeroLG].copiaLG();
                                    listaLG[kLG]=copiaLG;
                                    kLG++;
                                    JOptionPane.showMessageDialog(null,"Podra ver en la opcion de mostrar listas, que aparecen repetida la lista que copio");
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"No ha ingresado ninguna lista");
                                }
                                break;
                        }
                    } while (!opcionLG.equals("4"));
                    break;

                case "2"://Arbol
                    do {
                        opcionA = JOptionPane.showInputDialog(menuA);

                        switch (opcionA){

                            case "1"://constructor
                                String datosA=JOptionPane.showInputDialog("ingrese el arbol(ponga especial" +
                                        "atencion a las comas,´(´ y ´)´no use espacios)");
                                Arbol arbol=new Arbol(datosA);
                                listaArbol[kA]=arbol;
                                kA++;
                                JOptionPane.showMessageDialog(null,arbol.muestrArbol(arbol.getPrimero(),0));
                                break;


                            case "2"://mostrar arboles
                                if (kA != 1) {
                                    String mostrarArbole = "";
                                    for (int i = 1; i < kA; i++) {
                                        mostrarArbole += "Arbol #" + (i) + "\n" +
                                                listaArbol[i].muestrArbol(listaArbol[i].getPrimero(),0)+"\n\n";
                                    }
                                    JOptionPane.showMessageDialog(null, mostrarArbole);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"No ha ingresado ningun arbol");
                                }
                                break;

                            case "3"://copiar arbol
                                if (kA != 1) {
                                    String mostrarArbole = "Seleccione el arbol a copiar\n";
                                    for (int i = 1; i < kA; i++) {
                                        mostrarArbole += "Arbol #" + (i) + "\n" +
                                                listaArbol[i].muestrArbol(listaArbol[i].getPrimero(),0)+"\n\n";
                                    }
                                    int numeroArbol=Integer.parseInt(JOptionPane.showInputDialog(mostrarArbole));
                                    Arbol copiaArbol=listaArbol[numeroArbol].copiarArbol();
                                    listaArbol[kA]=copiaArbol;
                                    kA++;
                                    JOptionPane.showMessageDialog(null,"Podra ver en la opcion de mostrar arboles, que aparecen repetida la lista que copio");
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"No ha ingresado ningun arbol");
                                }
                                break;

                            case "4"://altura grado y hojas
                                if (kA != 1) {
                                    String mostrarArbole = "";
                                    for (int i = 1; i < kA; i++) {
                                        mostrarArbole += "Arbol #" + (i) + "\n" +
                                                listaArbol[i].muestrArbol(listaArbol[i].getPrimero(),0)+"\n" +
                                                "La altura de este arbol es de: "+listaArbol[i].altura(listaArbol[i].getPrimero())+"\n" +
                                                "El grado de este arbol es de: "+listaArbol[i].gradoArbol(listaArbol[i].getPrimero())+"\n" +
                                                "La cantidad de hojas de este arbol es de: "+listaArbol[i].hojas(listaArbol[i].getPrimero())+"\n\n";
                                    }
                                    JOptionPane.showMessageDialog(null, mostrarArbole);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"No ha ingresado ningun arbol");
                                }

                                break;

                            case "5"://datos primos
                                if (kA != 1) {
                                    String mostrarArbole = "Seleccione el arbol a copiar\n";
                                    for (int i = 1; i < kA; i++) {
                                        mostrarArbole += "Arbol #" + (i) + "\n" +
                                                listaArbol[i].muestrArbol(listaArbol[i].getPrimero(),0)+"\n\n";
                                    }
                                    int numeroPrimos=Integer.parseInt(JOptionPane.showInputDialog(mostrarArbole));

                                    String primo=JOptionPane.showInputDialog("ingrese los dos datos a evaluar si son primos(separados por una coma)");
                                    String[] primos=primo.split(",");
                                    if (listaArbol[numeroPrimos].getPrimero().getDato().equals(primos[0]) || listaArbol[numeroPrimos].getPrimero().getDato().equals(primos[1]) ){
                                        JOptionPane.showMessageDialog(null,"uno de los datos es la raiz por lo tanto no son primos");
                                        break;
                                    }
                                    if (primos[0].equals(primos[1])){
                                        JOptionPane.showMessageDialog(null,"los datos a evaluar son igulaes por lo tanto no son primos");
                                        break;
                                    }
                                    if (listaArbol[numeroPrimos].padre(primos[0])==null){
                                        JOptionPane.showMessageDialog(null,"el dato "+primos[0]+" no esta en el arbol");
                                        break;
                                    }
                                    if (listaArbol[numeroPrimos].padre(primos[1])==null){
                                        JOptionPane.showMessageDialog(null,"el dato "+primos[1]+" no esta en el arbol");
                                        break;
                                    }
                                    if (listaArbol[numeroPrimos].padre(primos[0])==listaArbol[numeroPrimos].padre(primos[1])){
                                        System.out.println(listaArbol[numeroPrimos].padre(primos[0]).getDato());
                                        System.out.println(listaArbol[numeroPrimos].padre(primos[1]).getDato());
                                        JOptionPane.showMessageDialog(null,"Los datos son hermanos");
                                        break;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null,"son primos");
                                    }


                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"No ha ingresado ningun arbol");
                                }
                                break;

                            case"6"://convertir arbol n-ario a binario
                                if (kA != 1) {
                                    String mostrarArbole = "Seleccione el arbol a copiar\n";
                                    for (int i = 1; i < kA; i++) {
                                        mostrarArbole += "Arbol #" + (i) + "\n" +
                                                listaArbol[i].muestrArbol(listaArbol[i].getPrimero(), 0) + "\n\n";
                                    }
                                    int numeroParse = Integer.parseInt(JOptionPane.showInputDialog(mostrarArbole));
                                    ArbolBinario parse= new ArbolBinario();
                                    parse.parseArbolBinario(listaArbol[numeroParse].getPrimero());
                                    JOptionPane.showMessageDialog(null,parse.mostrarInorden(parse.getRaiz())+"\n" +
                                                    "La cantidad de hojas es de: "+parse.hojasParse(parse.getRaiz())+"\n" +
                                            "La altura es de: "+parse.alturaParse(parse.getRaiz()
                                    ));
                                }
                                break;

                            case "7":
                                break;
                        }

                    } while (!opcionA.equals("7"));
                    break;

                case "3":
                    do {
                        opcionAB = JOptionPane.showInputDialog(menuAB);

                        switch (opcionAB){

                            case "1"://contructor arbol aleatorio
                                String digitos="abcdefghijklmnopqrsyuvwxyz";
                                String[] cambio=digitos.split("");

                                char[] abecedario = new char[cambio.length + 1];
                                for (int i = 1; i < abecedario.length; i++) {
                                    abecedario[i] = cambio[i-1].charAt(0);
                                }

                                int tamano=(int)(Math.random()*40)+1;
                                char[] raiz= new char[tamano];
                                for (int i=1;i<tamano;i++){
                                    int dato=(int)(Math.random()*abecedario.length);
                                    if (dato==0){
                                        dato=1;
                                    }
                                    raiz[i]=abecedario[dato];
                                }

                                ArbolBinario arbolBinario=new ArbolBinario(raiz);
                                listaArbolBinario[kAB]=arbolBinario;
                                kAB++;
                                JOptionPane.showMessageDialog(null,arbolBinario.mostrarInorden(arbolBinario.getRaiz()));
                                break;

                            case "2"://contruir arbol binario de busqueda
                                String datos=JOptionPane.showInputDialog("ingrese los datos del arbol binario de busqueda(no use espacios)");
                                String[] dato=datos.split("");
                                ArbolBinario arbolBinarioBusqueda=new ArbolBinario();
                                for (int i=0;i<dato.length;i++){
                                    if (arbolBinarioBusqueda.buscarDato(arbolBinarioBusqueda.getRaiz(),dato[i].charAt(0))==false){
                                        System.out.println(arbolBinarioBusqueda.buscarDato(arbolBinarioBusqueda.getRaiz(),dato[i].charAt(0)));
                                        arbolBinarioBusqueda.ArbolBinarioBusqueda(dato[i].charAt(0));
                                    }
                                }
                                listaABB[kABB]=arbolBinarioBusqueda;
                                kABB++;
                                JOptionPane.showMessageDialog(null,arbolBinarioBusqueda.mostrarInorden(arbolBinarioBusqueda.getRaiz()));
                                break;

                            case "3"://mostrar arboles binarios
                                String mostrarAB="Arboles binarios:\n";
                                for (int i=1;i<kAB;i++){
                                    mostrarAB+="\nArbol binario #"+i+"\n" +
                                            "Forma inorden\n" +
                                            listaArbolBinario[i].mostrarInorden(listaArbolBinario[i].getRaiz())+"\n" +
                                            "Forma preorden\n" +
                                            listaArbolBinario[i].mostrarPreorden(listaArbolBinario[i].getRaiz())+"\n"+
                                            "Forma posorden\n" +
                                            listaArbolBinario[i].mostrarPosorden(listaArbolBinario[i].getRaiz())+"\n";
                                }
                                mostrarAB+="\nArboles binarios de busqueda:\n";
                                for (int i=1;i<kABB;i++){
                                    mostrarAB+="\nArbol binario de busqueda #"+i+"\n" +
                                            "Forma inorden\n" +
                                            listaABB[i].mostrarInorden(listaABB[i].getRaiz())+"\n" +
                                            "Forma preorden\n" +
                                            listaABB[i].mostrarPreorden(listaABB[i].getRaiz())+"\n"+
                                            "Forma posorden\n" +
                                            listaABB[i].mostrarPosorden(listaABB[i].getRaiz())+"\n";
                                }
                                JOptionPane.showMessageDialog(null,mostrarAB);

                                break;

                            case "4"://distancia hojas


                                break;

                            case "5"://distancia entre 2 datos seleccionados


                                break;

                            case"6":
                                break;
                        }

                    } while (!opcionAB.equals("6"));
                    break;

                case "4":
                    break;

            }

        } while (!opcionPrincipal.equals("4"));


    }
}
