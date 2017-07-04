/**
 * Created by BanaN on 7/4/2017.
 */
/**
 * Created by BanaN on 6/19/2017.
 */
import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class SignInService {


  constructor(private http: Http) {
  }


  authenticate(provider: String) {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    const options = new RequestOptions({headers: headers});
    this.http.get('http://localhost:9000/authenticate/' + provider, options)
      .subscribe(
        data => console.log('remove from cart', data),
        error => console.error('error', error)
      );
  }

}
