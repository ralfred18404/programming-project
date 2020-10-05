import { Component, OnInit } from '@angular/core';
import { ShoesServicesService } from 'src/app/Services/shoes-services.service';
import { Payment } from 'src/app/model/Payment';
import { PaymentServiceService } from 'src/app/Services/payment-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-billing-details',
  templateUrl: './billing-details.component.html',
  styleUrls: ['./billing-details.component.css']
})
export class BillingDetailsComponent implements OnInit {

  private cartItems:any;
  private total:number;
  private payment:Payment= new Payment();
  private failMessage:boolean;
  constructor(private shoeService:ShoesServicesService, private paymentService:PaymentServiceService,
    private route:Router) { }

  ngOnInit() {
    this.failMessage = false;
    this.shoeService.shoppingCartItems().subscribe(res=>{
      this.total =0;
      this.cartItems = res;
      for(const item of this.cartItems){
        this.total =this.total+ item.shoe.model.price*item.quantity;
      }
    },error=>{
      console.log(error);
    })
  }

  Submit(){
    if(this.payment.username ==='alpha' && this.payment.passkey ==='alpha123'){
    this.paymentService.payOrder(this.payment, this.total).subscribe(res=>{
      console.log(res);
      this.route.navigate(['/payment']);
    },error=>{
      console.log(error);
    })
  }else{
    this.failMessage = true;
  }
}

}
