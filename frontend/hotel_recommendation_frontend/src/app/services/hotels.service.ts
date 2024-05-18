import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotels } from '../common/hotels';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class HotelsService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json',
      'token': localStorage.getItem("token") || ''
    })
  }

  constructor(private http: HttpClient) { }

  public getHotels(latitude: number, longitude: number): Observable<Hotels[]> {
    const hotelsRequest = {
      latitude: latitude,
      longitude: longitude,
    }
    return this.http.post<Hotels[]>(environment.apiUrl+environment.hotelsEndpoint, JSON.stringify(hotelsRequest), this.httpOptions)
  }
}
