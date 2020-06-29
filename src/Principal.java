import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;

public class Principal {
    public static void main(String[] args) {

        String r = "a,b,j,c,h,i,k,d,e,f,g,l,m,n,o";
        String[] x = r.split(",");

        char[] raiz = new char[x.length + 1];
        for (int i = 0; i < x.length; i++) {
            raiz[i + 1] = x[i].charAt(0);
        }

        System.out.println(raiz.length);
        String coreccion = "";
        for (int i = 1; i < raiz.length; i++) {
            coreccion += raiz[i] + " ";
        }
        System.out.println(coreccion);

        ArbolBinario binario = new ArbolBinario(raiz);

        System.out.println(binario.mostrarInorden(binario.getRaiz()));

        System.out.println(binario.mostrarPreorden(binario.getRaiz()));

        System.out.println(binario.mostrarPosorden(binario.getRaiz()));

        int kLG, kA, kAB, kABB;
        ListaGeneralizada[] listaLG = new ListaGeneralizada[100];
        kLG = 1;
        Arbol[] listaArbol = new Arbol[100];
        kA = 1;
        ArbolBinario[] listaArbolBinario = new ArbolBinario[100];
        kAB = 1;
        ArbolBinario[] listaABB = new ArbolBinario[100];
        kABB = 1;

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
                "4. Altura,grado y camtidad de hojas de un arbol\n" +
                "5. Determinar si los datos son primos\n" +
                "6. Construir arbol n-ario como binario, muestra la altura,\n" +
                "    cantidad de hojas y grado de el arbol binario creado\n" +
                "7. Volver";

        String menuAB = "1. Construir arbol binario aleatorio\n" +
                "2. Construir arbol binario de busqueda\n" +
                "3. Mostrar recorridos inorden, posorden y preorden de los arboles binarios\n" +
                "4. Mostrar distancia entre cada par de hojas del arbol binario\n" +
                "5. Mostrar distancia entre dos datos seleccionados\n" +
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
                                        "atencion a las comas,´(´ y ´)´)");
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
                                        "atencion a las comas,´(´ y ´)´)");
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
                        }

                    } while (!opcionA.equals("7"));
                    break;

                case "3":
                    do {
                        opcionAB = JOptionPane.showInputDialog(menuAB);

                    } while (!opcionAB.equals("6"));
                    break;

                case "4":
                    break;

            }

        } while (!opcionPrincipal.equals("4"));
    }
}
