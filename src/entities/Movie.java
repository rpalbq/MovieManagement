package entities;

import java.util.List;
import java.util.stream.Collectors;

import entities.enums.Genre;

public class Movie{
	private Integer id;
	private String name;
	private String author;
	private String releaseYear;
	private Genre genre;
	
	public Movie(Integer id, String name, String author, String releaseYear, Genre genre) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.releaseYear = releaseYear;
		this.genre = genre;
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public void deleteID(int id,List<Movie> movieList) {
		Movie movieDel = movieList.stream().filter(movies -> movies.getId().equals(id)).findFirst().orElse(null);
		
		if(movieDel != null) {
			movieList.remove(movieDel);
			System.out.println("Movie with ID:"+id+" has been deleted.");
		} else {
			System.out.println("No movie with ID:"+id+" found.");
		}
	}
	
	public List<Movie> filterByGenre(Genre genre, List<Movie> movieList) {
		 return movieList.stream().filter(movies -> movies.getGenre().equals(genre)).collect(Collectors.toList());
	}
	
	public List<Movie> filterByGenreAndReleaseYear(Genre genre, String filterReleaseYear, List<Movie> movieList) {
		return movieList.stream().filter(movies -> movies.getGenre().equals(genre)&& movies.releaseYear.equals(filterReleaseYear)).collect(Collectors.toList());
	}
	
	@Override
	public String toString() {
		return "FILME\nID = " +id+"\nNAME = "+name+"\nAUTHOR = "+author+"\nRELEASE YEAR = "+releaseYear+"\nGENRE = "+genre;
	}
	
	
	
	
}
