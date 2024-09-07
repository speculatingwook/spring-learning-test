package nextstep.helloworld.mvc.mapping;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/param-header/message")
public class ParamHeaderController {

//    @GetMapping
//    public ResponseEntity<String> message() {
//        return ResponseEntity.ok().body("message");
//    }

    /**
     *
     * @param name value = name, required = false(기본 값은 true, 만약 파라미터를 받는 것이 정해지지 않았다면 false 지정해줘야 함)
     * @param header header도 마찬가지
     * @return
     */
    @GetMapping
    public ResponseEntity<String> messageForParam(@RequestParam(value = "name", required = false) String name,
                                                  @RequestHeader(value = "HEADER", required = false) String header) {
        if(header != null) {
            return ResponseEntity.ok().body(header);
        }

        if(name==null && header==null) {
            return ResponseEntity.ok().body("message");
        }

        return ResponseEntity.ok().body(name);
    }
//
//    @GetMapping
//    public ResponseEntity<String> messageForHeader(@RequestHeader(value = "HEADER") String header) {
//        return ResponseEntity.ok().body(header);
//    }
}