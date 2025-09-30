package xyz.sm10.blogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.sm10.blogs.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    boolean existsByTitle(String title);
}
