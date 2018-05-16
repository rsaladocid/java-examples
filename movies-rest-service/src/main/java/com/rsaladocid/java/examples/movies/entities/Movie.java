package com.rsaladocid.java.examples.movies.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {
	
	private static final long serialVersionUID = 4068932424433014516L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	@Column(name = "title", unique = false, nullable = false)
	private String title;
	
	@Column(name = "overview", columnDefinition = "longvarchar", unique = false, nullable = true)
	private String overview;
	
	@Column(name = "poster", unique = false, nullable = true)
	private String poster;
	
	@Column(name = "release_year", unique = false, nullable = true)
	private int releaseYear;
	
	@Column(name = "adult", unique = false, nullable = false)
	private boolean adult;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "movie_genre" , 
        joinColumns = { @JoinColumn(name = "movie_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
	private Set<Genre> genres;
	
	public Movie() {
		this(null);
	}
	
	public Movie(String title) {
		this.setTitle(title);
	}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

}
