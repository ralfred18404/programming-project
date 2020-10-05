import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Payment } from '../model/Payment';
import { Observable } from 'rxjs';


const API = "http://localhost:8080/bk/";
const APConst = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};
@Injectable({
  providedIn: 'root'
})
export class PaymentServiceService {

  constructor(private http:HttpClient) { }

  payOrder(payment:Payment, totalqty:number){
    const data={
      "pay":payment,
      "total":totalqty

    }
    return this.http.post(API+"payment",JSON.stringify(data),APConst);
  }
  getOrders():Observable<any>{
    return this.http.get(API+"findOrders",APConst);
  }
  getOrderByPayment(id){
    return this.http.get(API+"orderByCart/"+id,APConst);
  }


}
