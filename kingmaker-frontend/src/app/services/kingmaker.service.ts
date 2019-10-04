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
        (data : any) => { 
          if(data.playerBlue.username == localStorage.getItem("username")){
            localStorage.setItem('enemy', data.playerRed.username);
         } else {
          localStorage.setItem('enemy', data.playerBlue.username);
         }
        },
        err => console.log(err)
    );
  }


  public getGame(){
   this.http.get(URL + '/game/get/' + this.auth.user.username, httpOptions).subscribe(
     (data : any) =>  { 
       console.log(data);
       if(data.playerBlue.username == localStorage.getItem("username")){
        localStorage.setItem('enemy', data.playerRed.username);
     } else {
      localStorage.setItem('enemy', data.playerBlue.username);
     }
     });
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

  public getBuildings() : Observable<any> {
    return this.http.get(URL + "/building/" + this.auth.user.username);
  }

  public getOppBuildings() : Observable<any> {
    return this.http.get(URL + "/building/" + localStorage.getItem("enemy"));
  }
}

