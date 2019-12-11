import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CService} from '../../../models/c-service';
import {FormControl, FormGroup, Validators} from '@angular/forms';


@Component ({
  selector: 'app-card-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent {

  postForm = new FormGroup({
    name_: new FormControl('', Validators.required),
    cost_: new FormControl('', [Validators.required, Validators.pattern(/[0-9]/)]),
    genre_: new FormControl('', Validators.required)
  });

  @Input() isPost: boolean;
  @Output() post: EventEmitter<any> = new EventEmitter();
  @Output() isPostChange: EventEmitter<void> = new EventEmitter();
  private uploadImage: File;

  private cservice: CService = new CService();

  constructor() {}

  public isFormValid(formControl: string): boolean {
    const control = this.postForm.controls[formControl];
    return control.invalid && control.touched;
  }

  public onFileChange(event) {
    this.uploadImage = event.target.files[0];
  }

  private onClose(): void {
    this.isPostChange.emit();
  }

  private onPost(cservice: CService): void {
    const controls = this.postForm.controls;
    if (this.postForm.invalid) {
      Object.keys(controls).forEach(control => controls[control].markAsTouched());
      return;
    }

    this.isPost = false;
    this.post.emit({cservicer: cservice, image: this.uploadImage} );
  }

}
