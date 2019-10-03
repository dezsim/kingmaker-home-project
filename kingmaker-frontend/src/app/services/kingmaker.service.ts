import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

const URL = 'http://localhost:8080';

const httpOptions = {
  headers : new HttpHeaders({
  'Content-Type' : 'application/json',
  'Authorization' : 'Bearer ' + localStorage.getItem('token')
})
};

@Injectable({
  providedIn: 'root'
})
export class KingmakerService {
  
  constructor(private http : HttpClient, private auth : AuthService) { }

  public joinGame(){
    this.http.post(URL + '/game/new/' + this.auth.user.username, httpOptions)
      .subscribe(
        data => console.log(data),
        err => console.log(err)
    );
  }
  
  public connectServer(){
    this.http.get(URL + '/player/' + this.auth.user.username, httpOptions)
      .subscribe(
        data => console.log(data),
        err => console.log(err)
      );
  }

  public build(building : string){
    const buildingsBody = {
      "buildingType" : building,
      "player" : {
        "username" : this.auth.user.username
      }
      
    };
    this.http.post(URL + '/building/', buildingsBody, httpOptions)
      .subscribe(
        data => console.log(data),
        err => console.log(err)
      );

    
  }
  
  public hire(membertype : string){
    const membersBody = {
      "memberType" : membertype,
      "player" : {
        "username" : this.auth.user.username
      }
    };
    this.http.post(URL + '/crew/', membersBody, httpOptions)
      .subscribe(
        data => console.log(data),
        err => console.log(err)
      );
  }
  
  
  
  
  
  
  public getPlayerData() : Observable<any> {
    return this.http.get(URL + "/player/" + this.auth.user.username);
  }

  public sendUsername(username : string) {
    return this.http.post('http://localhost:8080/api/player/', username);
  }

  public getUser(username : string) : Observable<any> {
    return this.http.get("http://localhost:8080/api/player/" + username);
  }
}

