import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessfullPaidComponent } from './successfull-paid.component';

describe('SuccessfullPaidComponent', () => {
  let component: SuccessfullPaidComponent;
  let fixture: ComponentFixture<SuccessfullPaidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuccessfullPaidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuccessfullPaidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
