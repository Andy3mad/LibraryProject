package dataaccess.base;

import java.util.List;
import java.util.Optional;

import dataaccess.storage.PersistanceManager;

public abstract class BaseDao<T, ID> implements IDao<T, ID> {

	abstract public String getTableName();

	@Override
	public List<T> getAll() {
		return secretGetAll();
	}

	protected List<T> secretGetAll() {
		return PersistanceManager.getEntityAllData(this);
	}

	@Override
	public void insert(T t) {
		secretGetAll().add(t);
		PersistanceManager.saveData();
	}

	@Override
	public boolean deleteEntity(T t) {
		Optional<T> find = secretGetAll().stream().filter(e -> t == e).findAny();
		if (find.isPresent()) {
			secretGetAll().remove(find.get());
			return true;
		}
		return false;

	}
}
