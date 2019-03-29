package net.xiaomotou.auth.control;


import net.xiaomotou.auth.model.User;
import net.xiaomotou.auth.mq.Sender;
import net.xiaomotou.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    Sender sender;

    @GetMapping("/login")
    public ResponseEntity<String> login(String userName, String password) {
        return ResponseEntity.ok(authService.login(userName, password));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(User user, String userName, String password) {

        return ResponseEntity.ok(authService.register(user, userName, password));
    }


    @PostMapping("/verifyIdentidy")
    public ResponseEntity<User> verifyIdentidy(HttpServletRequest request, String token) {

        User tokenUser = (User) request.getAttribute("tokenUser");

        System.out.println("tokenUser:"+tokenUser.toString());
        return ResponseEntity.ok(authService.parseToken(token));
    }

    @PostMapping("/removeUser")
    public ResponseEntity<Void> removeUser(String userName){
        sender.send(userName);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).build();
    }


}
