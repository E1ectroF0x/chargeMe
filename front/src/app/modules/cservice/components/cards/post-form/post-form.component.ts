import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CService} from '../../../models/c-service';


@Component ({
  selector: 'app-card-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent {

  @Input() isPost: boolean;
  @Output() post: EventEmitter<any> = new EventEmitter<any>();
  @Output() isPostChange: EventEmitter<any> = new EventEmitter<any>();

  private cservice: CService = new CService();

  constructor() {}

  private onClose(): void {
    this.isPostChange.emit();
  }

  private onPost(cservice: CService): void {
    this.isPost = false;
    this.post.emit(cservice);
  }

}
