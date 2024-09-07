package nextstep.helloworld.mvc.mapping;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uri-pattern")
public class UriPatternController {

    @GetMapping("/users/{id}")
    public ResponseEntity<User> pathVariable(@PathVariable Long id) {
        User user = new User(id, "이름", "email");
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/patterns/{alphabet:[a-z]}")
    public ResponseEntity<String> pattern(@PathVariable String alphabet) {
        return ResponseEntity.ok(alphabet);
    }

    @GetMapping("/patterns/**")
    public ResponseEntity<String> patternStars() {
        return ResponseEntity.ok("pattern-multi");
    }
}