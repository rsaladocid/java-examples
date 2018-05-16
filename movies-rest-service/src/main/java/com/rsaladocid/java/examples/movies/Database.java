package com.rsaladocid.java.examples.movies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rsaladocid.java.examples.movies.entities.Genre;
import com.rsaladocid.java.examples.movies.entities.Movie;

public class Database {
	
	
	public static void init() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		for (Movie movie : records()) {
			session.saveOrUpdate(movie);
		}
		
		session.getTransaction().commit();
	}
	
	public static List<Movie> records() {
		Genre drama = new Genre("drama");
		Genre crimen = new Genre("crimen");
		Genre aventura = new Genre("aventura");
		Genre cienciaFiccion = new Genre("ciencia ficción");
		Genre terror = new Genre("terror");
		Genre suspense = new Genre("suspense");
		Genre animacion = new Genre("animación");
		Genre comedia = new Genre("comedia");
		Genre familia = new Genre("familia");
		Genre romance = new Genre("romance");
		Genre accion = new Genre("acción");
		Genre fantasia = new Genre("fantasía");
		
		Movie movie1 = new Movie("El padrino");
		movie1.setAdult(false);
		movie1.setOverview("Don Vito Corleone, conocido dentro de los círculos del hampa como \"El Padrino\", es el patriarca de una de las cinco familias que ejercen el mando de la Cosa Nostra en Nueva York en los años 40. Don Corleone tiene cuatro hijos; una chica, Connie, y tres varones, Sonny, Michael y Freddie, al que envían exiliado a Las Vegas, dada su incapacidad para asumir puestos de mando en la \"Familia\". Cuando el Padrino reclina intervenir en el negocio de estupefacientes, empieza una cruenta lucha de violentos episodios entre las distintas familias del crimen organizado.");
		movie1.setPoster("https://image.tmdb.org/t/p/w600_and_h900_bestv2/dfEQMuZMIcPgC7nt07D9uVQi7Tv.jpg");
		movie1.setReleaseYear(1972);
		movie1.setGenres(new HashSet<Genre>(Arrays.asList(drama, crimen)));
		
		Movie movie2 = new Movie("Interstellar");
		movie2.setAdult(false);
		movie2.setOverview("Narra las aventuras de un grupo de exploradores que hacen uso de un agujero de gusano recientemente descubierto para superar las limitaciones de los viajes espaciales tripulados y vencer las inmensas distancias que tiene un viaje interestelar.");
		movie2.setPoster("https://image.tmdb.org/t/p/w600_and_h900_bestv2/7C0oiPn46OvaMxET9iq1f5BsyMS.jpg");
		movie2.setReleaseYear(2014);
		movie2.setGenres(new HashSet<Genre>(Arrays.asList(aventura, drama, cienciaFiccion)));

		Movie movie3 = new Movie("El exorcista");
		movie3.setAdult(true);
		movie3.setOverview("Adaptación de la novela de William Peter Blatty. Inspirada en un exorcismo real ocurrido en Washington en 1949. Regan es una niña de doce años víctima de fenómenos paranormales como la levitación o la manifestación de una fuerza sobrehumana. Su madre, aterrorizada, tras someter a su hija a múltiples análisis médicos que no ofrecen ningún resultado, acude a un sacerdote con estudios de psiquiatría. Éste está convencido de que el mal no es físico sino espiritual, es decir, que la niña es víctima de una posesión diabólica. Por eso, con la ayuda de otro sacerdote decide practicar un exorcismo. Seguramente la película de terror más popular de todos los tiempos. En el año 2000 se reestrenó un \"montaje del director\" (director's cut) acompañado de una gran campaña publicitaria que hacía hincapié en la inclusión de algunas escenas que no aparecían en la versión original.");
		movie3.setPoster("https://image.tmdb.org/t/p/w600_and_h900_bestv2/tx38RNHRQPfSX8n72LE1GBkGcDE.jpg");
		movie3.setReleaseYear(1973);
		movie3.setGenres(new HashSet<Genre>(Arrays.asList(drama, terror, suspense)));
		
		Movie movie4 = new Movie("Coco");
		movie4.setAdult(false);
		movie4.setOverview("Miguel es un joven con el sueño de convertirse en leyenda de la música a pesar de la prohibición de su familia. Su pasión le llevará a adentrarse en la \"Tierra de los Muertos\" para conocer su verdadero legado familiar.");
		movie4.setPoster("https://image.tmdb.org/t/p/w600_and_h900_bestv2/oburjHqzOrTtDLYbLunKLwUHhk1.jpg");
		movie4.setReleaseYear(2017);
		movie4.setGenres(new HashSet<Genre>(Arrays.asList(aventura, animacion, comedia, familia)));
		
		Movie movie5 = new Movie("Titanic");
		movie5.setAdult(false);
		movie5.setOverview("Durante las labores de recuperación de los restos del famoso trasatlántico Titanic, una anciana norteamericana se pone en contacto con la expedición para acudir a una plataforma flotante instalada en el Mar del Norte y asistir in situ a la recuperación de sus recuerdos. A través de su memoria reviviremos los acontecimientos que marcaron el siniestro más famoso del siglo XX: el hundimiento del trasatlántico más lujoso del mundo, la máquina más sofisticada de su tiempo, considerada «insumergible», que sucumbió a las heladas aguas del Atlántico en abril de 1912, llevándose consigo la vida de 1.500 personas, más de la mitad del pasaje. En los recueros de la anciana hay cabida para algo más que la tragedia, la historia de amor que vivió con un joven pasajero de tercera clase, un pintor aficionado que había ganado su pasaje al ganar a las cartas en una taberna de Southampton.");
		movie5.setPoster("https://image.tmdb.org/t/p/w600_and_h900_bestv2/ibo87POwUFo0O0yqZSrESuOLIpR.jpg");
		movie5.setReleaseYear(1997);
		movie5.setGenres(new HashSet<Genre>(Arrays.asList(drama, romance, suspense)));
		
		Movie movie6 = new Movie("Avatar");
		movie6.setAdult(false);
		movie6.setOverview("Jake Sully, un ex-marine confinado a una silla de ruedas, es reclutado para viajar al planeta Pandora, donde un consorcio corporativo está extrayendo un mineral que será clave en la solución de la crisis energética de la Tierra. Debido a que la atmósfera de Pandora es tóxica, han creado el Programa Avatar, en el que 'conductores' humanos tienen sus conciencias unidas a un avatar,... un cuerpo biológico controlado de manera remota que puede sobrevivir en ese entorno. Estos avatares han sido creados genéticamente como híbridos combinando ADN humano con el de los nativos de Pandora… los Na’vi. Convertido en un avatar, Jake puede volver a caminar. Se le asigna la misión de infiltrarse entre los Na’vi, que se han convertido en un obstáculo importante para la extracción del preciado mineral. Pero Neytiri, una hermosa mujer Na’vi, le salvará la vida, y esto lo cambiará todo...");
		movie6.setPoster("https://image.tmdb.org/t/p/w600_and_h900_bestv2/zyZlzS9klLzdiOxGl8vjIJ4oJ8a.jpg");
		movie6.setReleaseYear(2009);
		movie6.setGenres(new HashSet<Genre>(Arrays.asList(accion, aventura, fantasia, cienciaFiccion)));

		return new ArrayList<Movie>(Arrays.asList(movie1, movie2, movie3, movie4, movie5));
	}

}
