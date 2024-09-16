package nextstep.helloworld.mvcconfig.ui;

import nextstep.helloworld.mvcconfig.domain.LoginMember;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessToken = request.getHeader("Authorization");
        if (accessToken == null) {
            throw new AuthorizationException();
        }
        // 파라미터에 값 설정
        LoginMember loginMember = new LoginMember(1L, "user@example.com", 26);
        request.setAttribute("loginMember", loginMember);

        return super.preHandle(request, response, handler);
    }
}
