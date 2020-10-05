import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShoesServicesService } from 'src/app/Services/shoes-services.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  private shoeList:any;

  constructor(private shoesService:ShoesServicesService, private route:Router) { }

  ngOnInit() {
    this.returnShoes();
  }

  returnShoes(){
    this.shoesService.shoesListService().subscribe(res=>{
      this.shoeList = res;
    },error=>{
      console.log(error);
    })
  }
  shoeDetailsPage(id){
    this.route.navigate(['/details', id]);
  }
  
}
