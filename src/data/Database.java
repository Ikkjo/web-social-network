package data;

public interface Database<T> {
	
	public abstract void Save(T obj);
	public abstract T Load();

}
