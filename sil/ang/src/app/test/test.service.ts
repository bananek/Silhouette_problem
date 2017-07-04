import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, URLSearchParams, Response} from '@angular/http';
import {Test} from './test';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class TestService {

  constructor(private http: Http) { }

  getTest() {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    return this.http.get('http://localhost:9000/showtest', options)
      .map(response => <Test[]>response.json());
  }


  removetest(t: number) {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    this.http.get('http://localhost:9000/removetest' + t, options)
      .subscribe(
        data => console.log('basket remove sent!', data),
        error => console.error('basket remove error', error)
      );
  }

  add(formData) {
    const serializedForm = JSON.stringify(formData);
    // console.log(serializedForm);

    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    this.http.post('http://localhost:9000/newtest', serializedForm, options)
      .subscribe(
        data => console.log('wyslane!', data),
        error => console.error('nie bangla', error)
      );
  }

  add2(price: number) {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    this.http.get('http://localhost:9000/newtest/' + price, options)
      .subscribe(
        data => console.log('basket remove sent!', data),
        error => console.error('basket remove error', error)
      );
  }

}
