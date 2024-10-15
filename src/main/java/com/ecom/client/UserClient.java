package com.ecom.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.UserDtls;

@FeignClient(name = "SHOPPING-MICROSERVICE", url = "http://${microservice1:localhost}:8091") 
public interface UserClient {

    @PostMapping("/api/users")
    UserDtls createUser(@RequestBody UserDtls user);

    @GetMapping("/api/users/email/{email}")
    UserDtls getUserByEmail(@PathVariable("email") String email);

    @GetMapping("/api/users/role/{role}")
    List<UserDtls> getUsersByRole(@PathVariable("role") String role);

    @PutMapping("/api/users/account-status/{id}/{status}")
    Boolean updateAccountStatus(@PathVariable("id") Integer id, @PathVariable("status") Boolean status);

    @PostMapping("/api/users/increase-attempts")
    void increaseFailedAttempt(@RequestBody UserDtls user);

    @PostMapping("/api/users/lock-account")
    void lockAccount(@RequestBody UserDtls user);

    @PostMapping("/api/users/unlock-account")
    Boolean unlockAccount(@RequestBody UserDtls user);

    @PutMapping("/api/users/reset-attempts/{userId}")
    void resetAttempt(@PathVariable("userId") int userId);

    @PutMapping("/api/users/reset-token")
    void updateUserResetToken(@RequestParam String email, @RequestParam String resetToken);

    @GetMapping("/api/users/token/{token}")
    UserDtls getUserByToken(@PathVariable("token") String token);

    @PutMapping("/api/users")
    UserDtls updateUser(@RequestBody UserDtls user);

    @PutMapping("/api/users/profile")
    UserDtls updateUserProfile(@RequestParam("img") MultipartFile img, @RequestPart UserDtls user);

    @PostMapping("/api/users/admin")
    UserDtls saveAdmin(@RequestBody UserDtls user);

    @GetMapping("/api/users/exists/email/{email}")
    Boolean existsEmail(@PathVariable("email") String email);
}
