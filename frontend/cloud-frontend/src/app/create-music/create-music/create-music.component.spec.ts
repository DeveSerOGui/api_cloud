import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMusicComponent } from './create-music.component';

describe('CreateMusicComponent', () => {
  let component: CreateMusicComponent;
  let fixture: ComponentFixture<CreateMusicComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateMusicComponent]
    });
    fixture = TestBed.createComponent(CreateMusicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
