package com.bontour.app.service;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.bontour.app.model.User;

public class MyUserDetails implements UserDetails{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String userName;
  private String password;
  
  public MyUserDetails(User user) {
      this.userName = user.getUserName();
      this.password = user.getPassword();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
     return userName;
  }

  @Override
  public boolean isAccountNonExpired() {
     return true;
  }

  @Override
  public boolean isAccountNonLocked() {
      return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }  

}
