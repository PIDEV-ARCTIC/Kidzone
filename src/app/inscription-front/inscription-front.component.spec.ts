import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionFrontComponent } from './inscription-front.component';

describe('InscriptionFrontComponent', () => {
  let component: InscriptionFrontComponent;
  let fixture: ComponentFixture<InscriptionFrontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionFrontComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionFrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
