package service;

public abstract class DB {

	protected abstract void update(Object obj);

	public abstract void delete(Object obj);

	protected abstract Object get(Object obj);
}
