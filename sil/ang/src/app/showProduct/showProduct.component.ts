import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product/product.service';
import { CartService } from '../cart/cart.service';
import {Product} from '../product/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-showproduct',
  templateUrl: './showProduct.component.html',
})
export class ShowProductComponent implements OnInit {

  pid: number;
  product: Product;

  productForm: FormGroup;

  constructor(private productService: ProductService, private cartService: CartService, private route: ActivatedRoute) { }

  ngOnInit(){
    this.pid = this.route.snapshot.params['id'];
    this.productService.getProduct(this.pid).subscribe(
      product => this.product = product,
      err => {
        console.log(err); });

    console.log('product = ' + this.product);
  }

  addProduct() {
    this.cartService.addToCart(this.product.title, this.product.price);
  }

  test(title: String, price: number) {
    this.productService.testing(title, price);
  }

}
