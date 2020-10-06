import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.css'],
})
export class ApplyComponent implements OnInit {
  policyApplyForm: FormGroup;
  allAlert: String;

  get season() {
    return this.policyApplyForm.get('season');
  }
  get year() {
    return this.policyApplyForm.get('year');
  }
  get crop() {
    return this.policyApplyForm.get('crop');
  }

  get sumInsured() {
    return this.policyApplyForm.get('sumInsured');
  }

  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.createPolicyApplyForm();
  }
  createPolicyApplyForm(): void {
    this.policyApplyForm = this.fb.group({
      season: [
        '',
        [
          Validators.required,
          Validators.pattern('^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$'),
        ],
      ],
      year: [
        '',
        [
          Validators.required,
          Validators.pattern(
            '?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))'
          ),
        ],
      ],
      crop: [
        '',
        [
          Validators.required,
          Validators.pattern('^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$'),
        ],
      ],
      sumInsured: ['', [Validators.required, Validators.pattern('[1-9]')]],
    });
  }

  onApply(): void {
    // console.log(this.farmerRegisterForm.value); //testing purpose only
    if (this.policyApplyForm.valid) {
      // this.register();
      this.router.navigate(['/login']);
    } else {
      this.allAlert = 'All fields are mandatory to register.';
    }
  }
}
