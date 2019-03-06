package edu.mum.library.dataaccess.base;

import java.util.Optional;

import edu.mum.library.dataaccess.storage.PersistanceManager;
import edu.mum.library.model.base.IPrimaryKeyGetter;

public abstract class BaseDaoWithPrimaryKey<T extends IPrimaryKeyGetter<ID>, ID> extends BaseDao<T, ID> {

	@Override
	public T readById(ID id) {
		Optional<T> find = secretGetAll().stream().filter(e -> id.equals(e.getPrimaryKey())).findAny();
		return find.isPresent() ? find.get() : null;
	}

	@Override
	public void save(T t) {
		ID id = t.getPrimaryKey();
		Optional<T> find = secretGetAll().stream().filter(e -> id.equals(e.getPrimaryKey())).findAny();
		if (!find.isPresent()) {
			super.insert(t);
		}
		PersistanceManager.saveDatabase();
	}

	@Override
	public void insert(T t) {
		ID id = t.getPrimaryKey();
		Optional<T> find = secretGetAll().stream().filter(e -> id.equals(e.getPrimaryKey())).findAny();
		if (!find.isPresent()) {
			super.insert(t);
			PersistanceManager.saveDatabase();
		} else {
			throw new RuntimeException(this.getTableName() + ": " + " Record existed: " + t.getPrimaryKey());
		}
	}

	@Override
	public boolean delete(ID id) {
		Optional<T> find = secretGetAll().stream().filter(e -> id.equals(e.getPrimaryKey())).findAny();
		if (find.isPresent()) {
			secretGetAll().remove(find.get());
			return true;
		}
		return false;

	}

}
