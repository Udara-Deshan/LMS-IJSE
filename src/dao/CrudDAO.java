package dao;

import java.util.ArrayList;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public interface CrudDAO<T, ID> extends SuperDAO {
    public boolean add(T entity)throws Exception;

    public ArrayList<T> getAll()throws Exception;

    public boolean delete(ID id) throws Exception;

    public boolean update(T entity) throws Exception;

    public ArrayList<T> search(T entity) throws Exception;
}
