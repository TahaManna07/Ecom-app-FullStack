import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrl: './order-details.component.css'
})
export class OrderDetailsComponent implements OnInit{
  orderId !: string;
  orderDetails : any;
  constructor(private httpClient : HttpClient, private route : ActivatedRoute) {
    this.orderId = this.route.snapshot.params['id']
  }

  ngOnInit(): void {
    this.httpClient.get("http://localhost:8082/api/orders/"+this.orderId).subscribe({
      next : order => {
        this.orderDetails = order;
        console.log(this.orderDetails);

      },
      error : err =>{
        console.log(err);
      }
    })
  }
  getTotal(orderDetails: any): number {
    let total: number = 0;

    // Vérifiez si productItemList est défini
    if (orderDetails && orderDetails.productItemList) {
      for (let item of orderDetails.productItemList) {
        total += (item.quantity || 0) * (item.price || 0); // Utilisez une valeur par défaut si quantity ou price est undefined
      }
    }

    return total;
  }


}
