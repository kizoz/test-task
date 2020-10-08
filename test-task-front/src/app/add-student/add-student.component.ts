import { Component, OnInit } from '@angular/core';
import {Student} from '../Student';
import {StudentServiceService} from '../student-service.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  student: Student = new Student();
  message: string;
  constructor(private service: StudentServiceService) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  public addStudent(){
    // @ts-ignore
    const resp = this.service.addStudent(this.student);
    // @ts-ignore
    resp.subscribe((value) => this.message = value);
  }
}
