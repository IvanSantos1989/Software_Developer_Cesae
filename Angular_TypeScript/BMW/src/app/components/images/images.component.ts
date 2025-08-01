import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-images',
  imports: [],
  templateUrl: './images.component.html',
  styleUrl: './images.component.scss'
})
export class ImagesComponent {
  @Input() src = '';
  @Input() alt = '';
}
