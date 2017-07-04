/**
 * Created by BanaN on 6/17/2017.
 */

import { Injectable } from '@angular/core';
import {Order} from './order';
import 'rxjs/add/operator/map';

import {Http, Headers, RequestOptions, URLSearchParams, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';

@Injectable()
export class OrderService {

  constructor(private http: Http) {}

/*  sendOrder( productlist: string, shipment: string,
            payment: string, price: number, uid: string, address: string) {*/

  sendOrder( formData) {

    const serializedForm = JSON.stringify(formData);
    console.log(serializedForm);

    /*
    const serializedOrder = JSON.stringify({
      'oid': 7,
      'productlist': productlist,
      'shipment': shipment,
      'payment': payment,
      'price': Number(price),
      'uid': uid,
      'address': address
    });*/

    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    this.http.post('http://localhost:9000/sendorder', serializedForm, options)
      .subscribe(
        data => console.log('wyslane!', data),
        error => console.error('nie bangla', error)
      );

  }

  sendToPlay(formData) {
    const serializedForm = JSON.stringify(formData);
    console.log(serializedForm);

    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    this.http.post('http://localhost:9000/sendorder', serializedForm, options)
      .subscribe(
        data => console.log('wyslane!', data),
        error => console.error('nie bangla', error)
      );
  }

  getOrders() {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    return this.http.get('http://localhost:9000/showorders', options)
      .map(response => <Order[]>response.json());
  }

  delete(oid: number) {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    this.http.get('http://localhost:9000/removeorder/' + oid, options)
      .subscribe(
        data => console.log('remove order', data),
        error => console.error('error while removing order', error)
      );
  }

}

