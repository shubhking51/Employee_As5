
package in.co.vwits.sms.service.impl;
//import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import in.co.vwits.sms.dao.StudentDao;
import in.co.vwits.sms.dao.impl.StudentDaoImpl;
import in.co.vwits.sms.dao.impl.StudentJDBCDaoImpl;
import in.co.vwits.sms.dao.impl.StudentJpaDaoImpl;*/
import in.co.vwits.sms.model.Student;
import in.co.vwits.sms.model.exception.StudentNotFoundException;
import in.co.vwits.sms.repository.StudentRepository;
//import in.co.vwits.sms.service.LocalDate;
import in.co.vwits.sms.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	/*using reference of interface to communicate with other layer of application is known as
	 * coding to interface. It is the best practice as it give loose coupling among layers 
	 */
	@Autowired
	private StudentRepository repo;
	
	
	//Print all who scored more than 80
	@Override
	public List<Student> findAllStudentScoreMoreThan80(double percentage){
		return repo.findAll().stream()
				  .filter(student->student.getPercentage()>percentage)
				  .collect(Collectors.toList());
		
	}
	//Print all who scored more than 80 in less than 3 attempts
	@Override
	public List<Student> findAllStudentScoreMoreThan80LesserAttempt(double percentage, int numberOfAttempts ){
		return repo.findAll().stream()
				  .filter(student->student.getPercentage()>percentage && student.getnumberOfAttempts()<3)
				  .collect(Collectors.toList());
	

}	
	//Print all whose name starts with M

	  @Override
	public long countOfStudentNameStartingWithM(String name ){ return
	  repo.findAll().stream() .filter(student->student.getName().startsWith("M"))
	  .count();
	 
	 }
	 

	//Count all whose name starts with M
	
	@Override
	public List<Student> findAllStudentNameStartingWithM(String name ){
		return repo.findAll().stream()
				  .filter(student->student.getName().startsWith("M"))
				  .toList();
		
}
	//Using Sorted
	 @Override
	public List<Student> findAllStudentSortedByPercentage(){
	    	return repo.findAll().stream().sorted().collect(Collectors.toList()); 
	    		}
	 //Score more than 90
	 @Override
	public List<String> findAllStudentScoreMoreThanGivenPercentage(double Percentage){
		 return repo.findAll().stream()
				  .filter(student->student.getPercentage()>Percentage)
				  .map(student->student.getName())
				  .toList();
	    		}
	 
	 // Case 11: Student Learning specific subject
	 @Override
	public List<Student> findAllStudentsLearningSpecificSubject(String subject){
		 return repo.findAll().stream()
				   .filter(student->student.getSubjectsLearning().stream().anyMatch(sub->sub.equals(subject)))
				   .toList();
		 
	 }
	 
		/*
		 * @Override public List<Student> findAllStudentsBornBeforeGivenDate(LocalDate
		 * SpecificDate){ return repo.findAll().stream()
		 * .filter(student->student.getDateOfBirth().isBefore(SpecificDate))
		 * .collect(Collectors.toList());
		 * 
		 * }
		 * 
		 * @Override public long findStudentsBornAfterGivenDate(LocalDate SpecificDate){
		 * return repo.findAll().stream()
		 * .filter(student->student.getDateOfBirth().isAfter(SpecificDate)) .count();
		 * 
		 * }
		 */
	 @Override
	public Map<Boolean, List<Student>> partioningStudentsBasedOnMarks(double mark){
		 return repo.findAll().stream()
	             .collect(Collectors.partitioningBy(s-> s.getPercentage()>mark));
	 }
		
	 
	
	@Override
	public List<Student> findAll(){
		return repo.findAll();
	}
	@Override
	public void save(Student s) {
		repo.save(s);
	}
	
	//Find
		@Override
		public Optional<Student> findByRollno(int rollno) throws StudentNotFoundException {
			Optional<Student> p=repo.findById(rollno);
			if(p.isPresent()) {
				return p;
			}
			else {
				// throw user defined exception "StudentNotFound"
				throw new StudentNotFoundException();
			}

		}
	@Override
	public void deleteByRollno(int rollno) {
		
		repo.deleteById(rollno);
		
	}
    @Override
	public void updateByRollno(int rollno, double modifiedMarks) {
		
		//repo.updateByRollno(rollno, modifiedMarks);
	}
    @Override
	public long findUniqueSubject() {
    	return repo.findAll().stream().flatMap(s->s.getSubjectsLearning().stream()).distinct().count();
    }
	@Override
	public void updateByRollno(Student ss) {
		// TODO Auto-generated method stub
		this.repo.save(ss);
		
	}
	@Override
	public List<Student> findAllWithSubjects() {
		
		return this.repo.findAllWithSubjects();
	}
	@Override
	public Student findStudentWithSubjects(int roll) {
		// TODO Auto-generated method stub
		return this.repo.findStudentWithSubjects(roll);
	}
	
	
	
}
