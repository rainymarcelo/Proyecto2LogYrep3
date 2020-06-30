public class NodoLG {
    /*  MARCELO DE LA HOZ SIERRA CC 1037669479
     */
    private int sw;
    private Object dato;
    private NodoLG liga;

    public NodoLG(Object dato) {
        this.sw=0;
        this.dato = dato;
        this.liga = null;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoLG getLiga() {
        return liga;
    }

    public void setLiga(NodoLG liga) {
        this.liga = liga;
    }


}
