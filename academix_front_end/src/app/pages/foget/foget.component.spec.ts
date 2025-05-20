import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FogetComponent } from './foget.component';

describe('FogetComponent', () => {
  let component: FogetComponent;
  let fixture: ComponentFixture<FogetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FogetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FogetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
