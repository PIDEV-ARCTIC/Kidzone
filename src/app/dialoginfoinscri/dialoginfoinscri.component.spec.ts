import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialoginfoinscriComponent } from './dialoginfoinscri.component';

describe('DialoginfoinscriComponent', () => {
  let component: DialoginfoinscriComponent;
  let fixture: ComponentFixture<DialoginfoinscriComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialoginfoinscriComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialoginfoinscriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
