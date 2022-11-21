package bookclub.bookclubspring.web;

import bookclub.bookclubspring.config.auth.LoginUser;
import bookclub.bookclubspring.config.auth.dto.SessionUser;
import bookclub.bookclubspring.service.posts.PostService;
import bookclub.bookclubspring.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostService postService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postService.findAllDesc());

        if(user != null){
            model.addAttribute("userName", user.getNickname());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){

        PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/posts/read/{id}")
    public String read(@PathVariable Long id, @LoginUser SessionUser user, Model model) {
        PostsResponseDto dto = postService.findById(id);

        if (user != null) {
            model.addAttribute("user", user.getNickname());

            /*게시글 작성자 본인인지 확인*/
            if (dto.getUserId().equals(user.getId())) {
                model.addAttribute("writer", true);
            }
        }
        model.addAttribute("posts", dto);

        return "posts/posts-read";
    }

}
