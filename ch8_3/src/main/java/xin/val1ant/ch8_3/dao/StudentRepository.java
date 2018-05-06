package xin.val1ant.ch8_3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import xin.val1ant.ch8_3.domain.Student;

/**
 * DAO接口
 */
@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
