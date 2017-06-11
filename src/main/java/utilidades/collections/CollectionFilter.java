package utilidades.collections;

import java.util.Collection;

/**
 * Created by matias on 11/06/17.
 */
public interface CollectionFilter<T> {
    boolean passes(T myObject);
}
