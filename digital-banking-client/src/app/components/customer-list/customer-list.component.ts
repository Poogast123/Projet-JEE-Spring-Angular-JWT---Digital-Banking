import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { CustomerDTO } from '../../models/customer-dto';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: CustomerDTO[] = [];

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.customerService.getAllCustomers().subscribe(
      (data) => this.customers = data,
      (error) => console.error('Error fetching customers', error)
    );
  }

  deleteCustomer(id: string): void {
    this.customerService.deleteCustomer(id).subscribe(
      () => this.loadCustomers(),
      (error) => console.error('Error deleting customer', error)
    );
  }
}