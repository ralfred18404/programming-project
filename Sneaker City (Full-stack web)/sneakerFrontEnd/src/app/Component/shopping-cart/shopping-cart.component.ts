import { Component, OnInit } from '@angular/core';
import { ShoesServicesService } from 'src/app/Services/shoes-services.service';
import { Router } from '@angular/router';
import { Cart } from 'src/app/model/Cart';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  private cartItems:any;
  private total:number;
  private qty:number;
  private updateQuantity:boolean;
  constructor(private shoeService:ShoesServicesService, private route:Router) { }

  ngOnInit() {
   this.cartList();
   
  }
  cartList(){
    this.shoeService.shoppingCartItems().subscribe(res=>{
      this.updateQuantity = false;
      this.total =0;
      this.cartItems = res;
      for(const item of this.cartItems){
        this.qty = item.quantity;
        this.total =this.total+ item.shoe.model.price*item.quantity;
        item.update = false;
      }
    },error=>{
      console.log(error);
    })
  }
  billing(){
    this.route.navigate(['/billing']);
  }
  update(cart:Cart){
    console.log("qty: "+cart.quantity);
    this.shoeService.updateCart(cart).subscribe(res=>{
      this.cartList();
    },error=>{
      console.log(error);
    })
  }
  productPage(){
    this.route.navigate(['/index']);
  }
  removeToCart(id){
    this.shoeService.removeFromCart(id).subscribe(res=>{
      console.log(res);
      this.cartList();
    },error=>{
      console.log(error);
    })
  }

}
