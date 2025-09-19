import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink, MdbCollapseModule, MdbRippleModule],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {}
