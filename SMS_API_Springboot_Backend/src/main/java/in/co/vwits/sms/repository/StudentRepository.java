package in.co.vwits.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.co.vwits.sms.model.Student;

//JPA repository gives a lot of built-in methods for CRUD operations
//which we don't have to implement
public interface StudentRepository extends JpaRepository<Student,Integer>{

	// But we also have freedom of writing our custom method.
	// We just have to declare custom method, we don't have to define them
	// But for custom method we have to write jpql on top of perspective custom methods.
	// this is done using @Query annotation
	
	@Query("SELECT DISTINCT s from Student AS s LEFT JOIN FETCH s.subjectsLearning")
	List<Student> findAllWithSubjects();
	
	@Query("from Student AS s LEFT JOIN FETCH s.subjectsLearning WHERE s.rollno= :rno")
	Student findStudentWithSubjects(@Param(value = "rno") int roll);
	
//	@Query("DELETE FROM Student s WHERE s.rollno= :rollno")
//	void deleteByRollno(@Param(value = "rollno") int rollno);
//
//	
}
