import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-farmer-register',
  templateUrl: './farmer-register.component.html',
  styleUrls: ['./farmer-register.component.css'],
})
export class FarmerRegisterComponent implements OnInit {
  farmerRegisterForm: FormGroup;
  allAlert: String;
  data: any;

  rolee: string = 'farmer';
  // Getter Methods for shortening in form validation in html

  get role() {
    return this.farmerRegisterForm.get('rolee').value;
  }
  get userName() {
    return this.farmerRegisterForm.get('userName');
  }
  get email() {
    return this.farmerRegisterForm.get('email');
  }
  get contact() {
    return this.farmerRegisterForm.get('contact');
  }
  get address() {
    return this.farmerRegisterForm.get('address');
  }
  get landAddress() {
    return this.farmerRegisterForm.get('landAddress');
  }
  get area() {
    return this.farmerRegisterForm.get('area');
  }
  get pincode() {
    return this.farmerRegisterForm.get('pincode');
  }
  get accno() {
    return this.farmerRegisterForm.get('accno');
  }
  get ifsc() {
    return this.farmerRegisterForm.get('ifsc');
  }
  get aadhar() {
    return this.farmerRegisterForm.get('aadhar');
  }
  get pan() {
    return this.farmerRegisterForm.get('pan');
  }
  get certificate() {
    return this.farmerRegisterForm.get('certificate');
  }
  get password() {
    return this.farmerRegisterForm.get('password');
  }
  get confirmPassword() {
    return this.farmerRegisterForm.get('confirmPassword');
  }
  get state() {
    return this.farmerRegisterForm.get('state');
  }
  get city() {
    return this.farmerRegisterForm.get('city');
  }

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.createFarmerRegisterForm();
  }
  createFarmerRegisterForm(): void {
    this.farmerRegisterForm = this.fb.group({
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
      landAddress: ['', [Validators.required, Validators.maxLength(255)]],
      area: ['', Validators.required],
      state: ['', Validators.required],
      city: ['', Validators.required],
      pincode: [
        '',
        [Validators.required, Validators.pattern('^[1-9][0-9]{5}$')],
      ],
      accno: ['', [Validators.required, Validators.pattern('^[0-9]{9,18}?$')]],
      ifsc: [
        '',
        [Validators.required, Validators.pattern('^[A-Z]{4}0[A-Z0-9]{6}$')],
      ],
      aadhar: ['', Validators.required],
      pan: ['', Validators.required],
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
    // console.log(this.farmerRegisterForm.value); //testing purpose only
    if (this.farmerRegisterForm.valid) {
      this.register();
      // this.router.navigate(['/login']);
    } else {
      this.allAlert = 'All fields are mandatory to register.';
    }
  }
  register() {
    this.authService
      .farmerRegister(this.farmerRegisterForm.value)
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

  //cities: Array<any>;

  changeState(state) {
    this.cities = this.States.find((cntry) => cntry.name == state).cities;
  }

  //changeState(state) {
  //this.cities = this.Countries.find(cntry => cntry.name == this.selectedCountry).states.find(stat => stat.name == state).cities;
  //}
}
