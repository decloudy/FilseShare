package com.zust.FileShare.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zust.FileShare.entity.Filetype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Filetype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Filetype
 * @author MyEclipse Persistence Tools
 */
public class FiletypeDao extends BaseHibernateDao {
	private static final Logger log = LoggerFactory.getLogger(FiletypeDao.class);
	// property constants
	public static final String TYPE_NAME = "typeName";

	public void save(Filetype transientInstance) {
		log.debug("saving Filetype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Filetype persistentInstance) {
		log.debug("deleting Filetype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Filetype findById(java.lang.Integer id) {
		log.debug("getting Filetype instance with id: " + id);
		try {
			Filetype instance = (Filetype) getSession().get("entity.Filetype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Filetype> findByExample(Filetype instance) {
		log.debug("finding Filetype instance by example");
		try {
			List<Filetype> results = (List<Filetype>) getSession().createCriteria("entity.Filetype")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Filetype instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Filetype as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Filetype> findByTypeName(Object typeName) {
		return findByProperty(TYPE_NAME, typeName);
	}

	public List findAll() {
		log.debug("finding all Filetype instances");
		try {
			String queryString = "from Filetype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Filetype merge(Filetype detachedInstance) {
		log.debug("merging Filetype instance");
		try {
			Filetype result = (Filetype) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Filetype instance) {
		log.debug("attaching dirty Filetype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Filetype instance) {
		log.debug("attaching clean Filetype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}