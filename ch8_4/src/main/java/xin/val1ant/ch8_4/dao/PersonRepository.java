package xin.val1ant.ch8_4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.val1ant.ch8_4.domain.Person;

/**
 * 数据库访问对象
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-06-22:16
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
