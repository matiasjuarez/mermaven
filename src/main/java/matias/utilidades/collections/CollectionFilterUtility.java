package matias.utilidades.collections;

import org.apache.commons.collections.CollectionUtils;

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

    public static <T> T getObjectFromCollection(
            Collection<T> collection, SingleItemCollectionFilter<T> filter, boolean nullCheck){

        if(nullCheck){
            collection = removeNullObjects(collection);
        }

        if(CollectionUtils.isEmpty(collection)){
            return null;
        }

        Iterator<T> iterator = collection.iterator();
        T comparisonObject = iterator.next();

        while(iterator.hasNext()){
            T nextObject = iterator.next();

            if(filter.passes(comparisonObject, nextObject)){
                comparisonObject = nextObject;
            }
        }

        return comparisonObject;
    }

    private static <T> ArrayList<T> removeNullObjects(Collection<T> collection){
        ArrayList<T> filteredCollection = new ArrayList<>();

        if(!CollectionUtils.isEmpty(collection)){
            Iterator<T> iterator = collection.iterator();

            while(iterator.hasNext()){
                T nextObject = iterator.next();

                if(nextObject != null){
                    filteredCollection.add(nextObject);
                }
            }
        }

        return filteredCollection;
    }
}
