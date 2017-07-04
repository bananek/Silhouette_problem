import { Component, OnInit } from '@angular/core';
import {CategoryService} from '../category/category.service';
import {Category} from '../category/category';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './acategory.component.html',
})
export class ACategoryComponent implements OnInit {

  categories: Category[];
  edcat: Category;
  categoryForm: FormGroup;
  edForm: FormGroup;
  step = 'show';

  constructor(private categoryService: CategoryService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.categoryService.getCategories().subscribe(data => this.categories = data);
    console.log(this.route.snapshot.params);

    this.categoryForm = new FormGroup({
      gid: new FormControl('', Validators.required),
      genre: new FormControl( '', Validators.required)
    });

    this.edForm = new FormGroup({
      gid: new FormControl('', Validators.required),
      genre: new FormControl( '', Validators.required)
    });

    this.step = 'show';
  }


  addNewCategory(event) {
    this.step = 'add';

    console.log('HERE' + event.title);
    console.log(this.categoryForm.value);
    this.categoryService.sendToPlay(this.categoryForm.value);

      this.step = 'added';
  }

  delete(category: Category) {
    this.categoryService.delete(category.gid);

    this.step = 'deleted';
  }

  back() {
    this.step = 'show';
    console.log('button, step = ' + this.step);
  }

}
