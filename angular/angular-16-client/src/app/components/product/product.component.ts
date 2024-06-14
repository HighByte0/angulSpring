// product.component.ts

import { Component, OnInit } from '@angular/core';
import { Product } from '../models/prod.module'; // Import the Product interface
import { ProductService } from '../services/product.service'; // Import ProductService or whatever service you are using to manage products

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  product: Product = { id_prod: 0, nom_prod: '', prix: 0, quantite_stock: 0, id_fournisseur: 0 };
  editing = false;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts() {
    this.productService.getProducts().subscribe(products => {
      this.products = products;
    });
  }

  onSubmit() {
    if (this.editing) {
      this.productService.updateProduct(this.product).subscribe(() => {
        this.editing = false;
        this.product = { id_prod: 0, nom_prod: '', prix: 0, quantite_stock: 0, id_fournisseur: 0  };
        this.loadProducts();
      });
    } else {
      this.productService.addProduct(this.product).subscribe(() => {
        this.product = { id_prod: 0, nom_prod: '', prix: 0, quantite_stock: 0,  id_fournisseur: 0  };
        this.loadProducts();
      });
    }
  }

  editProduct(product: Product) {
    this.editing = true;
    this.product = product;
  }

  deleteProduct(product: Product) {
    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(product.id_prod).subscribe(() => {
        this.loadProducts();
      });
    }
  }
}
