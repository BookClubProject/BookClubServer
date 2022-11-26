package bookclub.bookclubspring.domain.review;
import bookclub.bookclubspring.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT p From Review p ORDER BY p.id DESC")
    List<Review> findAllDesc();
}
