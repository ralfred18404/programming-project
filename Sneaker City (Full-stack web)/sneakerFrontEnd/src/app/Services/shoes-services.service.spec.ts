import { TestBed } from '@angular/core/testing';

import { ShoesServicesService } from './shoes-services.service';

describe('ShoesServicesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ShoesServicesService = TestBed.get(ShoesServicesService);
    expect(service).toBeTruthy();
  });
});
