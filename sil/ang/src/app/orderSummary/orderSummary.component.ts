import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import {Order} from './order';
import {Cart} from '../cart/cart';
import {OrderService} from './order.service';
import {CartService} from '../cart/cart.service';
import {ParcelService} from '../parcel/parcel.service';
import {Parcel} from '../parcel/parcel';

@Component({
  selector: 'app-ordersummary',
  templateUrl: './orderSummary.component.html',
})
export class OrderSummaryComponent implements OnInit {

  productForm: FormGroup;
  mercs: Cart[];
  orderForm: FormGroup;
  shipment = ['DHL', 'UPS'];

  payment = ['paypal', 'money transfer']

  address = ''

  model = new Order();
  step = 1;
  totalPrice = 0;

  constructor( private cartService: CartService, private orderService: OrderService,
               private route: ActivatedRoute, private parcelService: ParcelService) { }

  ngOnInit() {
    this.model.payment = this.payment[0];
    this.model.shipment = this.shipment[0];
    this.model.address = this.address[0];
    this.cartService.getCart().subscribe(data => this.mercs = data);

    this.orderForm = new FormGroup({
      oid: new FormControl('', Validators.required),
      productlist: new FormControl( '', Validators.required),
      shipment: new FormControl( '', Validators.required),
      payment: new FormControl( '', Validators.required),
      price: new FormControl( '', Validators.required),
      uid: new FormControl( '', Validators.required),
      address: new FormControl( '', Validators.required)
    });
  }

  showSummary() {
    this.Total();
    this.step = 2;
  }

  Total() {
    let price = 0;
    for (let i = 0; i < this.mercs.length; i++) {
      price += this.mercs[i].price;
    }
    this.totalPrice = price;
  }

  addOrder(event) {
    this.step = 0;

    console.log('HERE NEW ORDER SEND ' + event.title);
    console.log(this.orderForm.value);
    this.orderService.sendToPlay(this.orderForm.value);


  }


  sendOrder() {

    let uid = 'admin';

    let products = '';
    for (let i = 0; i < this.mercs.length; i++) {
      products += this.mercs[i].title + '';
      this.cartService.removeFromCart(this.mercs[i].title);
    }

    this.orderForm.controls['oid'].setValue(0);
    this.orderForm.controls['productlist'].setValue(products);
    this.orderForm.controls['shipment'].setValue(this.model.shipment);
    this.orderForm.controls['payment'].setValue(this.model.payment);
    this.orderForm.controls['price'].setValue(this.totalPrice);
    this.orderForm.controls['uid'].setValue(uid);
    this.orderForm.controls['address'].setValue(this.model.address);

    /*
    this.orderService.sendOrder(products,
      this.model.shipment,
      this.model.payment,
      this.totalPrice,
      uid,
      this.model.address,
      );*/

    this.parcelService.sendToPlay(this.orderForm.value);

    this.step = 3;
  }
}
