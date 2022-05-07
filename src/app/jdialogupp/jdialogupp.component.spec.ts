import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JdialoguppComponent } from './jdialogupp.component';

describe('JdialoguppComponent', () => {
  let component: JdialoguppComponent;
  let fixture: ComponentFixture<JdialoguppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JdialoguppComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JdialoguppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
