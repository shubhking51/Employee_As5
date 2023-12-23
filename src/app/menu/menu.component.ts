import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { StudentService } from '../service/student.service';
import { UserService } from '../service/user.service';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [CommonModule,RouterModule,AppComponent,MatToolbarModule,MatSidenavModule,MatIconModule,MatButtonModule],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
constructor(public service:UserService){

}
}
