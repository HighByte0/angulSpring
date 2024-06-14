import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FourinsseursComponent } from './fourinsseurs.component';

describe('FourinsseursComponent', () => {
  let component: FourinsseursComponent;
  let fixture: ComponentFixture<FourinsseursComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FourinsseursComponent]
    });
    fixture = TestBed.createComponent(FourinsseursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
