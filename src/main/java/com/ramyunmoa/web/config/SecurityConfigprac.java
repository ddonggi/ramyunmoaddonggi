//
//package com.ramyunmoa.web.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigprac extends WebSecurityConfigurerAdapter{
//	
//	private AuthenticationProvider authenticationProvider;
////  private UserDetailsService userDetailsService;
////  private PasswordEncoder passwordEncoder;
//
//	
//	public SecurityConfigprac(/*UserDetailsService userDetailsService, 
//            PasswordEncoder passwordEncoder*/
//			AuthenticationProvider authenticationProvider) {
////      this.userDetailsService = userDetailsService;
////      this.passwordEncoder = passwordEncoder;
//		this.authenticationProvider = authenticationProvider;
//	}
//	
//    //AuthenticationManagerBuilder를 인자로 받는 configure 메소드는 인증을 담당할 프로바이더구현체를
//	//설정하는 메소드이다. 현재는 Custom한 Provider를 직접구현하였지만
//	//UserDetailsService 구현체와 PasswordEncoder 구현체만 설정하여서 기본
//	//DaoAuthenticationProvider를 사용하게 할 수도 있다.
//	// AuthenticationProvider는 여러개를 등록가능하다.
//	//스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//권한정보, 계정정보
//		auth.authenticationProvider(authenticationProvider);
////      auth.userDetailsService(userDetailsService)
////		.passwordEncoder(passwordEncoder);
//	}
//
//	
//	//스프링 시큐리티 룰
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	/*  이 메소드에는 요청 URI에 대한 권한 설정, 특정 기능 결과에 대한 Handler 등록,
//		Custom Filter 등록(ex. AuthenticationFilter 재정의) 그리고
//		예외 핸들러 등을 등록 하는 메소드이다. 가장중요 */
//		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//								.antMatchers("/teacher/**").hasRole("TEACHER")
//								.antMatchers("/student/**").hasRole("STUDENT")
//								.antMatchers("/member/home").authenticated();//인증되면 아무나 요 디렉토리로;
//		
//		
//	}
//	
//	// 스프링 시큐리티 룰을 무시하게 하는 url 규칙.
//   @Override
//   public void configure(WebSecurity web) throws Exception {
//       web.ignoring()
//           .antMatchers("/resources/**")
//           .antMatchers("/css/**")
//           .antMatchers("/vendor/**")
//           .antMatchers("/js/**")
//           .antMatchers("/favicon*/**")
//           .antMatchers("/img/**")
//       ;
//   }
////   @Bean
////   public AuthenticationSuccessHandler authenticationSuccessHandler() {
////       CustomAuthenticationSuccessHandler successHandler = new CustomAuthenticationSuccessHandler();
////       successHandler.setDefaultTargetUrl("/index");
////       return successHandler;
////   }
//
//
//
//}
//
//
