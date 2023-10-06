package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Movie;
import entities.enums.Genre;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isContinue = true;
		Genre genre = null;
		List<Movie> movieList = new ArrayList<>();
		
		do {
			System.out.println("----------------------------------------------------");
			System.out.println("                    FILM MENU                       ");
			System.out.println("----------------------------------------------------");
			System.out.println("1 - REGISTER MOVIE");
			System.out.println("2 - REMOVE MOVIE");
			System.out.println("3 - LIST ALL MOVIES");
			System.out.println("4 - FILTER MOVIES");
			System.out.println("5 - EXIT");
			System.out.println();
			
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Insert the movie's ID: ");
				Integer id = sc.nextInt();
				System.out.println("Insert the movie's name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Insert the movie's author: ");
				String author = sc.nextLine();
				System.out.println("Insert the movie's release year: ");
				String releaseYear = sc.next();
				System.out.println("Insert the movie's genre: ");
				System.out.println("1 - Action");
				System.out.println("2 - Horror");
				System.out.println("3 - Comedy");
				System.out.println("4 - Romance");
				System.out.println("5 - Science Fiction");
				System.out.println("6 - Animation");
				System.out.println("7 - Documentary");
				System.out.println("8 - Musical");
				System.out.println("9 - Thriller");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					genre = Genre.ACTION;
					break;
				case 2:
					genre = Genre.HORROR;
					break;
				case 3:
					genre = Genre.COMEDY;
					break;
				case 4:
					genre = Genre.ROMANCE;
					break;
				case 5: 
					genre = Genre.SCIENCE_FICTION;
					break;
				case 6:
					genre = Genre.ANIMATION;
					break;
				case 7:
					genre = Genre.DOCUMENTARY;
					break;
				case 8: 
					genre = Genre.MUSICAL;
					break;
				case 9:
					genre = Genre.THRILLER;
					break;
				default:
					System.out.println("INVALID NUMBER");
					break;
				}
				Movie movie = new Movie(id,name,author, releaseYear,genre);
				movieList.add(movie);
				break;
			case 2:
				System.out.println("Please, insert the movie's ID you want to delete:");
				int removeId = sc.nextInt();
				movieList.get(0).deleteID(removeId, movieList);
				break;
			case 3: 
				for(Movie movies: movieList) {
					System.out.println(movies);
					System.out.println("---------------------------------------------------");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("FILTER BY:");
				System.out.println("1 - GENRE");
				System.out.println("2 - GENRE AND RELEASE YEAR");
				choice = sc.nextInt();
				if(choice == 1) {
					System.out.println("Choose the genre you want to filter.");
					System.out.println("1 - Action");
					System.out.println("2 - Horror");
					System.out.println("3 - Comedy");
					System.out.println("4 - Romance");
					System.out.println("5 - Science Fiction");
					System.out.println("6 - Animation");
					System.out.println("7 - Documentary");
					System.out.println("8 - Musical");
					System.out.println("9 - Thriller");
					choice = sc.nextInt();
					switch(choice) {
					case 1:
						genre = Genre.ACTION;
						break;
					case 2:
						genre = Genre.HORROR;
						break;
					case 3:
						genre = Genre.COMEDY;
						break;
					case 4:
						genre = Genre.ROMANCE;
						break;
					case 5: 
						genre = Genre.SCIENCE_FICTION;
						break;
					case 6:
						genre = Genre.ANIMATION;
						break;
					case 7:
						genre = Genre.DOCUMENTARY;
						break;
					case 8: 
						genre = Genre.MUSICAL;
						break;
					case 9:
						genre = Genre.THRILLER;
						break;
					default:
						System.out.println("INVALID NUMBER");
						break;
					}
					List<Movie> filterByGenre = movieList.get(0).filterByGenre(genre, movieList);
					for(Movie movieByGenre: filterByGenre) {
						System.out.println(movieByGenre);
						System.out.println("-----------------");
						System.out.println();
					}
					break;	
				} else if(choice == 2) {
					System.out.println("Choose the genre you want to filter.");
					System.out.println("1 - Action");
					System.out.println("2 - Horror");
					System.out.println("3 - Comedy");
					System.out.println("4 - Romance");
					System.out.println("5 - Science Fiction");
					System.out.println("6 - Animation");
					System.out.println("7 - Documentary");
					System.out.println("8 - Musical");
					System.out.println("9 - Thriller");
					choice = sc.nextInt();
					switch(choice) {
					case 1:
						genre = Genre.ACTION;
						break;
					case 2:
						genre = Genre.HORROR;
						break;
					case 3:
						genre = Genre.COMEDY;
						break;
					case 4:
						genre = Genre.ROMANCE;
						break;
					case 5: 
						genre = Genre.SCIENCE_FICTION;
						break;
					case 6:
						genre = Genre.ANIMATION;
						break;
					case 7:
						genre = Genre.DOCUMENTARY;
						break;
					case 8: 
						genre = Genre.MUSICAL;
						break;
					case 9:
						genre = Genre.THRILLER;
						break;
					default:
						System.out.println("INVALID NUMBER");
						break;
				}
					System.out.println("Insert movie's release year:");
					String filterReleaseYear = sc.next();
					List<Movie> filterByGenreAndReleaseYear = movieList.get(0).filterByGenreAndReleaseYear(genre, filterReleaseYear, movieList);
					for(Movie movieFiltered: filterByGenreAndReleaseYear) {
						System.out.println(movieFiltered);
						System.out.println("---------------------------");
						System.out.println();
					}
				} else {
					System.out.println("Sorry, the selected option is not valid.");
				}
				break;
			case 5:
				isContinue = false;
			}
			
		}while(isContinue);
		
		sc.close();
	}

}
