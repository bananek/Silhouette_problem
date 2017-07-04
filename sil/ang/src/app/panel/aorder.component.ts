import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import {Parcel} from '../parcel/parcel';
import {ParcelService} from '../parcel/parcel.service';

@Component({
  selector: 'app-product',
  templateUrl: './aorder.component.html'
})
export class AOrderComponent implements OnInit {

  parcels: Parcel[];
  step = 'show';

  constructor(private parcelService: ParcelService, private route: ActivatedRoute) { }

  ngOnInit() {

    this.showAllParcels();


  }

  showAllParcels() {
    this.parcelService.getParcels().subscribe(data => this.parcels = data);
  }

  delete(parcel: Parcel) {
    this.parcelService.delete(parcel.oid);

    this.step = 'deleted';
  }

}
