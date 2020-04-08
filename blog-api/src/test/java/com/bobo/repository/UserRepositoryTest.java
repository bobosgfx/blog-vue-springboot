package com.bobo.repository;

import com.bobo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Description: com.bobo.repository
 * Author: bo_yu
 * Date: 2020/4/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository
            userRepository;

    @Test
    public void findByAccount() {
        User byAccount = userRepository.findByAccount("shimh");
        System.out.println(byAccount);
    }
}
