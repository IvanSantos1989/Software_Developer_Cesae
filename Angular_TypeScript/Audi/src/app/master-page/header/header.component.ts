import { Component } from '@angular/core';
import {MdbCollapseModule} from 'mdb-angular-ui-kit/collapse';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [
    MdbCollapseModule,
    RouterLink
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

}
