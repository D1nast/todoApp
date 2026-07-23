package  todo.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;


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
    UserDetailsService userDetailsService(PasswordEncoder encoder) {
        String password = encoder.encode("password");
        UserDetails user = User.withUsername("user").password(password).build();
        return new InMemoryUserDetailsManager(user);
    }
}