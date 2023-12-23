package in.co.vwits.sms.service;

//import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import in.co.vwits.sms.model.Student;
import in.co.vwits.sms.model.exception.StudentNotFoundException;

public interface StudentService {

	//Print all who scored more than 80
	List<Student> findAllStudentScoreMoreThan80(double percentage);

	//Print all who scored more than 80 in less than 3 attempts
	List<Student> findAllStudentScoreMoreThan80LesserAttempt(double percentage, int numberOfAttempts);
	//Print all whose name starts with M

	long countOfStudentNameStartingWithM(String name);

	List<Student> findAllStudentNameStartingWithM(String name);

	//Using Sorted
	List<Student> findAllStudentSortedByPercentage();

	//Score more than 90
	List<String> findAllStudentScoreMoreThanGivenPercentage(double Percentage);

	// Case 11: Student Learning specific subject
	List<Student> findAllStudentsLearningSpecificSubject(String subject);

//	List<Student> findAllStudentsBornBeforeGivenDate(LocalDate SpecificDate);
//
//	long findStudentsBornAfterGivenDate(LocalDate SpecificDate);

	Map<Boolean, List<Student>> partioningStudentsBasedOnMarks(double mark);

	List<Student> findAll();

	void save(Student s);

	//Find
	Optional<Student> findByRollno(int rollno) throws StudentNotFoundException;

	void deleteByRollno(int rollno);

	void updateByRollno(int rollno, double modifiedMarks);

	long findUniqueSubject();

	void updateByRollno(Student ss);
	
	 List<Student>findAllWithSubjects();

	Student findStudentWithSubjects(int rno);

}