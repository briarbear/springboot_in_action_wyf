package xin.val1ant.ch8_5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.val1ant.ch8_5.domain.Person;

/**
 * dao
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-06-23:44
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
