package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.entities.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@Transactional
public interface UserService {
    User findById(Long id);

    User save(User entity);

    Map<String, Object> allDto (String search, Integer pageNo, Integer pageSize);


}
