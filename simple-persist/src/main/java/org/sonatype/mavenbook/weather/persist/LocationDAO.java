package org.sonatype.mavenbook.weather.persist;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.sonatype.mavenbook.weather.model.Location;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LocationDAO extends HibernateDaoSupport {

	 public Location findByZip(final String zip) {
	    	return (Location) getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) {
					Query query = getSession().getNamedQuery("Location.uniqueByZip");
					query.setString("zip", zip);
					return (Location) query.uniqueResult();
				}
			});
	    }
	    
	    @SuppressWarnings("unchecked")
		public List<Location> all() {
	    	return new ArrayList<Location>( getHibernateTemplate().loadAll(Location.class) );
	    }

}
