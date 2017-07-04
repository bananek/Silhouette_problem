/**
 * Created by BanaN on 6/19/2017.
 */
import { Component, OnInit } from '@angular/core';
import {CartService} from './cart.service';
import {Cart} from './cart';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './cart.component.html',
})
export class CartComponent implements OnInit {

  mercs: Cart[];

  cartForm: FormGroup;

  constructor(private cartService: CartService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.cartService.getCart().subscribe(data => this.mercs = data);
    console.log(this.route.snapshot.params);
  }

  remove(cart: Cart) {
    this.cartService.removeFromCart(cart.title);
  }

}
