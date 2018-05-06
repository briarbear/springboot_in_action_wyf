package xin.val1ant.ch8.ch8_2.dao;

/**
 * 数据访问接口
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-05-20:42
 */
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xin.val1ant.ch8.ch8_2.domain.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

    //使用方法名查询，接受一个name 参数，返回值为列表。
    List<Person> findByAddress(String address);

    //使用方法名查询，接受name 和address ，返回值为单个对象
    Person findByNameAndAddress(String name,String address);

    //使用＠Query 查询，参数按照名称绑定。
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);

    //使用＠NamedQue1γ 查询，请注意我们在实体类中做的＠NamedQuery 的定义
    Person withNameAndAddressNamedQuery(String name,String address);



}