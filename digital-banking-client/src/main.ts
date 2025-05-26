import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  imports: [CommonModule], 
  selector: 'app-root',
  template: `
    <h1>Welcome to {{title}}!</h1>
    <p>Current date: {{currentDate | date}}</p>
    
    <ul>
      <li *ngFor="let item of items">{{item}}</li>
    </ul>
  `,
  styles: [`
    h1 { color: #3f51b5; }
    ul { margin-top: 20px; }
  `]
})
export class AppComponent {
  title = 'My Standalone App';
  currentDate = new Date();
  items = ['Angular', 'Standalone', 'Components'];
}