import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  public addStudent(student){
    // tslint:disable-next-line:max-line-length
    return this.http.post('http://localhost:8080/student', student, {responseType: 'text' as 'json'});
  }

  // tslint:disable-next-line:typedef
  public getStudents(){
    return this.http.get('http://localhost:8080');
  }

  // tslint:disable-next-line:typedef
  public addBook(bookName, studentId){
    return this.http.post('http://localhost:8080/book/' + bookName + '/student/' + studentId,
      null, {responseType: 'text' as 'json'});
  }
}
