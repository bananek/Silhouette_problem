/**
 * Created by BanaN on 6/29/2017.
 */


import { Component, OnInit } from '@angular/core';
import {ProductService} from '../product/product.service';
import {Product} from '../product/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './aproduct.component.html',
  styleUrls: ['../product/product.component.css']
})
export class AProductComponent {

  products: Product[];
  edprod: Product;
  productForm: FormGroup;
  edForm: FormGroup;
  step = 'show';

  constructor(private productService: ProductService, private route: ActivatedRoute) { }

  ngOnInit() {
    let pid = this.route.snapshot.params['id'];
    if(pid) {
      this.showProductsFromCategory(pid);
    } else {
      this.showAllProducts();
    }

    this.productForm = new FormGroup({
      title: new FormControl( '', Validators.required),
      author: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      pid: new FormControl('', Validators.required),
      gid: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required)
    });

    this.edForm = new FormGroup({
      title: new FormControl( '', Validators.required),
      author: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      pid: new FormControl('', Validators.required),
      gid: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required)
    });

    this.step = 'show';
  }

  showProductsFromCategory(id: number) {
    this.productService.getProductsFromCategory(id).subscribe(data => this.products = data);
  }

  showAllProducts() {
    this.productService.getProducts().subscribe(data => this.products = data);
  }

  addNewProduct(event) {
    this.step = 'add';

    console.log('HERE' + event.title);
    console.log(this.productForm.value);
    this.productService.sendToPlay(this.productForm.value);

    this.step = 'added';

  }

  delete(product: Product) {
    this.productService.delete(product.pid);

    this.step = 'deleted';
  }

  edit(id: number) {
    this.productService.getProduct(id).subscribe(
      product => this.edprod = product,
      err => {
        console.log(err);
      },
      () => {
        this.editForm();
      }
    );
  }

  editForm() {

    this.edForm.controls['title'].setValue(this.edprod.title);
    this.edForm.controls['author'].setValue(this.edprod.author);
    this.edForm.controls['description'].setValue(this.edprod.description);
    this.edForm.controls['pid'].setValue(this.edprod.pid);
    this.edForm.controls['gid'].setValue(this.edprod.gid);
    this.edForm.controls['price'].setValue(this.edprod.price);

    this.step = 'edit';
  }


  editProduct(event) {
    this.productService.editProduct(this.edprod.pid, this.edForm.value);

    this.step = 'edited';
  }



}
