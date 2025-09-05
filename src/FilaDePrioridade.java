import java.util.*;

public class FilaDePrioridade<T> {
    private List<T> lista;
    private Comparator<T> comparator;

    public FilaDePrioridade() {
        this.lista = new ArrayList<>();
        this.comparator = null;
    }

    public FilaDePrioridade(Comparator<T> comparator) {
        this.lista = new ArrayList<>();
        this.comparator = comparator;
    }

    private int comparar(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        return ((Comparable<T>) a).compareTo(b);
    }

    public void enfileirar(T elemento) {
        for (int i = 0; i < lista.size(); i++) {
            if (comparar(elemento, lista.get(i)) > 0) {
                lista.add(i, elemento);
                return;
            }
        }
        lista.add(elemento);
    }

    public T desenfileirar() {
        if (lista.isEmpty()) {
            throw new IllegalStateException("Fila vazia!");
        }
        return lista.remove(0);
    }

    public T espiar() {
        if (lista.isEmpty()) {
            throw new IllegalStateException("Fila vazia!");
        }
        return lista.get(0);
    }

    public boolean estaVazia() {
        return lista.isEmpty();
    }

    public int tamanho() {
        return lista.size();
    }
}
