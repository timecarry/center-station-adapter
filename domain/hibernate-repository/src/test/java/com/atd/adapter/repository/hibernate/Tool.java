package com.atd.adapter.repository.hibernate;

import java.util.List;

import org.junit.Assert;

import com.atd.adapter.transactional.hibernate.HibernateTransactionManager;
import com.gakj.core.transaction.Transaction;
import com.ya.core.domain.EntityRepository;
import com.ya.core.domain.async.AsyncEntity;

public class Tool {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static synchronized void clearRepository(EntityRepository... repositories) {
		for (EntityRepository repository : repositories) {
			Transaction beginTransaction = HibernateTransactionManager.get().beginTransaction();
			List<AsyncEntity> all = repository.getAll();
			for (AsyncEntity entity : all) {
				entity.remove();
			}
			all = repository.getAll();
			Assert.assertEquals(0, all.size());
			beginTransaction.commit();
		}
	}
}
