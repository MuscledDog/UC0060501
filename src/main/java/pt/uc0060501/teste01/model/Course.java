package pt.uc0060501.teste01.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import pt.uc0060501.teste01.enums.Category;
import pt.uc0060501.teste01.enums.Status;


@Data
@Entity
@SQLDelete(sql ="UPDATE course SET status = 1 WHERE id = ?")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @JsonProperty("_id")
    
    private Long id;

    @Length(min = 2, max = 100)
    @Nonnull
    @NotBlank
    @Column(length = 100, nullable = false)
    private String name;
    
    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(length = 10, nullable = false)
    private Status status = Status.ACTIVE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
    private List<Lesson> lessons = new ArrayList<>();
}
