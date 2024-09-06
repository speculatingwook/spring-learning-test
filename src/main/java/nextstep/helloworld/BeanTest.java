package nextstep.helloworld;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class BeanTest {

    @Autowired
    ApplicationContext ac;

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        // 1. 조회: 호출할 때 마다 객체를 생성
        HelloDao userDao1 = ac.getBean("userDao", UserDao.class);

        // 2. 조회: 호출할 때 마다 객체를 생성
        HelloDao userDao2 = ac.getBean("userDao", UserDao.class);

        // 참조값이 다른 것을 확인
        System.out.println("useDao1 = " + userDao1);
        System.out.println("useDao2 = " + userDao2);

        assertThat(userDao1).isSameAs(userDao2);
    }
}