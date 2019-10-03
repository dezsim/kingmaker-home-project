import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Player } from '../player.model';

const apiUrl = 'http://localhost:8080/';
const httpOptions = {
  headers: new HttpHeaders({
    'Authorization': 'Basic ' + btoa("fooClientIdPassword:secret"),
    'Content-type': 'application/x-www-form-urlencoded'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  body : HttpParams;
  isLoggedIn = false;
  redirectUrl: string;

  public user: Player;

  constructor(private http: HttpClient) {
  }

  public login(username, password){
   
    this.body = new HttpParams()
      .set('username', username)
      .set('password', password)
      .set('grant_type', 'password');


    this.http.post('http://localhost:8080/oauth/token', this.body, httpOptions)
          .subscribe((data : any) => {
            localStorage.setItem('token', data.access_token)
            this.user = new Player(null, username);
            localStorage.setItem('username', username)
            err => console.log('invalid Credentials')
            });
          
            console.log(localStorage.getItem('token'));
  }

  public getToken(): string {
    return localStorage.getItem('token');
  }

  public getUsername(): string {
    return localStorage.getItem('username');
  }

  public isAuthenticated(): boolean {
    const token = this.getToken();
    if(token != null){
      this.isLoggedIn = true;
      return true;
    }
    this.isLoggedIn = false;
    return false;
    
  }
  
  logout(): Observable<any> {
    return this.http.get<any>(apiUrl + 'signout')
      .pipe(
        tap(_ => this.isLoggedIn = false),
        catchError(this.handleError('logout', []))
      );
  }
  
  register(data: any): Observable<any> {
    return this.http.post<any>(apiUrl + 'register', data)
      .pipe(
        tap(_ => this.log('login')),
        catchError(this.handleError('login', []))
      );
  }
  
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      console.error(error); // log to console instead
      this.log(`${operation} failed: ${error.message}`);
  
      return of(result as T);
    };
  }
  
  private log(message: string) {
    console.log(message);
  }
  
}
