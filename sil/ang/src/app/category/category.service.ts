import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, URLSearchParams,} from '@angular/http';
import {Category} from './category';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class CategoryService {

  constructor(private http: Http) { }

  getCategories() {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    return this.http.get('http://localhost:9000/categories', options)
      .map(response => <Category[]>response.json());
  }


  sendToPlay(formData) {
    const serializedForm = JSON.stringify(formData);
    console.log(serializedForm);

    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});

    this.http.post('http://localhost:9000/newcategory', serializedForm, options)
      .subscribe(
        data => console.log('wyslane!', data),
        error => console.error('nie bangla', error)
      );
  }

  delete(gid: number) {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    this.http.get('http://localhost:9000/removecategory/' + gid, options)
      .subscribe(
        data => console.log('remove cat', data),
        error => console.error('error while removing cat', error)
      );
  }

}
