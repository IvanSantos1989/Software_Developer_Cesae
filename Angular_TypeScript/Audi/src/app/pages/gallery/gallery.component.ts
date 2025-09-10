import { Component } from '@angular/core';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-gallery',
  imports: [
    NgForOf
  ],
  templateUrl: './gallery.component.html',
  styleUrl: './gallery.component.scss'
})
export class GalleryComponent {
  audiImages = [
    'https://images.unsplash.com/photo-1503736334956-4c8f8e92946d',
    'https://images.unsplash.com/photo-1541800658-6599fffd81c1',
    'https://images.unsplash.com/photo-1502161254066-6c74afbf07aa',
    'https://images.unsplash.com/photo-1646405871744-2005e64f8e32',
    'https://images.unsplash.com/photo-1525609004556-c46c7d6cf023',
    'https://images.unsplash.com/photo-1657779912012-a5e59905ffdc',
    'https://images.unsplash.com/photo-1502877338535-766e1452684a',
    'https://images.unsplash.com/photo-1555652736-e92021d28a10'
  ];
}
