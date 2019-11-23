package com.payment.slip.serviceimpl;

import com.payment.slip.repository.UserRepository;
import com.payment.slip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    return this.userRepository.findByUsername(username);
  }
}
