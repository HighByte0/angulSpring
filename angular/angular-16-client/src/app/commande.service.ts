import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Commande } from './components/models/commande.model';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  private baseUrl = 'http://localhost:8080/commandes'; // Replace with your actual API URL

  constructor(private http: HttpClient) { }

  // Fetch all commandes
  getAllCommandes(): Observable<Commande[]> {
    return this.http.get<Commande[]>(`${this.baseUrl}/`);
  }

  // Fetch a single commande by ID
  getCommandeById(id: number): Observable<Commande> {
    return this.http.get<Commande>(`${this.baseUrl}${id}`);
  }

  // Create a new commande
  createCommande(commande: Commande): Observable<Commande> {
    return this.http.post<Commande>(this.baseUrl, commande);
  }

  // Update an existing commande
  updateCommande(id: number, commande: Commande): Observable<Commande> {
    return this.http.put<Commande>(`${this.baseUrl}${id}`, commande);
  }

  // Delete a commande by ID
  deleteCommande(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
