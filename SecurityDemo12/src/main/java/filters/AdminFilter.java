package filters;

import ca.sait.securitydemo12.models.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Victor Nunez
 */
public class AdminFilter implements Filter {
/**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        User user = (User) session.getAttribute("user");
        
        
        
        //Check if user is an admin or not
            //if admin:
            // chain.doFilter(request,response);
            
            //if not admin:
            //httpResponse.sendRedirect("/notes");
            
        
        if (user.getRole().getRoleId() == 1) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect("/notes");
        }
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {

    }
}