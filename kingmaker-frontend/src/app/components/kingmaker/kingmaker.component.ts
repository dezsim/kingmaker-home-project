import { Component, OnInit, Input } from '@angular/core';
import { KingmakerService } from 'src/app/services/kingmaker.service';
import { Player } from 'src/app/player.model';
import { AuthService } from 'src/app/services/auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers : new HttpHeaders({
  'Content-Type' : 'application/json',
  'Authorization' : 'Bearer ' + localStorage.getItem('token')
})
};

@Component({
  selector: 'app-kingmaker',
  templateUrl: './kingmaker.component.html',
  styleUrls: ['./kingmaker.component.css']
})


export class KingmakerComponent implements OnInit {


  constructor(private kingmakerService : KingmakerService, private auth : AuthService, private http : HttpClient) { }

  ngOnInit() {
  }

  public connectServer() {
    this.http.get('http://localhost:8080/player/' + this.auth.user.username, httpOptions)
      .subscribe(
        data => console.log(data),
        err => console.log(err)
      );
  }

  public joinGame(){

    this.http.post('http://localhost:8080/game/new/' + this.auth.user.username, httpOptions)
      .subscribe(
      data => console.log(data),
      err => console.log(err)
    );
  }
}
