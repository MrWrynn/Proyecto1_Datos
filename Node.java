package Proyecto1;
public class Node {
    public Object data;
    public Node siguiente;
    public Node anterior;

    public Node(Object data) {
        this.siguiente = null;
        this.anterior = null;
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getSiguiente() {
        return this.siguiente;
    }

    public Node getAnterior() {
        return this.anterior;
    }

    public void setSiguiente(Node node) {
        this.siguiente = node;
    }

    public void setAnterior(Node node) {
        this.anterior= node;
    }
}
