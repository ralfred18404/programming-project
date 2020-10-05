import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare var $: any;
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  private token:string;
  constructor(private router: Router) { }

  ngOnInit() {
   this.slideScript();
   

  }

  slideScript(){
    $('.hero__categories__all').on('click', function () {
      $('.hero__categories .nav-fall').slideToggle(400);
    });

    $('.charj').on('click', function () {
      $('.charjj ul').slideUp();
      $('.charjh ul').slideUp();
      $('.charjs ul').slideUp();
      $('.charjp ul').slideUp();
      $('.charjv ul').slideUp();
      $('.charj ul').slideToggle(400);
    });

    $('.charjj').on('click', function () {
      $('.charj ul').slideUp();
      $('.charjh ul').slideUp();
      $('.charjs ul').slideUp();
      $('.charjp ul').slideUp();
      $('.charjv ul').slideUp();
      $('.charjj ul').slideToggle(400);
    });

    $('.charjh').on('click', function () {
      $('.charjj ul').slideUp();
      $('.charj ul').slideUp();
      $('.charjs ul').slideUp();
      $('.charjp ul').slideUp();
      $('.charv ul').slideUp();
      $('.charjh ul').slideToggle(400);
    });
    $('.charjs').on('click', function () {
      $('.charjj ul').slideUp();
      $('.charjh ul').slideUp();
      $('.charj ul').slideUp();
      $('.charjp ul').slideUp();
      $('.charjv ul').slideUp();
      $('.charjs ul').slideToggle(400);
    });
    $('.charjp').on('click', function () {
      $('.charjj ul').slideUp();
      $('.charjh ul').slideUp();
      $('.charj ul').slideUp();
      $('.charjs ul').slideUp();
      $('.charjv ul').slideUp();
      $('.charjp ul').slideToggle(400);
    });
    $('.charjv').on('click', function () {
      $('.charj ul').slideUp();
      $('.charjh ul').slideUp();
      $('.charjs ul').slideUp();
      $('.charjj ul').slideUp();
      $('.charjp ul').slideUp();
      $('.charjv ul').slideToggle(400);
    });
  }
  

}
