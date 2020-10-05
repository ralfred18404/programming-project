import { Component, OnInit } from '@angular/core';
import { PaymentServiceService } from 'src/app/Services/payment-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  private ordersList:any;

  constructor(private paymentService:PaymentServiceService, private route:Router) { }

  ngOnInit() {
    this.paymentService.getOrders().subscribe(res=>{
      this.ordersList = res;
    },error=>{
      console.log(error);
    })
  }

  shoeDetails(id){
    this.route.navigate(['/cartList', id]);
  }

  
}
