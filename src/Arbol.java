import com.sun.org.apache.xpath.internal.objects.XNodeSetForDOM;
import sun.applet.AppletIllegalArgumentException;

import java.util.Stack;

public class Arbol {
    /*  MARCELO DE LA HOZ SIERRA CC 1037669479
     */

    private NodoLG primero=new NodoLG(null);
    private NodoLG ultimo;

    public Arbol(String s) {
        String[] lista = s.split("");
        int i,n;
        NodoLG x;
        Pila pila=new Pila(100);
        ultimo=primero;
        primero.setDato(lista[1]);
        n=s.length();
        if (n==3){
            return;
        }
        i=3;
        while (i<=n-3){
            x=new NodoLG(null);
            ultimo.setLiga(x);
            ultimo=x;
            if (lista[i+1].equals("(")){
                ultimo.setSw(1);
                pila.apilar(ultimo);
                x=new NodoLG(lista[i]);
                ultimo.setDato(x);
                ultimo=x;
                i=i+2;
            }else{
                ultimo.setDato(lista[i]);
                if (lista[i+1].equals(")")){
                    i+=1;
                    while (i<n && lista[i].equals(")") && !pila.esVacia()){
                        ultimo=pila.desapilar();
                        i+=1;
                    }
                    if (lista[i].equals(",")){
                        i+=1;
                    }
                }else {
                    i+=2;
                }
            }
        }

    }

    public int gradoArbol(NodoLG r) {
        if (r == null || r.getLiga() == null) {
            return 0;
        }
        int grado = 0;
        int cuenta = 0;
        NodoLG p = r.getLiga();
        while (p != null) {
            cuenta+=1;
            if (p.getSw() == 1) {
                int g = gradoArbol((NodoLG) p.getDato());
                if (g > grado) {
                    grado = g;
                }
            }
            p = p.getLiga();
        }
        if (cuenta > grado) {
            grado = cuenta;
        }
        return grado;
    }

    public int hojas(NodoLG r){
        if(r==null){
            return 0;
        }
        if (r.getLiga()==null){
            return 1;
        }
        int hojas=0;
        NodoLG p=r.getLiga();
        while (p!=null){
            if (p.getSw()==0){
                hojas+=1;
            }
            else {
                hojas+=hojas((NodoLG)p.getDato());
            }
            p=p.getLiga();
        }
        return hojas;
    }

    public int gradoDeUnDato(String d){
        String[] lista=d.split("");
        int n=0;
        NodoLG p,q;
        Pila pila=new Pila(100);
        p=getPrimero();
        if (p.getDato().equals(lista[0])){
            p=p.getLiga();
            while (p!=null){
                n+=1;
                p=p.getLiga();
            }
            return n;
        }
        p=p.getLiga();
        while (p!=null){
            if (p.getSw()==0){
                if (p.getDato().equals(lista[0])){
                    return 0;
                }
                p=p.getLiga();
            }
            else {

                q=(NodoLG)p.getDato();
                if (q.getDato().equals(lista[0])){
                    p=q.getLiga();
                    while (p!=null){
                        n+=1;
                        p=p.getLiga();
                    }
                    return n;
                }
                else {
                    pila.apilar((p.getLiga()));
                    p=q.getLiga();
                }
            }
            while (p==null && !pila.esVacia()){
                p=(NodoLG)pila.desapilar();
            }
        }
        System.out.println("Dato no esta en el arbol");
        return 0;
    }

    public int altura(NodoLG L){
        NodoLG p;
        int g,h;
        h=1;
        if (L==null){
            return 0;
        }
        if (L.getLiga()==null){
            return 1;
        }
        p=L;
        while (p!=null){
            if (p.getSw()==1){
                g=altura((NodoLG)p.getDato());
                if (g>h){
                    h=g;
                }
            }
            p=p.getLiga();
        }
        return h+1;
    }

    public NodoLG getPrimero(){
        return primero;
    }

    public String muestrArbol(NodoLG L,int band){//revisar importante
        String lista="";
        NodoLG p,first,q;
        Pila pila=new Pila(100);
        if (L==null){
            return lista;
        }
        first=null;
        if (band==0){
            lista+="("+L.getDato();
            if (L.getLiga()==null){
                lista+=")";
                return lista;
            }
            lista+="(";
            first=L;
        }
        p=L.getLiga();
        while (p!=null){
            if (p.getSw()==0){
                lista+=p.getDato();
            }
            else {
                q=(NodoLG)p.getDato();
                lista+=q.getDato()+"(";
                lista+=muestrArbol((NodoLG)p.getDato(),1);
            }
            if (p.getLiga()!=null){
                lista+=",";
            }
            p=p.getLiga();
        }
        lista+=")";
        if (first==L){
            lista+=")";
        }
        return lista;
    }

    public Arbol copiarArbol(){
        Arbol copia=new Arbol(muestrArbol(primero,0));
        return copia;
    }

    public NodoLG padre(String d){
        int n=0;
        if (primero.getDato().equals(d)){
            return primero;
        }
        NodoLG p,q;
        Pila pila=new Pila(100);
        p=getPrimero();
        pila.apilar(p);
        p=p.getLiga();
        while (p!=null){
            if (p.getSw()==0){
                if (p.getDato().equals(d)){
                    return pila.desapilar();
                }
                p=p.getLiga();
            }
            else {
                q=(NodoLG)p.getDato();
                if (q.getDato().equals(d)){
                    return pila.desapilar();
                }
                else{
                    pila.apilar(p.getLiga());
                    p=q.getLiga();
                }
            }
            while (p==null && !pila.esVacia()){
                p=pila.desapilar();
            }
        }
        return null;
    }

    public NodoLG padreNodo(NodoLG d){
        if (primero==d){
            return primero;
        }
        NodoLG p,q;
        Pila pila=new Pila(100);
        p=getPrimero();
        pila.apilar(p);
        p=p.getLiga();
        while (p!=null){
            if (p.getSw()==0){
                if (p==d){
                    return pila.desapilar();
                }
                p=p.getLiga();
            }
            else {
                q=(NodoLG)p.getDato();
                if (q==d){
                    return pila.desapilar();
                }
                else{
                    pila.apilar(p.getLiga());
                    p=q.getLiga();
                }
            }
            while (p==null && !pila.esVacia()){
                p=pila.desapilar();
            }
        }
        return null;
    }


}
