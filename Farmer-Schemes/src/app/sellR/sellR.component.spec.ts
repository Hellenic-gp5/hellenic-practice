import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellRComponent } from './sellR.component';

describe('SellComponent', () => {
  let component: SellRComponent;
  let fixture: ComponentFixture<SellRComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SellRComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
