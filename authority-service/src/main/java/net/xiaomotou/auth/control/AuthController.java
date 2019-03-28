package net.xiaomotou.auth.control;


import net.xiaomotou.auth.model.User;
import net.xiaomotou.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/login")
   public ResponseEntity<String> login(String userName,String password){

        return ResponseEntity.ok(authService.login(userName,password));
   }

    @PostMapping("/register")
    public ResponseEntity<String> register(User user,String userName, String password){

        return ResponseEntity.ok(authService.register(user,userName,password));
    }


    @PostMapping("/verifyIdentidy")
   public ResponseEntity<User> verifyIdentidy(String token){

        return ResponseEntity.ok(authService.parseToken(token));
   }


}
