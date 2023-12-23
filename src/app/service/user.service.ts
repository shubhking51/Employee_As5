import { Injectable } from '@angular/core';
import { StudentService } from './student.service';
import { Student } from '../../model/student';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  isUserLoggedIn:boolean=false;
  public students:Student[]=[];  
  constructor(private s:StudentService){
    this.isValidSession();

  }


  perform_Login(username:string,password:string){
    if(username=='admin' && password=='admin'){
      this.isUserLoggedIn=true;
     
    }
    else{
      this.isUserLoggedIn=false;
    
    }
    return this.isUserLoggedIn;
  }

  // Following method are for maintaning the session of the user 
  public createSessionAndStoreValue(username:string, isUserLoggedIn:boolean){
    sessionStorage.setItem('isUserLoggedIn',isUserLoggedIn +'')
    sessionStorage.setItem('username',username)
  }
  public isValidSession(){
    let isUserLoggedIn = sessionStorage.getItem('username')
    if(isUserLoggedIn == 'true'){
      this.isUserLoggedIn=true
    }
    else{
      this.isUserLoggedIn=false
    }
  }

  public logout(){
    sessionStorage.removeItem('username')
    sessionStorage.removeItem('isUserLoggedIn')
  }


}
