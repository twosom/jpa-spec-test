package com.icloud.jpaspectest.repository;

import com.icloud.jpaspectest.entity.Person;
import com.icloud.jpaspectest.entity.Team;
import org.springframework.data.jpa.domain.Specification;

/**
 * 여기서 작성한 메소드에서 <pre>
 * {@code
 *  criteriaBuilder.equal(root.get("firstName"), firstName)
 * }
 * </pre> 같은 코드들을 통해 Person의 firstName과 파라미터의 firstName을 비교하는 쿼리문이 추가됨.
 * <p>
 * criteriaBuilder는 equal 말고도 like, lessThanOrEqualTo, greaterThanOrEqualTo 등 다양한 메소드들을 지원함.
 *
 * @see <a href="https://dev-setung.tistory.com/20">출처</a>
 */
public class PersonSpecification {

    public static Specification<Person> equalFirstName(String firstName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"), firstName);
    }

    public static Specification<Person> equalLastName(String lastName) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("lastName"), lastName));
    }

    public static Specification<Person> equalAge(Integer age) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), age);
    }

    public static Specification<Person> equalTeam(Team team) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("team"), team);
    }

    public static Specification<Person> geAge(int age) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("age"), age);
    }

    public static Specification<Person> equalTeamName(String teamName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("team").get("name"), teamName);
    }
}
