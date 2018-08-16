package Source;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolAVL {
    Nodo raiz;

    public ArbolAVL() {

        this.raiz = null;

    }
    
    Nodo rotacionDerecha(Nodo x) {
        Nodo h = x.izquierdo; 
        x.izquierdo = h.derecho;
        h.derecho = x;
        
        setFactorBalance(x);
        setFactorBalance(h);
        
        return h;
    }

    Nodo rotacionDobleDerecha(Nodo x) {
        x.izquierdo = rotacionIzquierda(x.izquierdo);
        return rotacionDerecha(x);                        
    } 
    
    Nodo rotacionIzquierda(Nodo x) {
        Nodo h = x.derecho;
        x.derecho = h.izquierdo;        
        h.izquierdo = x;
 
        setFactorBalance(x);
        setFactorBalance(h);
        
        return h;
    }
    
    Nodo rotacionDobleIzquierda(Nodo x) {
        x.derecho = rotacionDerecha(x.derecho);
        return rotacionIzquierda(x);                        
    } 
    
    int getInfo(Nodo nodo){
        return nodo.dato;
    }
    
    Nodo insertar(Nodo nodo, int dato) {
        if (nodo == null)
            return (new Nodo(dato));
 
        if (dato < getInfo(nodo))
            nodo.izquierdo = insertar(nodo.izquierdo, dato);
        else if (dato > getInfo(nodo))
            nodo.derecho = insertar(nodo.derecho, dato);
        else 
            return nodo;
 
        setFactorBalance(nodo);
      
        if (getFactorBalance(nodo) == -2 && getFactorBalance(nodo.izquierdo)!=1)
            return rotacionDerecha(nodo);
 
        if (getFactorBalance(nodo) == 2 && getFactorBalance(nodo.derecho)!=-1)
            return rotacionIzquierda(nodo);
 
        if (getFactorBalance(nodo) == 2 && getFactorBalance(nodo.derecho)==-1) {
            return rotacionDobleIzquierda(nodo);
        }
        
        if (getFactorBalance(nodo) == -2 && getFactorBalance(nodo.izquierdo)==1) {
            return rotacionDobleDerecha(nodo);
        }
        
        return nodo;
    }

    int getAltura(Nodo raiz) {
        if (raiz == null) 
            return -1;
        else 
            return (1 + Math.max(getAltura(raiz.izquierdo), getAltura(raiz.derecho)));

    }

    int getFactorBalance(Nodo raiz) {
        if (raiz == null)
            return 0; 
        return raiz.factorBalance;
    }

    void setFactorBalance(Nodo raiz) {
        if (raiz != null)
            raiz.factorBalance=getAltura(raiz.derecho)-getAltura(raiz.izquierdo);
    }

    void Preorden(Nodo raiz){
        if( raiz != null){
            System.out.print("["+raiz.getDato()+"]");
            Preorden(raiz.getIzquierdo());
            Preorden(raiz.getDerecho());
        }
        
    }

    void InOrden(Nodo raiz){
        if(raiz != null){
            InOrden(raiz.getIzquierdo());
            System.out.print("["+raiz.getDato()+"]");
            InOrden(raiz.getDerecho());
        }
    }
    
    void PostOrden(Nodo raiz){
        if(raiz != null){
            PostOrden(raiz.getIzquierdo());
            PostOrden(raiz.getDerecho());
            System.out.print("["+raiz.getDato()+"]");
        }
    }

    boolean esEstricto(Nodo raiz){
        boolean estricto = false;
        Queue<Nodo> q = new LinkedList<>();
        q.add(raiz);
        while(!q.isEmpty()){
            Nodo aux = q.remove();

            if(aux.derecho == null && aux.izquierdo == null){
                estricto = true;
            }else if (aux.derecho != null && aux.izquierdo != null){
                estricto = true;
                q.add(aux.derecho);
                q.add(aux.izquierdo);
            }else{
                return false;
            }
        }
        return estricto;
    }

    boolean esLleno(Nodo raiz){

        if (raiz == null){
            return true;

        }

        if(getAltura(raiz.derecho) == getAltura(raiz.izquierdo)){

            if (raiz.derecho != null && raiz.izquierdo != null){
                if (esLleno(raiz.derecho) && esLleno(raiz.izquierdo)){
                    return true;

                }else{
                    return false;

                }
            }else if(raiz.derecho == null && raiz.izquierdo == null){
                return true;
            }else {
                return false;
            }


        }else{
            return false;
        }

    }

}
