import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EncaissementcComponent } from './encaissementc.component';

describe('EncaissementcComponent', () => {
  let component: EncaissementcComponent;
  let fixture: ComponentFixture<EncaissementcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EncaissementcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EncaissementcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
