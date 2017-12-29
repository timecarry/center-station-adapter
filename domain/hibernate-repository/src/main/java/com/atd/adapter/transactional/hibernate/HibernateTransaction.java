package com.atd.adapter.transactional.hibernate;

import com.gakj.core.transaction.Transaction;

class HibernateTransaction implements Transaction {

	private final org.hibernate.Transaction transaction;
	
	public HibernateTransaction(org.hibernate.Transaction transaction) {
		super();
		this.transaction = transaction;
	}

	public void commit() {
		transaction.commit();

	}

	public void rollback() {
		transaction.rollback();
	}

}
