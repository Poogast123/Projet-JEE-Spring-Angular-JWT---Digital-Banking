import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes'; // Create this file

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes)
  ]
};