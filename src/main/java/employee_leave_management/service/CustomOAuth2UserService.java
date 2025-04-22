package employee_leave_management.service;

import employee_leave_management.entity.CustomOAuth2User;
import employee_leave_management.entity.Role;
import employee_leave_management.entity.User;
import employee_leave_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDateTime;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = super.loadUser(userRequest);

        String email = oauth2User.getAttribute("email");
        String name = oauth2User.getAttribute("name");

        Role role = email.equalsIgnoreCase("bintang.mada@gmail.com") ? Role.SUPER_ADMIN : Role.EMPLOYEE;

        // Simpan ke database kalau user belum ada
        User user = userRepository.findByEmail(email).orElseGet(() -> {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setRole(role); // default role
            newUser.setCreatedAt(LocalDateTime.now());
            return userRepository.save(newUser);
        });

        return new CustomOAuth2User(oauth2User, user);
    }
}

