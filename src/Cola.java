public class Cola {
    private int primero,ultimo,n;
    private NodoLG[] V;

    public Cola(int m){
        n=m;
        primero=ultimo=0;
        V=new NodoLG[n];
    }

    public boolean esVacia(){
        return primero==ultimo;
    }

    public boolean esLlena(){
        return primero==0 && ultimo==n;
    }

    public void enColar(NodoLG d){
        if (esLlena()){
            return;
        }
        if (ultimo==n){
            for (int i=primero+1;i<=n;i++){
                V[i-primero]=V[i];
            }
            ultimo-=primero;
            primero=0;
        }
        ultimo++;
        V[ultimo]=d;
    }

    public NodoLG desenColar(){
        if (esVacia()){
            return null;
        }
        primero++;
        return V[primero];
    }


}
