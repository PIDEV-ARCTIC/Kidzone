import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeabsenceComponent } from './listeabsence.component';

describe('ListeabsenceComponent', () => {
  let component: ListeabsenceComponent;
  let fixture: ComponentFixture<ListeabsenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeabsenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeabsenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
