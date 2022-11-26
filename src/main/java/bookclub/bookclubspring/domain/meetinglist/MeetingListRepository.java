package bookclub.bookclubspring.domain.meetinglist;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeetingListRepository extends JpaRepository<MeetingList, Long> {
    @Query("SELECT p From MeetingList p ORDER BY p.id DESC")
    List<MeetingList> findAllDesc();
}
