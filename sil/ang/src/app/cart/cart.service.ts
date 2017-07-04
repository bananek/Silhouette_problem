/**
 * Created by BanaN on 6/19/2017.
 */
import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, URLSearchParams} from '@angular/http';
import {Cart} from './cart';
import 'rxjs/add/operator/map';

@Injectable()
export class CartService {


  constructor(private http: Http) {
  }


  getCart() {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');


    let uid = 'admin';

    let params: URLSearchParams = new URLSearchParams();
    params.set('uid', uid);

    const options = new RequestOptions({headers: headers});

    return this.http.get('http://localhost:9000/cart', options)
      .map(response => <Cart[]>response.json());

  }

  removeFromCart(title: String) {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    this.http.get('http://localhost:9000/removefromcart/' + title, options)
      .subscribe(
        data => console.log('remove from cart', data),
        error => console.error('error', error)
      );
  }

  addToCart(title: String, price: number) {

    let uid = 'admin';

    const serializedJson = JSON.stringify({
      'title': title,
      'price': Number(price),
      'uid': uid
    })

    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    this.http.post('http://localhost:9000/addtocart', serializedJson, options)
      .subscribe(
        data => console.log('product added to cart', data),
        error => console.error('adding to cart error', error)
      );
  }

}
