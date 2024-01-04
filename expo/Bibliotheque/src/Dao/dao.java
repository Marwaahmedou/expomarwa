package Dao;


import java.util.List;

public interface dao<T> {

	public T get(long id);
	public List<T> getAll();
	public void save(T t);
	public void update(T t, String[] params);
	public void delete(T t);

}