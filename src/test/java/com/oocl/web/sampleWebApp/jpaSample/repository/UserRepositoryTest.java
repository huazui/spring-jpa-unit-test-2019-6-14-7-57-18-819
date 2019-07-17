package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.User;
import com.oocl.web.sampleWebApp.jpaSample.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

  @Autowired
   UserRepository userRepository;

  @Test
  public void test_should_return_user_when_the_user_exist() {
    //given
    User user = new User();
    user.setName("test");
    userRepository.save(user);

    //when
    List<User> userList = userRepository.findAll();

    //then
    Assertions.assertEquals(1, userList.size());
    Assertions.assertEquals("test", userList.get(0).getName());
  }
  @Test
  public void return_all_user_by_the_sanme_name(){
    User user=new User("zhangsan");
    User user1=new User("zhangsan");
    User user2=new User("lisi");
    userRepository.save(user);
    userRepository.save(user1);
    userRepository.save(user2);

    List<User> users = userRepository.findUsersByName("zhangsan");

    Assertions.assertEquals(2, users.size());
  }
  @Test
  public void delete_user_by_name(){
    User user=new User("zhangsan");
    User user1=new User("zhangsan");
    User user2=new User("lisi");
    userRepository.save(user);
    userRepository.save(user1);
    userRepository.save(user2);
    userRepository.delete(user);
    List<User> users = userRepository.findAll();

    Assertions.assertEquals(2, users.size());
  }
  @Test
  public void delete_by_name(){
    User user=new User("zhangsan");
    User user1=new User("zhangsan");
    User user2=new User("lisi");
    userRepository.save(user);
    userRepository.save(user1);
    userRepository.save(user2);
    userRepository.deleteSelf(user);
    List<User> users = userRepository.findAll();
    Assertions.assertEquals(2, users.size());
  }
@Test
    public void should_return_exception_when_the_user_name_length_more_64() {
        //given
        User user = new User();
        user.setName("resthujshtresthujshtresthujshtresthujshtresthujshtresthujshtresthujshtresthujsht");
        Assertions.assertThrows(Exception.class, () -> {
            userRepository.saveAndFlush(user);
        });
    }
}

