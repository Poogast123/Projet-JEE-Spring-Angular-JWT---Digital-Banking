import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,  
  imports: [CommonModule, RouterLink], 
  template: `
    <h1>Welcome to our Digital Banking App</h1>
    
    <section>
      <h2>Latest Features</h2>
      <ul>
        <li>Secure transactions</li>
        <li>24/7 Account access</li>
        <li>Mobile banking</li>
      </ul>
    </section>

    <a routerLink="/dashboard" class="cta-button">Go to Dashboard</a>
  `,
  styles: [`
    h1 { 
      color: #2c3e50;
      margin-bottom: 20px;
    }
    .cta-button {
      display: inline-block;
      padding: 10px 20px;
      background: #3498db;
      color: white;
      text-decoration: none;
      border-radius: 5px;
      margin-top: 20px;
    }
  `]
})
export class HomeComponent {
  // Add component logic here
  currentDate = new Date();
}