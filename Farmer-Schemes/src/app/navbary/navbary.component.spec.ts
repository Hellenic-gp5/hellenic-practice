import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbaryComponent } from './navbary.component';

describe('NavbarComponent', () => {
  let component: NavbaryComponent;
  let fixture: ComponentFixture<NavbaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
