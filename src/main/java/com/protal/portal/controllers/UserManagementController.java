package com.protal.portal.controllers;

import com.protal.portal.Responses.ListRoleResponse;
import com.protal.portal.Responses.ListUsersResponse;
import com.protal.portal.Responses.SocialMediaResponse;
import com.protal.portal.secuirtyImpl.models.Role;
import com.protal.portal.secuirtyImpl.models.User;
import com.protal.portal.secuirtyImpl.models.UserRole;
import com.protal.portal.secuirtyImpl.payload.response.MessageResponse;
import com.protal.portal.secuirtyImpl.repository.RoleRepository;
import com.protal.portal.secuirtyImpl.repository.UserRepository;
import com.protal.portal.secuirtyImpl.repository.UserRoleRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/portal")
public class UserManagementController {
    private final RestTemplate restTemplate;

    public UserManagementController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @GetMapping("/listUsers")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> listUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);


        return ResponseEntity.ok(new ListUsersResponse(
                users));
    }

    @GetMapping("/getRoles")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getRoles() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);


        return ResponseEntity.ok(new ListRoleResponse(
                roles));
    }

    @Transactional
    @PostMapping("/updateUserRoles")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUserRole(@RequestBody Map<String, Object> payLoad) {
        long deletedRecords = userRoleRepository.deleteByUserId((Integer) payLoad.get("userid"));
        List<UserRole> userRolesList = new ArrayList<>();

        List<Integer> roles = (List<Integer>) payLoad.get("roles");
        for(int i=0; i<roles.size(); i++){
            UserRole userRole = new UserRole((Integer) payLoad.get("userid"), roles.get(i));
            userRolesList.add(userRole);
        }
        userRoleRepository.saveAll(userRolesList);
        return ResponseEntity.ok(new MessageResponse("User roles updated successfully!"));
    }

    @Transactional
    @DeleteMapping("/deleteUser")
    //    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@RequestBody Map<String, Object> payLoad) {
        userRepository.deleteByUsername((String) payLoad.get("username"));
        return ResponseEntity.ok(new MessageResponse("User deleted successfully!"));
    }

    // TODO: treba implementirati promjenu lozinke
}
