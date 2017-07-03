package matias.utilidades.collections;

/**
 * Created by matias on 11/06/17.
 */
public interface SingleItemCollectionFilter<T> {
    /**
     * Should check if the next object is better than the comparisonObject
     * @param comparisonObject - The current best object
     * @param nextObject - The object we want to compare with the best object
     * @return true if the nextObject is better than the comparisonObject
     */
    boolean passes(T comparisonObject, T nextObject);
}
