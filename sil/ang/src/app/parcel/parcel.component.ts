/**
 * Created by BanaN on 6/29/2017.
 */


import { Component, OnInit } from '@angular/core';
import {ParcelService} from './parcel.service';
import {Parcel} from './parcel';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-parcel',
  templateUrl: './parcel.component.html',
  styleUrls: ['./parcel.component.css']
})

export class ParcelComponent {

  parcels: Parcel[];
  parcelForm: FormGroup;
  step = 'show';

  constructor(private parcelService: ParcelService, private route: ActivatedRoute) { }

  ngOnInit() {
      this.showAllParcels();


    this.parcelForm = new FormGroup({
      oid: new FormControl('', Validators.required),
      productlist: new FormControl( '', Validators.required),
      shipment: new FormControl( '', Validators.required),
      payment: new FormControl( '', Validators.required),
      price: new FormControl( '', Validators.required),
      uid: new FormControl( '', Validators.required),
      address: new FormControl( '', Validators.required)
    });


    this.step = 'show';
  }


  showAllParcels() {
    this.parcelService.getParcels().subscribe(data => this.parcels = data);
  }

  addNewParcel(event) {
    this.step = 'add';

    console.log('HERE' + event.title);
    console.log(this.parcelForm.value);
    this.parcelService.sendToPlay(this.parcelForm.value);

    this.step = 'added';

  }

  delete(parcel: Parcel) {
    this.parcelService.delete(parcel.oid);

    this.step = 'deleted';
  }




}
