import { TestBed } from '@angular/core/testing';

import { UserApprovalService } from './user-approval.service';

describe('UserApprovalService', () => {
  let service: UserApprovalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserApprovalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
