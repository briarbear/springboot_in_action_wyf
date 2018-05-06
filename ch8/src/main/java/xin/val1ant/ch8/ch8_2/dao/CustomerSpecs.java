package xin.val1ant.ch8.ch8_2.dao;


import static com.google.common.collect.Iterables.toArray;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

/**
 * 自定义Repository查询
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-06-14:24
 */
public class CustomerSpecs {


    //定义一个返回值为Specification 的方法byAuto ，这里使用的是泛型T ，所以这个
    //Specification 是可以用于任意的实体类的。它接受的参数是entityManager 和当前的包含值作为
    //查询条件的实体类对象。
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) { //1

        final Class<T> type = (Class<T>) example.getClass();//2 获得当前实体类对象类的类型

        return new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //3 新建Predicate 列表存储构造的查询条件。

                EntityType<T> entity = entityManager.getMetamodel().entity(type);//4 获得实体类的EntityType ，我们可以从EntityType 获得实体类的属性

                for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {//5 对实体类的所有属性做循环。
                    Object attrValue = getValue(example, attr); //6 获得实体类对象某一个属性的值。
                    if (attrValue != null) {
                        if (attr.getJavaType() == String.class) { //7 当前属性值为字符类型的时候。
                            if (!StringUtils.isEmpty(attrValue)) { //8 若当前字符不为空的情况下。
                                predicates.add(cb.like(root.get(attribute(entity, attr.getName(), String.class)),
                                        pattern((String) attrValue))); //9 构造当前属性like （前后%）属性值查询条件，并添加到条件列表中。
                            }
                        } else {
                            predicates.add(cb.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())),
                                    attrValue)); //10 其余情况，下，构造属性和属性值equal 查询条件，并添加到条件列表中
                        }
                    }

                }
                return predicates.isEmpty() ? cb.conjunction() : cb.and(toArray(predicates, Predicate.class));//11
            }

            /**
             * 12
             */
            private <T> Object getValue(T example, Attribute<T, ?> attr) {
                return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
            }

            /**
             * 13
             */
            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName,
                                                             Class<E> fieldClass) {
                return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
            }

        };

    }

    /**
     * 14
     */
    static private String pattern(String str) {
        return "%" + str + "%";
    }
}
