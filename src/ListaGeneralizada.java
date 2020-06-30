import org.omg.CORBA.NO_IMPLEMENT;

import java.util.Stack;

public class ListaGeneralizada {
    /*  MARCELO DE LA HOZ SIERRA CC 1037669479
     */

    private  NodoLG primero=null;
    private  NodoLG ultimo=primero;

    public ListaGeneralizada(String s){
        String[] lista=s.split("");
        Pila pila= new Pila(100);
        NodoLG x=new NodoLG(null);
        primero=x;
        ultimo=x;
        int n=s.length();
        for (int i=1;i<n;i++){
            if (lista[i].equals("(")){
                pila.apilar(ultimo);
                x=new NodoLG(null);
                ultimo.setSw(1);
                ultimo.setDato(x);
                ultimo=x;
            }
            if (lista[i].equals(",")){
                x=new NodoLG(null);
                ultimo.setLiga(x);
                ultimo=x;
            }
            if (lista[i].equals(")")){
                ultimo=(NodoLG) pila.desapilar();
            }else{
                ultimo.setSw(0);
                ultimo.setDato(lista[i]);
            }
        }

    }

    public ListaGeneralizada(){
    }

    public NodoLG primerNodo(){
        return primero;
    }

    public void setPrimero(NodoLG p){
        primero=p;
    }

    public NodoLG getUltimo(){
        return ultimo;
    }

    public boolean finDeRecorrido(NodoLG p){
        return(p.getLiga()==null);
    }

    public void asignaUltimo(){
        NodoLG p=primero;
        while (!finDeRecorrido(p)){
            ultimo=p;
            p=p.getLiga();
        }
        ultimo=p;
    }

    public String mostrarLG(NodoLG x){//no funciona
        String lista="(";
        NodoLG p=x;
        while (!finDeRecorrido(p)){
            if (p.getSw()==0){
                lista+=p.getDato();
            }
            if (p.getSw()==1){
                lista+=mostrarLG((NodoLG) p.getDato());
            }
            if (p.getLiga()!=null){
                lista+=",";
            }
            p=p.getLiga();
        }
        if (p.getSw()==1){
            lista+=mostrarLG((NodoLG)p.getDato())+")";
        }
        else {
            lista+=p.getDato()+")";
        }
        return lista;
    }

    public ListaGeneralizada copiaLG(){
        ListaGeneralizada c=new ListaGeneralizada();
        c.setPrimero(copia(primerNodo()));
        return c;
    }

    public NodoLG copia(NodoLG p){
        NodoLG x;
        x=null;
        if (p!=null){
            x=new NodoLG(null);
            if (p.getSw()==1){
                x.setSw(1);
                x.setDato(copia((NodoLG)p.getDato()));
            }
            else {
                x.setDato(p.getDato());
            }
            x.setLiga(copia(p.getLiga()));
        }
        return x;
    }

}
