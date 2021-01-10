package nl.leon.myapp.service;

import nl.leon.myapp.web.api.UserApiDelegate;
import nl.leon.myapp.web.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserApiDelegateImpl implements UserApiDelegate {

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        User user = new User();
        user.setId(123L);
        user.setFirstName("Petros");

        // ... omit other initialization

        return ResponseEntity.ok(user);
    }
}
