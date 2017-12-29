package com.atd.adapter.domain.repository.hibernate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.atd.adapter.transactional.hibernate.HibernateTransactionManager;
import com.ya.core.domain.BaseEntityRepository;
import com.ya.core.domain.Entity;
import com.ya.waterleaks.infrastructure.tooling.Validate;

public class BaseHibernateEntityRepository<E extends Entity> extends BaseEntityRepository<E> {

	private final Class<E> entityClazz;

	protected final Session getSession() {
		return HibernateTransactionManager.getSession();
	}

	protected BaseHibernateEntityRepository(Class<E> clazz) {
		super(clazz);
		this.entityClazz = clazz;
	}

	protected final Class<E> getEntityClazz() {
		return entityClazz;
	}

	public final E findById(String id) {
		Validate.notNull(id);
		return getSession().get(getEntityClazz(), id);
	}

	public final List<E> getAll() {
		Query<E> createQuery = getSession().createQuery("select a from " + getEntityClazz().getSimpleName() + " a",
				getEntityClazz());
		List<E> result = new ArrayList<E>(createQuery.list());
		return Collections.unmodifiableList(result);
	}

	public final void remove(E entity) {
		Validate.notNull(entity);
		getSession().remove(entity);
	}

	public final void store(E entity) {
		Validate.notNull(entity);
		getSession().save(entity);
	}

}
