import { Component, OnInit, Inject } from '@angular/core';
declare var $: any;
import { Router } from '@angular/router';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent implements OnInit {
 
  constructor(private route:Router, 
    private dialog:MatDialog) { }

  ngOnInit() {
  
    this.javascriptAction();
  }
  
  
  details(){
    this.route.navigate(['/details']);
  }
  shoppingCart(){
    this.route.navigate(['/shopping-cart'])
  }
  billing(){
    this.route.navigate(['/billing']);
  }
  ordersPage(){
    this.route.navigate(['/orders']);
  }
  home(){
    this.route.navigate(['/index']);
  }

  javascriptAction(){
    $(".humberger__open").on('click', function () {
      $(".humberger__menu__wrapper").addClass("show__humberger__menu__wrapper");
      $(".humberger__menu__overlay").addClass("active");
      $("body").addClass("over_hid");
  });
  
  $(".humberger__menu__overlay").on('click', function () {
      $(".humberger__menu__wrapper").removeClass("show__humberger__menu__wrapper");
      $(".humberger__menu__overlay").removeClass("active");
      $("body").removeClass("over_hid");
  });
  $(".mobile-menu").slicknav({
    prependTo: '#mobile-menu-wrap',
    allowParentLinks: true
});
  }

}



