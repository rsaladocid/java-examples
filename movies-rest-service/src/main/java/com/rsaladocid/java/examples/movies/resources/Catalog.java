package com.rsaladocid.java.examples.movies.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.rsaladocid.java.examples.movies.entities.Genre;
import com.rsaladocid.java.examples.movies.entities.Movie;

@Path("catalog")
public class Catalog {

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovies(@QueryParam("t") String title) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		List<Movie> movies = new ArrayList<Movie>();
		if (title == null) {
			movies = session.createQuery("from Movie").list();
		} else {
			Query<Movie> query = session.createQuery("from Movie where title LIKE :search");
			query.setParameter("search", "%" + title + "%");
			movies = query.list();
		}
		
		session.getTransaction().commit();
		
        return movies;
    }

    @GET
    @Path("/adult")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAdultMovies(@QueryParam("t") String title) {
		List<Movie> movies = getMovies(title);
		
		List<Movie> adultMovies = new ArrayList<Movie>();
		for (Movie movie : movies) {
			if (movie.isAdult()) {
				adultMovies.add(movie);
			}
		}
		
        return adultMovies;
    }

    @GET
    @Path("/genres")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Genre> getAllGenres() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Genre> genres = session.createQuery("from Genre").list();
		
		session.getTransaction().commit();
		
        return genres;
    }

    @GET
    @Path("/genres/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Set<Movie> getMoviesByGenre(@PathParam("id") String id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		Genre genre = session.get(Genre.class, Long.parseLong(id));
		Set<Movie> movies = genre.getMovies();
		
		session.getTransaction().commit();
		
        return movies;
    }
    
}
