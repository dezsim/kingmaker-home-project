import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Player } from '../player.model';

@Injectable({
  providedIn: 'root'
})
export class KingmakerService {

  constructor(private httpClient : HttpClient) { }

  public getData() : Observable<any> {
    return this.httpClient.get("http://localhost:8080/api/");
  }

  public sendUsername(username : string) {
    return this.httpClient.post('http://localhost:8080/api/player/', username);
  }

  public getUser(username : string) : Observable<any> {
    return this.httpClient.get("http://localhost:8080/api/player/" + username);
  }

  public login(username, password){
    
    const headers = {
      'Authorization': 'Basic ' + btoa("acme:acmesecret"),
      'Content-type': 'application/x-www-form-urlencoded'
    }
    
    const body = new HttpParams()
          .set('username', username)
          .set('password', password)
          .set('grant_type', 'password');

    this.httpClient.post('http://localhost:8080/' + 'oauth/authorize', body, {headers})
          .subscribe(data => console.log(data),
      
          err => console.log('invalid Credentials'));
  }
  

}

