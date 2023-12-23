import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Student } from '../../model/student';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentRestService {
  
  readonly BASE_URL='http://localhost:8082/api/student' //this url is given by backend team
  constructor(private http:HttpClient) { }

  findAllStudents():Observable<Student[]> {
    return this.http.get<Student[]>(this.BASE_URL)
  }
  findByRollno(rollno:number):Observable<Student>{
    return this.http.get<Student>(this.BASE_URL+"/"+rollno)

  }
  saveStudent(s:Student):Observable<Student>{
    return this.http.post<Student>(this.BASE_URL,s)

  }
  deleteByRollno(rollno:number):Observable<Student>{
    return this.http.delete<Student>(this.BASE_URL+"/"+rollno)

  }
  
  updateStudent(s:Student):Observable<Student>{
    return this.http.put<Student>(this.BASE_URL,s)

  }
}
