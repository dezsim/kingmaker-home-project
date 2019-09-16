import { Component, OnInit } from '@angular/core';
import { KingmakerService } from 'src/app/services/kingmaker.service';

@Component({
  selector: 'app-kingmaker',
  templateUrl: './kingmaker.component.html',
  styleUrls: ['./kingmaker.component.css']
})
export class KingmakerComponent implements OnInit {

  constructor(private kingmakerService : KingmakerService) { }

  ngOnInit() {
    this.kingmakerService.getData().subscribe(data => console.log(data));
  }

}
