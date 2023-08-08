package com.woromedia.api.task;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import com.woromedia.api.task.controller.AuthController;
import com.woromedia.api.task.entity.Role;
import com.woromedia.api.task.entity.User;
import com.woromedia.api.task.payload.JWTAuthResponse;
import com.woromedia.api.task.payload.LoginDTO;
import com.woromedia.api.task.payload.SignUpDTO;
import com.woromedia.api.task.repository.RoleRepository;
import com.woromedia.api.task.repository.UserRepository;
import com.woromedia.api.task.security.JwtTokenProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtTokenProvider tokenProvider;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private AuthController authController;

    // Test Case: testAuthenticateUserSuccess()
    @Test
    public void testAuthenticateUserSuccess() {
        // Mock the authenticationManager to return a valid authentication
        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);

        // Mock the tokenProvider to return a valid token when generateToken() is called
        when(tokenProvider.generateToken(any(Authentication.class))).thenReturn("sample_jwt_token");

        // Create a sample LoginDTO
        LoginDTO loginDto = new LoginDTO();
        loginDto.setUsernameOrEmail("sample_username");
        loginDto.setPassword("sample_password");

        // Call the authenticateUser() method
        ResponseEntity<JWTAuthResponse> response = authController.authenticateUser(loginDto);

        // Assert that the response is successful and contains the expected JWT token
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Bearer", response.getBody().getTokenType());
        assertEquals("sample_jwt_token", response.getBody().getAccessToken());

        // Optionally, you can verify that the authenticationManager's authenticate() method was called with the correct argument
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));

        // Optionally, you can verify that the tokenProvider's generateToken() method was called with the correct argument
        verify(tokenProvider).generateToken(any(Authentication.class));
    }

    // Test Case: testRegisterUserSuccess()
    @Test
    public void testRegisterUserSuccess() {
        // Create a sample SignUpDTO
        SignUpDTO signUpDto = new SignUpDTO();
        signUpDto.setUsername("new_user");
        signUpDto.setEmail("new_user@example.com");
        signUpDto.setPassword("new_user_password");

        // Mock userRepository.existsByUsername() to return false (username is not taken)
        when(userRepository.existsByUsername("new_user")).thenReturn(false);

        // Mock userRepository.existsByEmail() to return false (email is not taken)
        when(userRepository.existsByEmail("new_user@example.com")).thenReturn(false);

        // Mock roleRepository.findByName() to return a Role object
        Role role = new Role("ROLE_USER");
        when(roleRepository.findByName("ROLE_USER")).thenReturn(role);

        // Call the registerUser() method
        ResponseEntity<?> response = authController.registerUser(signUpDto);

        // Assert that the response is successful and contains the expected message
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User registered successfully", response.getBody());

        // Optionally, you can verify that userRepository.save() was called with the correct User object
        verify(userRepository).save(any(User.class));
    }

    // Test Case: testAdminPanelSuccess()
    @Test
    public void testAdminPanelSuccess() {
// Create a sample Authentication object representing an ADMIN user
        Authentication authentication = mock(Authentication.class);
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        SecurityContextHolder.getContext().setAuthentication(authentication);


        // Call the adminPanel() method
        ResponseEntity<String> response = authController.adminPanel();

        // Assert that the response is successful and contains the expected message
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Admin Panel", response.getBody());
    }

    // Test Case: testLogoutSuccess()
    @Test
    public void testLogoutSuccess() {
        // Call the logout() method
        ResponseEntity<String> response = authController.logout();

        // Assert that the response is successful and contains the expected message
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Logged out successfully", response.getBody());
    }
}
