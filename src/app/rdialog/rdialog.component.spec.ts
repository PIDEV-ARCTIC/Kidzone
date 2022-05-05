import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RdialogComponent } from './rdialog.component';

describe('RdialogComponent', () => {
  let component: RdialogComponent;
  let fixture: ComponentFixture<RdialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RdialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RdialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
