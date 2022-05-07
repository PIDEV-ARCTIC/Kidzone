import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdialogComponent } from './edialog.component';

describe('EdialogComponent', () => {
  let component: EdialogComponent;
  let fixture: ComponentFixture<EdialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EdialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EdialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
