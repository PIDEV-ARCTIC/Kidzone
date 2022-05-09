import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EtatcaisseComponent } from './etatcaisse.component';

describe('EtatcaisseComponent', () => {
  let component: EtatcaisseComponent;
  let fixture: ComponentFixture<EtatcaisseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EtatcaisseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EtatcaisseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
