import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Shoe } from '../model/Shoe';



const API = "http://localhost:8080/bk/";
const APConst = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};
@Injectable({
  providedIn: 'root'
})

export class ShoesServicesService {

  constructor(private http:HttpClient) { }

  shoesListService():Observable<any>{
    return this.http.get(API+"returnShoes"+"/3",APConst);
  }
  shoesLisDetailsService(shoeId):Observable<any>{
    return this.http.get(API+"getShoesDetails/"+shoeId,APConst);
  }
  getShoeById(id):Observable<any>{
    return this.http.get(API+"getModelId/"+id,APConst);
  }

  addTocartShoe(shoeid:string, quantity:number){
    const data={
      "shoe":shoeid,
      "quantity":quantity
    }
    return this.http.post(API+"addToCart",JSON.stringify(data), APConst);
  }

  shoppingCartItems(){
    return this.http.get(API+"shoppingCart",APConst);
  }
}
