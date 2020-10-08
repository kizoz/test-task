import { Component, OnInit } from '@angular/core';
import {StudentServiceService} from '../student-service.service';

@Component({
  selector: 'app-get-all',
  templateUrl: './get-all.component.html',
  styleUrls: ['./get-all.component.css']
})
export class GetAllComponent implements OnInit {

  students: any;
  bookName: string;
  studentName: string;
  studentId: number;
  message: string;

  constructor(private service: StudentServiceService) { }

  ngOnInit(): void {
    const resp = this.service.getStudents();
    resp.subscribe((value) => this.students = value);
  }

  // tslint:disable-next-line:typedef
  public addBook(studentId){
    const resp = this.service.addBook(this.bookName, studentId);
    // @ts-ignore
    resp.subscribe(value => this.message = value);
  }

  // tslint:disable-next-line:typedef
  public setStudentIdAndName(id, name){
    this.studentId = id;
    this.studentName = name;
  }

}
