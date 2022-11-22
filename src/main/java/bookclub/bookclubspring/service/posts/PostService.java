package bookclub.bookclubspring.service.posts;

import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.posts.PostsRepository;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.domain.user.UserRepository;
import bookclub.bookclubspring.web.dto.PostsListResponseDto;
import bookclub.bookclubspring.web.dto.PostsResponseDto;
import bookclub.bookclubspring.web.dto.PostsSaveRequestDto;
import bookclub.bookclubspring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(String name, PostsSaveRequestDto requestDto) {
        User user = userRepository.findByName(name);
        requestDto.setUser(user);

        Posts posts = requestDto.toEntity();
        postsRepository.save(posts);

        return posts.getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        posts.update(requestDto.getYear(), requestDto.getMonth(), requestDto.getDate(), requestDto.getDate(), requestDto.getTime(), requestDto.getState(), requestDto.getLocation(), requestDto.getDetailLocation(), requestDto.getTheme(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

        postsRepository.delete(posts);
    }

}
