import { Component, OnInit, Inject } from '@angular/core';
declare var $: any;
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { FormControl } from '@angular/forms';
import {map, startWith} from 'rxjs/operators';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  private key: any;
  filteredOptions: Observable<string[]>;
  myControl = new FormControl();
  options:string[]=[];
  private user:any;
  constructor(private route:Router,  private dialog:MatDialog) { }

  ngOnInit() {
    $('.hero__search__categories').on('click', function(){
      $('.hero__search__categories ul').slideToggle(400);
  });
  
 
  }
  
  details(){
    this.route.navigate(['/details']).then(res=>{
      window.location.reload();
    });
   
  }
  index(){
    this.route.navigate(['/index']).then(res=>{
      window.location.reload();
    });
  }

  
  
  
  loginForm(){
      const dialogRef = this.dialog.open(LoginDialog,{
        width:"600px"
      });
    
  }

}
@Component({
  selector:'loginDialog',
  templateUrl:'./loginDialog.html'
})
export class LoginDialog{

  constructor(private dialog: MatDialog, 
     private route: Router,
     public dialogRef:MatDialogRef<LoginDialog>,
    @Inject(MAT_DIALOG_DATA) public data:any){
      
  }
  openSignupDialog() {
    const dialogRef = this.dialog.open(SignUpDialog, {
      width: '800px'
    });
    this.dialogRef.close();
  }
 
}
@Component({
  selector:'createAccount',
  templateUrl:'./createAccount.html'
})
export class SignUpDialog{
 
  constructor(private dialog: MatDialog, public dialogRef:MatDialogRef<LoginDialog>,
   
    @Inject(MAT_DIALOG_DATA) public data:any){
     
  }
  openLogin(){
    const dialogRef = this.dialog.open(LoginDialog,{
      width:"600px"
    });
    this.dialogRef.close();
  }
 
  
}

