package com.gisuni.hellospringbootjpa.servers;

import com.gisuni.hellospringbootjpa.dao.UserDao;
import com.gisuni.hellospringbootjpa.model.User;
import com.gisuni.hellospringbootjpa.repository.userRepository;

import com.gisuni.hellospringbootjpa.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserRestServerImpl implements UserRestServer {

    /* 猜想：jpa框架在编译时创建了多个继承于userRepository接口的类的bean并注入ioc容器中
       使用 @Autowired 装配的前提是ioc中userRepository型的bean要唯一
       因此 应该可以使用 @Autowired  @Qualifier("userRepository") 进行代替
       使用 @Resource 会根据name进行装配  确保了唯一性。
     */

   @Resource
   private userRepository userRepository;

   @Resource
   private Mapper dozerMapper;

//    @ApiOperation("根据id获取用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "ID", defaultValue = "1")
//    })
//    @GetMapping(value = "/users/{id}")
//    public Response<UserDao> getUsers (@PathVariable("id") long id){
//
//        UserDao libk = UserDao.builder()
//                .address("达州")
//                .age(23)
//                .name("libk")
//                .Id(1L).build();
//
//        Response<UserDao> Response = new Response<UserDao>();
//        Response.setData(libk);
//        return Response;
//    }


    @Override
    public void saveUser(User user) {
        UserDao userPO = dozerMapper.map(user , UserDao.class);
        userRepository.save(userPO);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id ,User user) {
        UserDao userPO = dozerMapper.map(user , UserDao.class);
        userRepository.save(userPO);
    }

    @Override
    public User getUser(Long id) {
        Optional<UserDao> userDao = userRepository.findById(id);
        User user  = dozerMapper.map(userDao , User.class);
//        user.setFamily();
        return user;
    }

    @Override
    public List<User> getAll() {
        List<UserDao> users = userRepository.findAll();
        return DozerUtils.mapList(users, User.class);
    }
}
