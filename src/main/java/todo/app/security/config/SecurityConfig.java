package  todo.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import todo.app.security.repository.UserListRepository;

/**
 * SpringSecurity設定クラス。
 * ログイン画面はデフォルトのものを使用
 * ログイン中じゃないと利用できない仕組みになっている
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin( login -> login
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/")
                )
                .authorizeHttpRequests(authz -> authz
                        .anyRequest()
                        .authenticated()
                );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(
            UserListRepository userListRepository) {

        return email -> userListRepository.selectByEmail(email)
                .map(user -> User.withUsername(user.email())
                        .password(user.password())
                        .roles("USER")
                        .build()
                )
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + email)
                );
    }
}