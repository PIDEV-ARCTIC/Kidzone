import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EncaissementfComponent } from './encaissementf.component';

describe('EncaissementfComponent', () => {
  let component: EncaissementfComponent;
  let fixture: ComponentFixture<EncaissementfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EncaissementfComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EncaissementfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
