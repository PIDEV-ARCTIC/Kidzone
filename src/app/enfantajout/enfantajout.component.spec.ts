import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnfantajoutComponent } from './enfantajout.component';

describe('EnfantajoutComponent', () => {
  let component: EnfantajoutComponent;
  let fixture: ComponentFixture<EnfantajoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnfantajoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EnfantajoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
