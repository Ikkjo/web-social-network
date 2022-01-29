package data;

public interface Database{
	
	public abstract void Save(Object obj);
	public abstract Object Load();

}
