import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FdialogComponent } from './fdialog.component';

describe('FdialogComponent', () => {
  let component: FdialogComponent;
  let fixture: ComponentFixture<FdialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FdialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FdialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
