package nextstep.helloworld.mvc.mapping;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/param-header")
public class ParamHeaderController {
    @GetMapping("/message")
    public ResponseEntity<String> message() {
        return ResponseEntity.ok("message");
    }

    /**
     *
     * @param name value = name, required = false(기본 값은 true, 만약 파라미터를 받는 것이 정해지지 않았다면 false 지정해줘야 함)
     * @return
     */
    @GetMapping(value = "/message", params = "name")
    public ResponseEntity<String> messageForParam(@RequestParam("name") String name) {
        return ResponseEntity.ok(name);
    }

    @GetMapping(value = "/message", headers = "HEADER")
    public ResponseEntity<String> messageForHeader(@RequestHeader("HEADER") String header) {
        return ResponseEntity.ok(header);
    }

}