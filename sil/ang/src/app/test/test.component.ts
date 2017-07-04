
import { Component, OnInit } from '@angular/core';
import {TestService} from './test.service';
import {Test} from './test';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './test.component.html',
})
export class TestComponent implements OnInit {

  tests: Test[];

  testForm: FormGroup;

  constructor(private testService: TestService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.testService.getTest().subscribe(data => this.tests = data);
    console.log(this.route.snapshot.params);
  }
/*
  remove(t: number) {
    this.testService.removetest(t);
  }*/

  add(t: number) {
    this.testService.add(t);
  }

}
