import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerDTO } from '../models/customer-dto';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiUrl = '/api/customers';

  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<CustomerDTO[]> {
    return this.http.get<CustomerDTO[]>(this.apiUrl);
  }

  createCustomer(customer: CustomerDTO): Observable<CustomerDTO> {
    return this.http.post<CustomerDTO>(this.apiUrl, customer);
  }

  deleteCustomer(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}