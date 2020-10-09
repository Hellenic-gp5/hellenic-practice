import { AuthService } from '../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  bidderRegisterForm: FormGroup;
  allAlert: String;
  statusMsg: String;
  data: any;

  // Getter Methods for shortening in form validation in html

  get role() {
    return this.bidderRegisterForm.get('role');
  }
  get name() {
    return this.bidderRegisterForm.get('name');
  }
  get emailId() {
    return this.bidderRegisterForm.get('emailId');
  }
  get bidderContact() {
    return this.bidderRegisterForm.get('bidderContact');
  }
  get bidderAddressLine1() {
    return this.bidderRegisterForm.get('bidderAddressLine1');
  }
  get bidderAddressLine2() {
    return this.bidderRegisterForm.get('bidderAddressLine2');
  }
  get bidderAccnountNumber() {
    return this.bidderRegisterForm.get('bidderAccnountNumber');
  }
  get bidderIFSC() {
    return this.bidderRegisterForm.get('bidderIFSC');
  }
  get bidderAADHAR() {
    return this.bidderRegisterForm.get('bidderAADHAR');
  }
  get bidderPAN() {
    return this.bidderRegisterForm.get('bidderPAN');
  }
  get bidderLicense() {
    return this.bidderRegisterForm.get('bidderLicense');
  }
  get password() {
    return this.bidderRegisterForm.get('password');
  }
  get confirmPassword() {
  return this.bidderRegisterForm.get('confirmPassword');
  }
  get bidderState() {
    return this.bidderRegisterForm.get('bidderState');
  }
  get bidderCity() {
    return this.bidderRegisterForm.get('bidderCity');
  }

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.createBidderRegisterForm();
  }
  createBidderRegisterForm(): void {
    this.bidderRegisterForm = this.fb.group({
      name: [
        '',
        [
          Validators.required,
          Validators.pattern('^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$'),
        ],
      ],
      emailId: ['', [Validators.required, Validators.email]],
      bidderContact: [
        '',
        [Validators.required, Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')],
      ],
      bidderAddressLine1: [
        '',
        [Validators.required, Validators.maxLength(255)],
      ],
      bidderAddressLine2: [
        '',
        [Validators.required, Validators.maxLength(255)],
      ],
      bidderAccnountNumber: [
        '',
        [Validators.required, Validators.pattern('^[0-9]{9,18}?$')],
      ],
      bidderIFSC: [
        '',
        [Validators.required, Validators.pattern('^[A-Z]{4}0[A-Z0-9]{6}$')],
      ],
      bidderAADHAR: ['', Validators.required],
      bidderPAN: ['', Validators.required],
      bidderState: ['', Validators.required],
      bidderCity: ['', Validators.required],
      bidderLicense: ['', Validators.required],
      password: [
        '',
        [
          Validators.required,
          Validators.pattern(
            '^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$'
          ),
        ],
      ],
      confirmPassword: [],
        
      
    });
  }
  onRegister(): void {
    
if (this.bidderRegisterForm.valid) {
      this.register();
    } else {
      this.allAlert = 'All fields are mandatory to register.';
    }
  }
  register() {
    this.authService
      .bidderRegister(this.bidderRegisterForm.value)
      .subscribe((response) => {
        this.data = response;
      });
    this.router.navigate(['/login']);
  }

  selectedCountry: String = '--Choose State--';
  States: Array<any> = [
    {
      name: 'Maharashtra',
      cities: ['Mumbai', 'Pune'],
    },
    { name: 'Uttar Pradesh', cities: ['Lucknow', 'Allahabad', 'Kanpur'] },
    { name: 'Kerala', cities: ['Kochi', 'Thiruvanthapuram'] },
    { name: 'Rajasthan', cities: ['Jaipur', 'Udaipur'] },
    { name: 'Karnataka', cities: ['Bengaluru', 'Mangalore', 'Hubli'] },
  ];

  cities: Array<any>;

  changeState(state) {
    this.cities = this.States.find((cntry) => cntry.name == state).cities;
  }
}
