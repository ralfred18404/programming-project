import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Component/home/home.component';
import { MatOptionModule, MatSelectModule, MatAutocompleteModule, MatIconModule, MatDialogModule, MatInputModule, MatFormFieldModule, MatButtonModule, MatTableModule, MatButtonToggleModule, MatTabsModule, MAT_DIALOG_DATA, MatDialogRef, MatRadioModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { IndexComponent } from './Component/index/index.component';
import { DetailsComponent, addToCartDialog } from './Component/details/details.component';
import { TopbarComponent } from './Component/topbar/topbar.component';
import { MenuComponent } from './Component/menu/menu.component';
import { SearchComponent, LoginDialog, SignUpDialog } from './Component/search/search.component';
import { FooterComponent } from './Component/footer/footer.component';
import { ShoppingCartComponent } from './Component/shopping-cart/shopping-cart.component';
import { BillingDetailsComponent } from './Component/billing-details/billing-details.component';
import { SuccessfullPaidComponent } from './Component/successfull-paid/successfull-paid.component';
import { OrdersComponent } from './Component/orders/orders.component';
import { ShoppingCartByOrderComponent } from './Component/shopping-cart-by-order/shopping-cart-by-order.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    IndexComponent,
    DetailsComponent,
    TopbarComponent,
    MenuComponent,FooterComponent,
    SearchComponent,addToCartDialog,
    LoginDialog, SignUpDialog, ShoppingCartComponent, BillingDetailsComponent, SuccessfullPaidComponent, OrdersComponent, ShoppingCartByOrderComponent
  ],
  entryComponents: [LoginDialog, SignUpDialog, addToCartDialog],
  imports: [
    BrowserModule, BrowserAnimationsModule, MatOptionModule, MatSelectModule, MatAutocompleteModule, MatIconModule,MatRadioModule,
    AppRoutingModule, MatDialogModule, MatInputModule, MatFormFieldModule, MatButtonModule, NgbModule,
    FormsModule, HttpClientModule, MatTableModule, MatButtonToggleModule, ReactiveFormsModule,MatTabsModule,
    ReactiveFormsModule.withConfig({ warnOnNgModelWithFormControl: 'never' })
  ],
  providers: [
    { provide:MAT_DIALOG_DATA, useValue:{}},
    { provide:MatDialogRef, useValue:{}}  
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
