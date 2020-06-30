public class ArbolBinario {
    /*  MARCELO DE LA HOZ SIERRA CC 1037669479
     */
    NodoDoble raiz = null;


    public ArbolBinario() {

    }

    public void parseArbolBinario(NodoLG arbol){
        if (arbol!=null){
            String s=(String)arbol.getDato();
            char g=s.charAt(0);
            NodoDoble x= new NodoDoble(g);
            raiz=x;
        }
        NodoDoble x=raiz;
        NodoLG p,q;
        p=arbol.getLiga();
        while (p!=null){
            if(p.getSw()==0){
                String s=(String)p.getDato();
                char g=s.charAt(0);
                NodoDoble y= new NodoDoble(g);
                if (x==raiz){
                    x.setLi(y);
                    x=x.getLi();
                }
                else {
                    x.setLd(y);
                    x=x.getLd();
                }
                p=p.getLiga();
            }
            else {
                q=(NodoLG)p.getDato();
                if (x==raiz){
                    ArbolBinario recursivo=new ArbolBinario();
                    recursivo.parseArbolBinario(q);
                    x.setLi(recursivo.getRaiz());
                    p=p.getLiga();
                    x=x.getLi();
                }
                else {
                    ArbolBinario recursivo=new ArbolBinario();
                    recursivo.parseArbolBinario(q);
                    x.setLd(recursivo.getRaiz());
                    p=p.getLiga();
                }
            }
        }

    }

    public ArbolBinario(char[] datos){
        int k=1;
        if (k<=datos.length){
            raiz=constructor(datos,k);
        }
    }

    private NodoDoble constructor(char[] datos, int k){
        NodoDoble x=new NodoDoble(datos[k]);
        int iz=k*2;
        int de=(k*2)+1;
        if (iz<datos.length){
            x.setLi(constructor(datos,iz));
        }
        if (de<datos.length){
            x.setLd(constructor(datos,de));
        }
        return x;
    }

    public void ArbolBinarioBusqueda(char d) {
        NodoDoble x = new NodoDoble(d);
        if (raiz == null) {
            raiz = x;
            return;
        }
        NodoDoble p = raiz;
        NodoDoble q = null;
        while (p != null) {
            q = p;
            if (d< p.getDato()) {
                p = p.getLi();
            } else {
                p = p.getLd();
            }
        }
        if (d< q.getDato()) {
            q.setLi(x);
        } else q.setLd(x);
    }

    public NodoDoble getRaiz() {
        return raiz;
    }

    public String mostrarInorden(NodoDoble r) {
        String lista = "";
        if (r != null) {
            lista +=  mostrarInorden(r.getLi());
            lista +=  r.getDato() + " ";
            lista +=  mostrarInorden(r.getLd()) ;
        }
        return lista;
    }

    public String mostrarPreorden(NodoDoble r) {
        String lista = "";
        if (r != null) {
            lista += r.getDato() + " ";
            lista += mostrarInorden(r.getLi()) ;
            lista += mostrarInorden(r.getLd()) ;
        }
        return lista;
    }

    public String mostrarPosorden(NodoDoble r) {
        String lista="";
        if (r != null) {
            lista += mostrarInorden(r.getLi()) ;
            lista += mostrarInorden(r.getLd()) ;
            lista += r.getDato()+" " ;
        }
        return lista;
    }

    public int hojas(NodoDoble r){
        int hh=0;
        if (r!=null){
            if (r.getLi()==null && r.getLd()==null){
                hh+=1;
            }
            else {
                hh+=hojas(r.getLi())+hojas(r.getLd());
            }
        }
        return hh;
    }

    public int grado(NodoDoble r){
        int g=0;
        if(r!=null){
            if (r.getLd()!=null && r.getLi()!=null){
                g=2;
            }
            else {
                if (r.getLi() !=null || r.getLd()!=null){
                    g=1;
                }
            }
            g=Math.max(g,grado(r.getLd()));
            g=Math.max(g,grado(r.getLi()));
        }
        return g;
    }

    public int altura(NodoDoble r){
        int altizq,altder;
        if(r==null){
            return 0;
        }
        altizq=0;
        altder=0;
        if (r.getLi()!=null){
            altizq=altura(r.getLi());
        }
        if (r.getLd()!=null){
            altder=altura(r.getLd());
        }
        return Math.max(altizq,altder)+1;
    }

    public boolean buscarDato(NodoDoble r,char d){
        boolean esta=false;
        if (r!=null){
            if (r.getDato()==d){
                esta= true;
            }
            else {
                esta=buscarDato(r.getLd(),d);
                if (esta==false){
                    esta=buscarDato(r.getLi(),d);
                }
            }
        }
        return esta;
    }

    public int hojasParse(NodoDoble r){
        int hh=0;
        if (r!=null){
            if (r.getLi()==null){
                hh+=1;
            }
            else {
                hh+=hojasParse(r.getLi());
                hh+=hojasParse(r.getLd());
            }
        }
        return hh;
    }

    public int alturaParse(NodoDoble r){
        int altizq,altder;
        if(r==null){
            return 0;
        }
        altizq=0;
        altder=0;
        if (r.getLi()!=null){
            altizq=altura(r.getLi());
        }
        if (r.getLd()!=null){
            altder=altura(r.getLd());
        }
        return Math.max(altizq,altder)+1;
    }


}
