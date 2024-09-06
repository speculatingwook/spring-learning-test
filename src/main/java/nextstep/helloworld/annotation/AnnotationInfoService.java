package nextstep.helloworld.annotation;

import nextstep.helloworld.HelloController;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Arrays;

@Service
public class AnnotationInfoService {

    public String getControllerAnnotationInfo() {
        StringBuilder info = new StringBuilder();
        Class<?> clazz = HelloController.class;

        System.out.println(Arrays.toString(clazz.getAnnotations()));


        // 메소드 레벨 어노테이션 조회
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(GetMapping.class)) {
                GetMapping mapping = method.getAnnotation(GetMapping.class);
                info.append("Method '")
                        .append(method.getName())
                        .append("' is mapped to: ")
                        .append(Arrays.toString(mapping.value()))
                        .append("\n");
            }
        }

        return info.toString();

    }
}