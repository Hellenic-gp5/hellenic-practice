import { TestBed } from '@angular/core/testing';

import { PolicyreqService } from './policyreq.service';

describe('PolicyreqService', () => {
  let service: PolicyreqService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PolicyreqService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
