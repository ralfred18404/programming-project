import { Component, OnInit } from '@angular/core';
import { ShoesServicesService } from 'src/app/Services/shoes-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  private cartItems:any;
  private total:number;
  constructor(private shoeService:ShoesServicesService, private route:Router) { }

  ngOnInit() {
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
  billing(){
    this.route.navigate(['/billing']);
  }

}
