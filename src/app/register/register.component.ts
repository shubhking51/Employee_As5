import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { FormsModule } from '@angular/forms';
import { StudentService } from '../service/student.service';

import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { StudentRestService } from '../service/student-rest.service';
import { Student } from '../../model/student';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule,FormsModule,MatFormFieldModule,
    MatInputModule,MatButtonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  // name:string=''
  // rollno:number=0
  // noOfAttempts:number=0
  // percentage:number=0
 
  registeredStudent: Student = new Student(0, '', 0, 0, []);
  constructor(private r:Router,private user:StudentRestService){}

    perform_Register(){     
      // console.log(this.registeredStudent);
      this.user.saveStudent(this.registeredStudent)
      .subscribe((response) => console.log(response));
    
      this.r.navigate(['login'])
      
    }
  
  }
   