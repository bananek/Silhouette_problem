/**
 * Created by BanaN on 7/1/2017.
 */
import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, URLSearchParams, Response} from '@angular/http';
import {Parcel} from './parcel';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class ParcelService {

  constructor(private http: Http) { }

  getParcels() {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    return this.http.get('http://localhost:9000/pbrowse', options)
      .map(response => <Parcel[]>response.json());
  }


  sendToPlay(formData) {
    const serializedForm = JSON.stringify(formData);
    console.log(serializedForm);

    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    this.http.post('http://localhost:9000/newparcel', serializedForm, options)
      .subscribe(
        data => console.log('wyslane!', data),
        error => console.error('nie bangla', error)
      );
  }


  delete(oid: number) {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    this.http.get('http://localhost:9000/removeparcel/' + oid, options)
      .subscribe(
        data => console.log('remove product', data),
        error => console.error('error while removing product', error)
      );
  }

}
