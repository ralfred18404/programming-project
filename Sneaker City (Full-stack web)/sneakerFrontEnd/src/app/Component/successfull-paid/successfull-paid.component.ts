import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-successfull-paid',
  templateUrl: './successfull-paid.component.html',
  styleUrls: ['./successfull-paid.component.css']
})
export class SuccessfullPaidComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit() {
  }
  ordersPage(){
    this.route.navigate(['/orders']);
  }

}
