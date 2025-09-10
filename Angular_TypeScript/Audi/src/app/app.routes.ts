import { Routes } from '@angular/router';
import {HomeComponent} from './pages/home/home.component';
import {AboutComponent} from './pages/about/about.component';
import {GalleryComponent} from './pages/gallery/gallery.component';
import {BlogComponent} from './pages/blog/blog.component';
import {ContactusComponent} from './pages/contactus/contactus.component';

export const routes: Routes = [
{
  path:'',
  component: HomeComponent
},
  {
    path:'gallery',
    component: GalleryComponent
  },
  {
    path:'blog',
    component: BlogComponent
  },
  {
    path:'contactus',
    component: ContactusComponent
  },
  {
    path:'about',
    component: AboutComponent
  }
];
