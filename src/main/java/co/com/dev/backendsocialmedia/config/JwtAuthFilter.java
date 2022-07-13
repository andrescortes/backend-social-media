package co.com.dev.backendsocialmedia.config;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserAuthenticationProvider userAuthenticationProvider;

    public JwtAuthFilter(UserAuthenticationProvider userAuthenticationProvider) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, FilterChain filterChain)
        throws ServletException, IOException {
        String header = httpServletRequest.getHeader(AUTHORIZATION);

        if (header != null) {
            String[] authItems = header.split(" ");
            try {
                if (authItems.length == 2 && "Bearer".equals(authItems[0])) {
                    SecurityContextHolder.getContext().setAuthentication(
                        userAuthenticationProvider.validateToken(authItems[1]));
                }
            } catch (RuntimeException e) {
                SecurityContextHolder.clearContext();
                throw e;
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
