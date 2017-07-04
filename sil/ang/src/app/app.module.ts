import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { CategoryComponent } from './category/category.component';
import { ShowProductComponent } from './showProduct/showProduct.component';
import { CartComponent } from './cart/cart.component';
import { PageNotFoundComponent } from './not-found/not-found.component';
import { MainPageComponent } from './mainPage/mainPage.component';
import { PanelComponent } from './panel/panel.component';
import { AProductComponent } from './panel/aproduct.component';
import { ACategoryComponent } from './panel/acategory.component';
import { AOrderComponent } from './panel/aorder.component';
import { TestComponent } from './test/test.component';
import { OrderSummaryComponent } from './orderSummary/orderSummary.component';
import { ParcelComponent } from './parcel/parcel.component';
import { SignInComponent } from './login/SignIn.component';


import { ProductService } from './product/product.service';
import { CartService } from './cart/cart.service';
import { CategoryService } from './category/category.service';
import { TestService } from './test/test.service';
import { OrderService } from './orderSummary/order.service';
import { ParcelService } from './parcel/parcel.service';
import {SignInService } from './login/SignIn.service';



@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    CategoryComponent,
    ShowProductComponent,
    PageNotFoundComponent,
    CartComponent,
    TestComponent,
    OrderSummaryComponent,
    MainPageComponent,
    PanelComponent,
    AProductComponent,
    ACategoryComponent,
    AOrderComponent,
    ParcelComponent,
    SignInComponent
  ],
  imports: [
    HttpModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule,
    BrowserModule,
    RouterModule.forRoot([
      { path: '.', component: AppComponent},
      { path: 'test', component: TestComponent},
      { path: 'index.html', component: MainPageComponent},
      { path: 'mainPage', component: MainPageComponent},
      { path: 'panel', component: PanelComponent},
      { path: 'login', component: SignInComponent},
      { path: 'admin/products', component: AProductComponent },
      { path: 'admin/categories', component: ACategoryComponent },
      { path: 'admin/parcels', component: ParcelComponent},
      { path: 'admin/orders', component: AOrderComponent },
      { path: 'products', component: ProductComponent},
      { path: 'category/:id', component: ProductComponent},
      { path: 'categories', component: CategoryComponent},
      { path: 'cart', component: CartComponent},
      { path: 'orderSummary', component: OrderSummaryComponent},
      { path: 'showProduct/:id', component: ShowProductComponent},
      { path: 'moreparams/:tytul/:opis', component: ProductComponent},
      { path: '', redirectTo: 'mainPage', pathMatch: 'full'},
      { path: '**', component: PageNotFoundComponent }
      ])
  ],
  providers: [ProductService,
              CartService,
              CategoryService,
              TestService,
              OrderService,
              ParcelService,
              SignInService],
  bootstrap: [AppComponent]

})
export class AppModule { }
