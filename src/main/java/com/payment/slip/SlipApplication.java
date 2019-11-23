package com.payment.slip;

import com.payment.slip.model.User;
import com.payment.slip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class SlipApplication implements CommandLineRunner {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(SlipApplication.class, args);
  }

  @Override
  public void run(String... args) {
    User user = new User();
    user.setFirstName("Martel");
    user.setLastName("Tester");
    user.setUsername("martel@gmail.com");
    user.setPassword(this.passwordEncoder.encode("maRteL"));

//    this.userRepository.save(user);
  }
}
