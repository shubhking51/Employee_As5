import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule,MatFormFieldModule,
    MatInputModule,MatButtonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username:string=''
  password:string=''
  message:string=''
  showError:boolean=false;
  constructor(private r:Router,private user:UserService){
    this.username = 'admin';
    this.password = 'admin';
  }

  perform_Login(){
    if(this.user.perform_Login(this.username,this.password))
    {
      this.message='login success'
      this.user.createSessionAndStoreValue(this.username,true);
      // SHOW STUDENTS VIEW TO USER 
      this.r.navigate(['students']) // This is programmatic navigation
    }
    else{
      this.message='login failed'
      this.user.createSessionAndStoreValue('guest',false);
      this.showError=true;
    }

  }

}
