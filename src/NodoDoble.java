public class NodoDoble {
    char dato;
    NodoDoble ld,li;

    public NodoDoble(char dato) {
        this.dato = dato;
        this.ld = null;
        this.li = null;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NodoDoble getLd() {
        return ld;
    }

    public void setLd(NodoDoble ld) {
        this.ld = ld;
    }

    public NodoDoble getLi() {
        return li;
    }

    public void setLi(NodoDoble li) {
        this.li = li;
    }

}
