import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoppingCartByOrderComponent } from './shopping-cart-by-order.component';

describe('ShoppingCartByOrderComponent', () => {
  let component: ShoppingCartByOrderComponent;
  let fixture: ComponentFixture<ShoppingCartByOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShoppingCartByOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShoppingCartByOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
