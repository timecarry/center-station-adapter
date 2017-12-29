package com.atd.adapter.transactional.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gakj.core.transaction.Transaction;
import com.gakj.core.transaction.TransactionManager;

public class HibernateTransactionManager extends TransactionManager {

	private SessionFactory sessionFactory;

	private HibernateTransactionManager() {
	}

	private void init() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		sessionFactory.getCurrentSession();
	}

	private Session getSessionInternal() {
		if (sessionFactory == null || sessionFactory.isClosed()) {
			init();
		}
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Transaction beginTransactionInternal() {
		Session session = getSessionInternal();
		return new HibernateTransaction(session.beginTransaction());
	}

	@Override
	protected void closeInternal() {
		if (sessionFactory == null) {
			return;
		}
		sessionFactory.close();
		sessionFactory = null;
		INSTANCE = null;
	}

	private static HibernateTransactionManager INSTANCE;

	public synchronized static Session getSession() {
		return get().getSessionInternal();
	}

	public synchronized static HibernateTransactionManager get() {
		if (INSTANCE == null) {
			INSTANCE = new HibernateTransactionManager();
		}

		return INSTANCE;
	}
}
