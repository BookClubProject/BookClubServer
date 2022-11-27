package bookclub.bookclubspring.web;

import bookclub.bookclubspring.config.auth.LoginUser;
import bookclub.bookclubspring.config.auth.dto.SessionUser;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.service.posts.PostService;
import bookclub.bookclubspring.web.dto.PostsListResponseDto;
import bookclub.bookclubspring.web.dto.PostsResponseDto;
import bookclub.bookclubspring.web.dto.PostsSaveRequestDto;
import bookclub.bookclubspring.web.dto.PostsUpdateRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postService;

    /* CREATE */
    @PostMapping("/api/v1/posts")
    public ResponseEntity save(User user, @RequestBody PostsSaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {

        String writer = sessionUser.getName();
        return ResponseEntity.ok(postService.save(writer, requestDto));
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody
    PostsUpdateRequestDto requestDto) {

        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {

        return postService.findById(id);
    }

    @GetMapping("/api/v1/posts/read")
    public List<PostsListResponseDto> findAllDesc () {

        return postService.findAllDesc();
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postService.delete(id);
        return id;
    }

}
