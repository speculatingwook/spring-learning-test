package nextstep.helloworld.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationInfoController {

    private final AnnotationInfoService annotationInfoService;

    @Autowired
    public AnnotationInfoController(AnnotationInfoService annotationInfoService) {
        this.annotationInfoService = annotationInfoService;
    }

    @GetMapping("/annotation-info")
    public String getAnnotationInfo() {
        return annotationInfoService.getControllerAnnotationInfo();
    }

    @GetMapping("/annotation-info-2")
    public String getAnnotationInfo2() {
        return annotationInfoService.getControllerAnnotationInfo();
    }
}