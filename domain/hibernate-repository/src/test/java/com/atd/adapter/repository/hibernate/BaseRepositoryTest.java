package com.atd.adapter.repository.hibernate;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atd.adapter.domain.repository.hibernate.HibernateRepository;
import com.atd.adapter.transactional.hibernate.HibernateTransactionManager;
import com.gakj.core.transaction.Transaction;
import com.gakj.core.transaction.TransactionManager;
import com.ya.core.domain.Domain;
import com.ya.core.domain.EntityRepository;

public abstract class BaseRepositoryTest {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseRepositoryTest.class);

	private Transaction transaction;

	public Transaction getTransaction() {
		return transaction;
	}

	public void beginTransaction() {
		
		transaction=TransactionManager.get().beginTransaction();
	}

	@BeforeClass
	public static void beforeClass() {
		Domain.clearRepositoryRegistrations();
		HibernateRepository.initAll();
		clearRepositories();
		Domain.clearRepositoryRegistrations();
	}

	@Before
	public void beforeTest() {
		Domain.clearRepositoryRegistrations();
		HibernateRepository.initAll();
		clearRepositories();
		LOGGER.info("Before Test.");
		this.transaction = HibernateTransactionManager.get().beginTransaction();
	}

	@After
	public void afterTest() {
		LOGGER.info("After Test");
		this.transaction.commit();
		Domain.clearRepositoryRegistrations();
		clearRepositories();
		Domain.clearRepositoryRegistrations();
	}

	@AfterClass
	public static void afterClass() {
		clearRepositories();
		HibernateTransactionManager.clear();
		Domain.clearRepositoryRegistrations();
	}

	private static void clearRepositories() {
		List<EntityRepository<?>> allRepositories = Domain.getCore().getAllRepositories();
		for (EntityRepository<?> entityRepository : allRepositories) {
			Tool.clearRepository(entityRepository);
		}
	}
}
