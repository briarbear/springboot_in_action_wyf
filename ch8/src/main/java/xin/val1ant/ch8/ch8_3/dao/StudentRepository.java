package xin.val1ant.ch8.ch8_3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import xin.val1ant.ch8.ch8_3.domain.Student;

/**
 * 数据库操作接口
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-06-17:06
 */
@RepositoryRestResource(path = "student")
public interface StudentRepository extends JpaRepository<Student, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Student findByNameStartsWith(@Param("name")String name);

}