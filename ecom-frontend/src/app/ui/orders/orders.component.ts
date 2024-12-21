import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent implements OnInit {
  listOrders !: any;
  constructor(private httpClient : HttpClient,private router : Router) {

  }
  ngOnInit() {
    this.httpClient.get("http://localhost:8082/api/orders").subscribe({
      next : orders => {
        this.listOrders = orders;
      } ,
      error : err => {
        console.log(err)
      }
    })
  }


  getOrderDetails(o : any) {
    this.router.navigateByUrl("/orders-details/"+o.id)
  }
}
