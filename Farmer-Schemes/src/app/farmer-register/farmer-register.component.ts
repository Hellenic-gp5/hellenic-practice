import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FarmerRegisterModel } from '../FarmerRegister.module';

@Component({
  selector: 'app-farmer-register',
  templateUrl: './farmer-register.component.html',
  styleUrls: ['./farmer-register.component.css'],
})
export class FarmerRegisterComponent implements OnInit {
  farmerRegisterForm: FormGroup;
  allAlert: String;
  data: any;
  farmer: FarmerRegisterModel;

  // Getter Methods for shortening in form validation in html

  get name() {
    return this.farmerRegisterForm.get('name');
  }
  get emailId() {
    return this.farmerRegisterForm.get('emailId');
  }
  get farmerContact() {
    return this.farmerRegisterForm.get('farmerContact');
  }
  get farmerAddressLine1() {
    return this.farmerRegisterForm.get('farmerAddressLine1');
  }
  get farmerLandAddress() {
    return this.farmerRegisterForm.get('farmerLandAddress');
  }
  get farmerLandArea() {
    return this.farmerRegisterForm.get('farmerLandArea');
  }
  get farmerLandPIN() {
    return this.farmerRegisterForm.get('farmerLandPIN');
  }
  get farmerAccountNumber() {
    return this.farmerRegisterForm.get('farmerAccountNumber');
  }
  get farmerIFSC() {
    return this.farmerRegisterForm.get('farmerIFSC');
  }
  get farmerAADHAR() {
    //this.farmerAADHAR.setValue('assets/img/document/');
    return this.farmerRegisterForm.get('farmerAADHAR');
  }
  get farmerPAN() {
    // this.farmerPAN.setValue('');
    return this.farmerRegisterForm.get('farmerPAN');
  }
  get farmerCertificate() {
    // this.farmerCertificate.setValue('');
    return this.farmerRegisterForm.get('farmerCertificate');
  }
  get password() {
    return this.farmerRegisterForm.get('password');
  }

  get farmerState() {
    return this.farmerRegisterForm.get('farmerState');
  }
  get farmerCity() {
    return this.farmerRegisterForm.get('farmerCity');
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
      name: [
        '',
        [
          Validators.required,
          Validators.pattern('^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$'),
        ],
      ],
      emailId: ['', [Validators.required, Validators.email]],
      farmerContact: [
        '',
        [Validators.required, Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')],
      ],
      farmerAddressLine1: [
        '',
        [Validators.required, Validators.maxLength(255)],
      ],
      farmerLandAddress: ['', [Validators.required, Validators.maxLength(255)]],
      farmerLandArea: ['', Validators.required],
      farmerState: ['', Validators.required],
      farmerCity: ['', Validators.required],
      farmerLandPIN: [
        '',
        [Validators.required, Validators.pattern('^[1-9][0-9]{5}$')],
      ],
      farmerAccountNumber: [
        '',
        [Validators.required, Validators.pattern('^[0-9]{9,18}?$')],
      ],
      farmerIFSC: [
        '',
        [Validators.required, Validators.pattern('^[A-Z]{4}0[A-Z0-9]{6}$')],
      ],
      farmerAADHAR: ['', Validators.required],
      farmerPAN: ['', Validators.required],
      farmerCertificate: ['', Validators.required],
      password: [
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
      cities: ['Mumbai', 'Pune'],
    },
    { name: 'Uttar Pradesh', cities: ['Lucknow', 'Allahabad', 'Kanpur'] },
    { name: 'Kerala', cities: ['Kochi', 'Thiruvanthapuram'] },
    { name: 'Rajasthan', cities: ['Jaipur', 'Udaipur'] },
    { name: 'Karnataka', cities: ['Bengaluru', 'Mangalore', 'Hubli'] },
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
