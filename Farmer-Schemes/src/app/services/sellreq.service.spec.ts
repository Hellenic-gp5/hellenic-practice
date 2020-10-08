import { TestBed } from '@angular/core/testing';

import { SellreqService } from './sellreq.service';

describe('SellreqService', () => {
  let service: SellreqService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SellreqService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
