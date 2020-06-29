import java.lang.reflect.Array;

public class Pila {
    private NodoLG[] V;
    private  int tope,n;

    public Pila(int m){
        V=new NodoLG[m];
        n=m;
        tope=0;
    }

    public boolean esVacia(){
        return tope==0;
    }

    public boolean esLlena(){
        return tope==n;
    }

    public void apilar(NodoLG d){
        if (esLlena()){
            return;
        }
        tope++;
        V[tope]=d;
    }

    public NodoLG desapilar(){
        if (esVacia()){
            return null;
        }
        NodoLG d=V[tope];
        tope=tope-1;
        return d;
    }

    public void desapilar(int i){
        if ((tope-i)>=0){
            tope--;
        }else {
            System.out.println("no se puede eliminar tantos elementos");
        }
    }
}
