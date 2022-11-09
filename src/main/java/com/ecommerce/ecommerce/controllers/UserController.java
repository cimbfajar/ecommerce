package com.ecommerce.ecommerce.controllers;

import com.ecommerce.ecommerce.responses.Response;
import com.ecommerce.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?>all (
            HttpServletRequest request,
            @RequestParam("q") Optional<String> search,
            @RequestParam(name = "page_no", defaultValue = "0") Integer pageNo,
            @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize
    ) {
        Map<String, Object> result = userService.allDto(
                search.orElse(null),
                pageNo,
                pageSize
        );

        return  ResponseEntity.ok(new Response(
                Long.valueOf(result.get("total_result").toString()),
                Long.valueOf(result.get("total_page").toString()),
                result.get("data")
        ));
    }


}
