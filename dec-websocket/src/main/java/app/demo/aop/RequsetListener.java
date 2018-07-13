package app.demo.aop;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * 监听器类:主要任务是用ServletRequest将我们的HttpSession携带过去
 * */
@Component
public class RequsetListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpSession httpSession = ((HttpServletRequest) servletRequestEvent.getServletRequest()).getSession();
        System.out.println("将所有request请求都携带上httpSession " + httpSession.getId());
    }
}
