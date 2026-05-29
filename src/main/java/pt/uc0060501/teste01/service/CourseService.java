package pt.uc0060501.teste01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import pt.uc0060501.teste01.exception.ResourceNotFoundException;
import pt.uc0060501.teste01.model.Course;
import pt.uc0060501.teste01.repository.CourseRepository;

@Service
@Validated
public class CourseService {
        

    private final CourseRepository repository;

    public CourseService (CourseRepository repository){
        
        this.repository = repository;
    }

    /*** FIND ALL  é 1 dos métodos GET */
    public List<Course> findAll(){
        return repository.findAll();
    };

    /**FIND ById é 1 dos métodos GET */

    public Course findById(@NonNull Long id){
        Course course = repository.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Course Not Found With ID PAULA:" +id));

        return course;
    }
    /**Crete Course */
    public Course createdCourse(@NonNull Course course) {
        return this.repository.save(course);
    }

    /** Delete Course */
    public void deleteCourse(@NonNull @Positive Long id) {
        this.repository.findById(id).map(result -> {
            this.repository.deleteById(id);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Course já apagado ou inexistente no Teste01" +id));
    }

    
}