package com.gisuni.hellospringbootjpa.repository;

import com.gisuni.hellospringbootjpa.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;


// 猜想： jpa在编译时 创建了很多继承于userRepository的bean并注入了ioc中。

public interface userRepository extends JpaRepository<UserDao, Long> {
}
