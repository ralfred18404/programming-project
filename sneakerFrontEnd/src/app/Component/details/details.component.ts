import { Component, OnInit, Inject} from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { ShoesServicesService } from 'src/app/Services/shoes-services.service';
import { Model } from 'src/app/model/Model';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

import { Shoe } from 'src/app/model/Shoe';


@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  private shoeId:any;
  private shoeSize:any;
  private shid:any;
  private model:any;
  brandName:string;
  modelName:string;
  price:number;
  date:any;
  private sizeData:any;
  successMessage:boolean;

  constructor(private route:ActivatedRoute, private shoeService:ShoesServicesService,
      private dialogRef:MatDialog) { }

  ngOnInit() {
    
    this.route.params.forEach((params: Params) => {
      // tslint:disable-next-line:radix
      this.shoeId = Number.parseInt(params.id);
      this.shid = Number.parseInt(params.id);
    });
    this.shoeService.shoesLisDetailsService(this.shoeId).subscribe(res=>{
      this.shoeSize = res;
    },error=>{
      console.log(error);
    });
   this.modelId();
  }
  modelId(){
    this.shoeService.getShoeById(this.shid).subscribe(data=>{
     
      console.log("result: "+data.name);
      
      this.date = data.releaseDate;
      this.model = data;
    },error=>{
      console.log(error);
    });
  }
openDialog(shoe){
  this.successMessage = false;
 const dialog= this.dialogRef.open(addToCartDialog,{
    width:'300',
    data:shoe,
    
  })
dialog.afterClosed().subscribe(res=>{
  this.successMessage= true;
})
}

  
}

@Component({
  selector:"addToCartDialog",
  templateUrl:"addToCartDialog.html"
})
export class addToCartDialog{
  private shoe:Shoe;
  private quantity:number;
  private failMessage:boolean;
constructor(private dialog: MatDialog, public dialogRef:MatDialogRef<addToCartDialog>,private shoeService:ShoesServicesService,
  @Inject(MAT_DIALOG_DATA) public data:any){
    this.shoe=data;
    this.failMessage = false;
    console.log("size: "+this.shoe.size)
  }

  addToCart(){
    this.shoeService.addTocartShoe(this.shoe.id,this.quantity).subscribe(res=>{
      this.dialogRef.close();
      this.quantity=0;
      this.shoe = new Shoe();
    },error=>{
      this.failMessage = true;
      console.log(error);
    })
  }
}
