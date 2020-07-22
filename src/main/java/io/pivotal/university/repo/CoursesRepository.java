package io.pivotal.university.repo;

import io.pivotal.university.domain.Courses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Courses, Integer> {


    Courses findByName(String name);

    List<Courses> findByDepartment(String deptName);

      /*
    @Query("Select c from Courses c where c.department.chair.member.lastName=:chair")
    List<Courses> findByChairLastName(@Param("chair")String chairLastName);

    @Query("Select c from Courses c join c.prerequisites p where p.id = ?1")
    List<Courses> findCoursesByPrerequisite(int id);

   @Query("Select new com.example.university.view.CoursesView" +
            "(c.name, c.instructor.member.lastName, c.department.name) from Courses c where c.id=?1")
    CoursesView getCoursesView(int CoursesId) ;

    List<Courses> findByCredits(@Param("credits") int credits);

    Page<Courses> findByCredits(@Param("credits") int credits, Pageable pageable);*/

}
