package service;

public abstract class DB {

	protected abstract void update(Object obj);

	protected abstract void delete(Object obj);

	protected abstract Object read(Object obj);
}
