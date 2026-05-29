package pt.uc0060501.teste01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import pt.uc0060501.teste01.enums.Category;
import pt.uc0060501.teste01.model.Course;
import pt.uc0060501.teste01.model.Lesson;
import pt.uc0060501.teste01.repository.CourseRepository;

@SpringBootApplication
public class EscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		
		return args ->{
			//courseRepository.deleteAll();
			for(int i = 0; i< 10; i++){
				// a criar o objeto Course
				Course course = new Course();
				course.setName("Praticar Teste01" +i);
				course.setCategory(Category.BACKEND);

				//a criar 1º objeto Lesson
				Lesson lesson = new Lesson();
				lesson.setName("Voltar a praticar Teste01 e depois outra vez" +i);
				lesson.setYoutubeUrl("https://www.youtube.com/watch?v=U_AInbY9kvk");
				// a adicionar uma lesson no objeto course
				course.getLessons().add(lesson);

				//a criar 2º objeto Lesson
				Lesson lesson2 = new Lesson();
				lesson2.setName("Praticar, praticar, praticar! Manter o foco no objetivo!" +i);
				lesson2.setYoutubeUrl("https://www.youtube.com/watch?v=U_AInbY9kvk");
				// a adicionar uma lesson no objeto course
				course.getLessons().add(lesson2);

				courseRepository.save(course);

			}//fim do for

		};



	}
}
