package com.payment.slip.controller;

import com.payment.slip.security.jwt.JwtRequest;
import com.payment.slip.security.jwt.JwtResponse;
import com.payment.slip.security.jwt.JwtTokenUtil;
import com.payment.slip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final UserService userService;

  @PostMapping
  public JwtResponse createAuthToken(@RequestBody JwtRequest authRequest) throws Exception {
    authenticate(authRequest.getUsername(), authRequest.getPassword());

    final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);

    return new JwtResponse(token);
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
