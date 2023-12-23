package in.co.vwits.sms.model;

//import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/*import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;*/
@Entity
@Table(name="tbl_student")
@NamedQuery(name="findAllWithSubjects",query="from Student AS s LEFT JOIN FETCH s.subjectsLearning")
public class Student implements Comparable<Student>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  //this will automatically increment the value of rollNo using DB
	private int rollno;
	@Column(name="st_name",nullable=false)
	private String name;
	private double percentage;
	private int numberOfAttempts;
	//@ElementCollection(fetch = FetchType.EAGER) //not recommended though possible
	@ElementCollection(fetch=FetchType.LAZY)  //recommended approach when data needed using jpql
	@CollectionTable(name="Students_Subjects",joinColumns=@JoinColumn(name="rollno_fk"))
	private List<String> subjectsLearning;
	
//	private LocalDate dateOfBirth;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	public int getnumberOfAttempts() {
		return numberOfAttempts;
	}
	public void setnumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}
	
	
	public List<String> getSubjectsLearning() {
		return subjectsLearning;
	}
	public void setSubjectsLearning(List<String> subjectsLearning) {
		this.subjectsLearning = subjectsLearning;
	}
//	public LocalDate getDateOfBirth() {
//		return dateOfBirth;
//	}
//	public void setDateOfBirth(LocalDate dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", numberOfAttempts="
				+ numberOfAttempts + ", subjectsLearning="  + subjectsLearning+"]";
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return (int) (o.percentage - this.percentage);
	}
	
	
	
	
}
