package matias.utilidades.collections;

/**
 * Created by matias on 11/06/17.
 */
public interface CollectionFilter<T> {
    boolean passes(T myObject);
}
