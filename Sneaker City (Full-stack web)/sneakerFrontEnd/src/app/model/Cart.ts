import { Shoe } from './Shoe';
import { Payment } from './Payment';

export class Cart{
    id:string;
    shoe:Shoe;
    quantity:number;
    updateCart:boolean;
    payment:Payment;
}