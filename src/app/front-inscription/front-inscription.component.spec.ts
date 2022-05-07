import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FrontInscriptionComponent } from './front-inscription.component';

describe('FrontInscriptionComponent', () => {
  let component: FrontInscriptionComponent;
  let fixture: ComponentFixture<FrontInscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FrontInscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FrontInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
