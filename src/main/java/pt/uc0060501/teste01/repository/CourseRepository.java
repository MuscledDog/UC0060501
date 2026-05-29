package pt.uc0060501.teste01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.uc0060501.teste01.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
