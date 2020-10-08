import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './Component/index/index.component';
import { DetailsComponent } from './Component/details/details.component';
import { ShoppingCartComponent } from './Component/shopping-cart/shopping-cart.component';
import { BillingDetailsComponent } from './Component/billing-details/billing-details.component';
import { SuccessfullPaidComponent } from './Component/successfull-paid/successfull-paid.component';
import { OrdersComponent } from './Component/orders/orders.component';
import { ShoppingCartByOrderComponent } from './Component/shopping-cart-by-order/shopping-cart-by-order.component';



const routes: Routes = [
  {path:'', pathMatch:'full', redirectTo:'index'},
  {path:'index', component:IndexComponent},
  {path:'details/:id', component: DetailsComponent},
  {path:'shopping-cart', component: ShoppingCartComponent},
  {path:'billing', component: BillingDetailsComponent},
  {path:'payment', component: SuccessfullPaidComponent},
  {path:'orders', component: OrdersComponent},
  {path:'cartList/:id', component: ShoppingCartByOrderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
