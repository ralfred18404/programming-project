import { Component, OnInit } from '@angular/core';
import { Params, ActivatedRoute } from '@angular/router';
import { PaymentServiceService } from 'src/app/Services/payment-service.service';

@Component({
  selector: 'app-shopping-cart-by-order',
  templateUrl: './shopping-cart-by-order.component.html',
  styleUrls: ['./shopping-cart-by-order.component.css']
})
export class ShoppingCartByOrderComponent implements OnInit {

  private cartId:any;
  private items:any;
  constructor(private route:ActivatedRoute, private paymentService:PaymentServiceService) { }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      // tslint:disable-next-line:radix
      this.cartId = Number.parseInt(params.id);
      
    });
    this.paymentService.getOrderByPayment(this.cartId).subscribe(res=>{
      this.items = res;
    },error=>{
      console.log(error);
    })
  }

}
