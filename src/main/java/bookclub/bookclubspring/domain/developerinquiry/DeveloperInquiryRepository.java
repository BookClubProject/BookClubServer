package bookclub.bookclubspring.domain.developerinquiry;

import bookclub.bookclubspring.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Column;
import java.util.List;

public interface DeveloperInquiryRepository extends JpaRepository<DeveloperInquiry, Long> {

    @Query("SELECT p From DeveloperInquiry p ORDER BY p.id DESC")
    List<DeveloperInquiry> findAllDesc();
}
