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
  rolee: string = 'bidder';
  // Getter Methods for shortening in form validation in html

  get role() {
    return this.bidderRegisterForm.get('rolee').value;
  }
  get userName() {
    return this.bidderRegisterForm.get('userName');
  }
  get email() {
    return this.bidderRegisterForm.get('email');
  }
  get contact() {
    return this.bidderRegisterForm.get('contact');
  }
  get address() {
    return this.bidderRegisterForm.get('address');
  }
  get accno() {
    return this.bidderRegisterForm.get('accno');
  }
  get ifsc() {
    return this.bidderRegisterForm.get('ifsc');
  }
  get aadhar() {
    return this.bidderRegisterForm.get('aadhar');
  }
  get pan() {
    return this.bidderRegisterForm.get('pan');
  }
  get certificate() {
    return this.bidderRegisterForm.get('certificate');
  }
  get password() {
    return this.bidderRegisterForm.get('password');
  }
  get confirmPassword() {
    return this.bidderRegisterForm.get('confirmPassword');
  }
  get state() {
    return this.bidderRegisterForm.get('state');
  }
  get city() {
    return this.bidderRegisterForm.get('city');
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
      userName: [
        '',
        [
          Validators.required,
          Validators.pattern('^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$'),
        ],
      ],
      email: ['', [Validators.required, Validators.email]],
      contact: [
        '',
        [Validators.required, Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')],
      ],
      address: ['', [Validators.required, Validators.maxLength(255)]],
      accno: ['', [Validators.required, Validators.pattern('^[0-9]{9,18}?$')]],
      ifsc: [
        '',
        [Validators.required, Validators.pattern('^[A-Z]{4}0[A-Z0-9]{6}$')],
      ],
      aadhar: ['', Validators.required],
      pan: ['', Validators.required],
      state: ['', Validators.required],
      city: ['', Validators.required],
      certificate: ['', Validators.required],
      password: [
        '',
        [
          Validators.required,
          Validators.pattern(
            '^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$'
          ),
        ],
      ],
      confirmPassword: [
        '',
        [
          Validators.required,
          Validators.pattern(
            '^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$'
          ),
        ],
      ],
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
      cities: ['Duesseldorf', 'Leinfelden-Echterdingen', 'Eschborn'],
    },
    { name: 'Uttar Pradesh', cities: ['Barcelona'] },
    { name: 'Kerala', cities: ['Downers Grove'] },
    { name: 'Rajasthan', cities: ['Puebla'] },
    { name: 'Karnataka', cities: ['Delhi', 'Kolkata', 'Mumbai', 'Bangalore'] },
  ];

  cities: Array<any>;

  changeState(state) {
    this.cities = this.States.find((cntry) => cntry.name == state).cities;
  }
}
