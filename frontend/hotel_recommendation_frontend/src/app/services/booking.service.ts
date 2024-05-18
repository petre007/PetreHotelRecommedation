import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../common/booking';
import { environment } from 'src/environments/environment.development';
import { Rooms } from '../common/rooms';

const token = localStorage.getItem("token") || '';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json',
      'token': token
    })
  }

  constructor(private http: HttpClient) { }

  public getBookings(): Observable<Booking[]> {
    return this.http.get<Booking[]>(environment.apiUrl+environment.getBookings, this.httpOptions)
  }

  public createBooking(room: Rooms): void {
    this.http.post<any>(environment.apiUrl+environment.createBooking, JSON.stringify(room), this.httpOptions).subscribe(response=>{
      console.log("Room booked")
    })
  }

  public deleteBooking(booking: Booking): void {
    const httpOptionsDelete = {
      headers: new HttpHeaders({
        'Content-Type':'application/json',
        'token': token
      }),
      body: booking
    }
    this.http.delete<any>(environment.apiUrl+environment.deleteBooking, httpOptionsDelete).subscribe(response=>{
      console.log("Booking deleted")
    })
  }
}
