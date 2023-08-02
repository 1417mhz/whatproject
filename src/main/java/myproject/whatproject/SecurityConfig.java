package myproject.whatproject;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder pwEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/user/my-page",
                             "/user/pw-change",
                             "/product/register",
                             "/order/new",
                             "/order/list").authenticated()
                .antMatchers("/user/list",
                             "/seller/list",
                             "/order/list/all").hasRole("ADMIN")
                .anyRequest().permitAll();


        // login 설정
        http
                .formLogin()
                .loginPage("/user/login") // GET 요청 (login form을 보여줌)
                .loginProcessingUrl("/user/login") // POST 요청 (login 창에 입력한 데이터를 처리)
                .usernameParameter("userId") // login에 필요한 id 값을 userId로 설정
                .passwordParameter("userPw") // login에 필요한 password 값을 userPw로 설정
                .defaultSuccessUrl("/"); // login에 성공하면 /로 redirect
//                .failureHandler(new loginFailureHandler());

        // logout 설정
        http
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/");	// logout에 성공하면 /로 redirect

        return http.build();
    }
}
