package com.Jayesh.Security_Service.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Jayesh.Security_Service.service.JWTService;
import com.Jayesh.Security_Service.service.MyUserSerivees;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private MyUserSerivees userSerivees;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Username=null;
		String token=null;
		String Autoheader=request.getHeader("Authorization");
		if(Autoheader!=null && Autoheader.startsWith("Bearer ")) {
			token=Autoheader.substring(7);
			Username=jwtService.ExtractUsername(token);
		}
		if(Username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails=userSerivees.loadUserByUsername(Username);
			if(jwtService.istokenvalied(token, userDetails)) {
				UsernamePasswordAuthenticationToken autToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				autToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(autToken);
			}
		}
		filterChain.doFilter(request, response);
		
	}	
}
