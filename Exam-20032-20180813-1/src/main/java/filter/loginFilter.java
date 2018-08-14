package filter;



import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.SplittableRandom;

/**
 * @ Author: xin
 * @ Date: 2018/8/13 14:37
 */
public class loginFilter implements Filter {

    private String passUrl="";

    @Override
    public void init(FilterConfig filterConfig) {
        passUrl=filterConfig.getInitParameter("passUrl");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String[] s=passUrl.split(",");
        StringBuffer u=((HttpServletRequest)servletRequest).getRequestURL();
        for (String url:s){
            if(url.equals("")){
                continue;
            }
            if((u.indexOf(url)>=0)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        if (servletRequest.getParameter("user")==null||servletRequest.getParameter("user").equals("")){
            servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest,servletResponse);
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
