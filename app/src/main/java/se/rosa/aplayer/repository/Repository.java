package se.rosa.aplayer.repository;

/**
 * Created by Robert on 18/10/18.
 */

public interface Repository<T> {

    long addOrUpdate(T t);

    int getItem(int id);

    int deleteItem(T t);

}
