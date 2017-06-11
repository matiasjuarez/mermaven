package utilidades.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by matias on 11/06/17.
 */
public class CollectionFilterUtility {

    public static <T> ArrayList<T> getFilteredCollection(
            Collection<T> collection, CollectionFilter<T> filter){

        Iterator<T> iterator = collection.iterator();
        ArrayList<T> filteredList = new ArrayList<>();

        while(iterator.hasNext()){
            T nextObject = iterator.next();

            if(filter.passes(nextObject)){
                filteredList.add(nextObject);
            }
        }

        return filteredList;
    }
}
