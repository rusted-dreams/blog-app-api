package xyz.sm10.blogs.entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name= "authorId", nullable = false)
    private User author;
    private Boolean isPublished;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    private LocalDate createdAt;
}
