import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentService } from '../service/student.service';
import { StudentUpdateComponent } from '../student-update/student-update.component';
import { Student } from '../../model/student';
import { MatButtonModule } from '@angular/material/button';
import { MatRadioModule } from '@angular/material/radio';
import { StudentRestService } from '../service/student-rest.service';
@Component({
  selector: 'app-students',
  standalone: true,
  imports: [CommonModule,StudentUpdateComponent,MatButtonModule,MatRadioModule],
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})
export class StudentsComponent {
  

  students:Student[]=[]
  message:string='';
  colorClass:string='';

  selectedStudents!:Student
  updateClicked: boolean = false;

  constructor(private service:StudentRestService){
    this.showStudents();
  }
  showStudents(){
    this.service.findAllStudents().subscribe(
      response=>this.students=response
    );
  }
  deleteByRollno(rollno:number){

    const result =confirm('want to delete student with roll no?:'+rollno);
    if(result){
      this.service.deleteByRollno(rollno).subscribe(
        success=> {
          this.students=this.students.filter(s => s.rollno != rollno);
          this.message='Record Deleted Successfully!';
          this.colorClass='success';
        } )     
         
    }
    else{
      this.message='Deletion Cancel!';
      this.colorClass='error';
    }
  }
  sortByPercentage(){
    this.students.sort((a,b)=>b.percentage-a.percentage);

  }
  sortByAttempts(){
    this.students.sort((a,b)=>b.noOfAttempts-a.noOfAttempts);

  }
  sortBysubjectsLearning(){

  } 
  updateStudent(s:Student){
    this.updateClicked=true;
    this.selectedStudents=s
    }
  
  doUpdate(updatedStudent:Student){
    let modifiedStudents= this.students.map(s=>{ 
// map is built-in function of js which transform every element of array and returns array
      if(s.rollno==updatedStudent.rollno)
      {
        //following line make use of spread operator, it was added in ES6
        //Using following line we are changing value of noOfAttempts field
        return{...s,noOfAttempts:updatedStudent.noOfAttempts} 
      } 
      else{
        return s;
      }
    })
    this.students=modifiedStudents
    this.updateClicked=false;
  }
  }
  
