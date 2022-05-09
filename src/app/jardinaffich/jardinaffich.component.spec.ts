import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JardinaffichComponent } from './jardinaffich.component';

describe('JardinaffichComponent', () => {
  let component: JardinaffichComponent;
  let fixture: ComponentFixture<JardinaffichComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JardinaffichComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JardinaffichComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
