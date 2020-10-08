import { TestBed } from '@angular/core/testing';

import { MaketplaceService } from './maketplace.service';

describe('MaketplaceService', () => {
  let service: MaketplaceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MaketplaceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
