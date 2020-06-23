package com.ramyunmoa.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	
	//스프링 시큐리티 룰
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	/*  이 메소드에는 요청 URI에 대한 권한 설정, 특정 기능 결과에 대한 Handler 등록,
		Custom Filter 등록(ex. AuthenticationFilter 재정의) 그리고
		예외 핸들러 등을 등록 하는 메소드이다. 가장중요 */
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN") //다중 ROLE은 어케?
								.antMatchers("/teacher/**").hasRole("TEACHER")
								.antMatchers("/student/**").hasRole("STUDENT")
								.antMatchers("/member/home").authenticated()//인증되면 아무나 이 디렉토리로;
								.and()
						.formLogin() //action 태그 대신
							.loginPage("/member/login") //get요청
							.loginProcessingUrl("/member/login") //post요청
							.defaultSuccessUrl("/index")//성공시 인덱스로~
							.and()
						.logout()
							.logoutUrl("/member/logout")
							.logoutSuccessUrl("/index")
							.invalidateHttpSession(true)
							.and()
						.csrf()
							.disable(); //csrf 사용안함
		
	}
    //AuthenticationManagerBuilder를 인자로 받는 configure 메소드는 인증을 담당할 프로바이더구현체를
	//설정하는 메소드이다. 현재는 Custom한 Provider를 직접구현하였지만
	//UserDetailsService 구현체와 PasswordEncoder 구현체만 설정하여서 기본
	//DaoAuthenticationProvider를 사용하게 할 수도 있다.
	// AuthenticationProvider는 여러개를 등록가능하다.
	//스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//권한정보, 계정정보
		// <input type="text" name="username"/ "password" 는 라이브러리와 약속된 이름
//		auth
//		.inMemoryAuthentication()
//		.withUser("newlec")
//			.password("{noop}111") //{noop} 텍스트 그대로 비밀번호로 인식하게 해준다
//			.roles("ADMIN")
//		.and()
//		.withUser("dragon")
//			.password("{noop}111")
//			.roles("TEACHER");
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)//데이터 소스를 어디서 가져올거냐?
			.usersByUsernameQuery("select uid id, pwd password, 1 enabled from Member where uid=?")
			.authoritiesByUsernameQuery("select uid id,'ROLE_ADMIN' roleId from Member where uid=?")
			.passwordEncoder(new BCryptPasswordEncoder());//암호화
			//사용자가 보내온 데이터를 가지고 처리를해야하는데, 테이블이나 쿼리문을 줘야 하지!
			//근데 컬럼명이 라이브러리는 password로 정해져있고 내꺼는 pwd 인뎅?? 별칭 주면 되지~
		//auth.jdbcAuthentication();
		//auth.ldapAuthentication();
//      auth.userDetailsService(userDetailsService)
//		.passwordEncoder(passwordEncoder);
	}




}
