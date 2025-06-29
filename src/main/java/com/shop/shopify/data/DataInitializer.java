package com.shop.shopify.data;

import com.shop.shopify.model.Role;
import com.shop.shopify.model.User;
import com.shop.shopify.data.RoleRepository;
import com.shop.shopify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Transactional
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    Set<String> defaultRoles = Set.of("ROLE_ADMIN", "ROLE_USER");
    createDefaultRoleIfNotExists(defaultRoles); // ✅ roles first
    createDefaultUserIfNotExists();
    createDefaultAdminIfNotExists();
  }

  private void createDefaultRoleIfNotExists(Set<String> roles) {
    roles.stream()
        .filter(role -> roleRepository.findByName(role).isEmpty())
        .map(Role::new)
        .forEach(roleRepository::save);
  }

  private void createDefaultUserIfNotExists() {
    Role userRole = roleRepository.findByName("ROLE_USER")
        .orElseThrow(() -> new RuntimeException("ROLE_USER not found"));

    for (int i = 1; i <= 5; i++) {
      String defaultEmail = "sam" + i + "@email.com";
      if (userRepository.existsByEmail(defaultEmail))
        continue;

      User user = new User();
      user.setFirstName("The User");
      user.setLastName("User" + i);
      user.setEmail(defaultEmail);
      user.setPassword(passwordEncoder.encode("123456"));
      user.setRoles(Set.of(userRole));
      userRepository.save(user);
      System.out.println("Default user " + i + " created successfully.");
    }
  }

  private void createDefaultAdminIfNotExists() {
    Role adminRole = roleRepository.findByName("ROLE_ADMIN")
        .orElseThrow(() -> new RuntimeException("ROLE_ADMIN not found"));

    for (int i = 1; i <= 2; i++) {
      String defaultEmail = "admin" + i + "@email.com";
      if (userRepository.existsByEmail(defaultEmail))
        continue;

      User user = new User();
      user.setFirstName("Admin");
      user.setLastName("Admin" + i);
      user.setEmail(defaultEmail);
      user.setPassword(passwordEncoder.encode("123456"));
      user.setRoles(Set.of(adminRole));
      userRepository.save(user);
      System.out.println("Default admin " + i + " created successfully.");
    }
  }
}
