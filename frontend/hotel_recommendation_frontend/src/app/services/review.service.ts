import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

const token = localStorage.getItem("token") || '';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json',
      'token': token
    })
  }

  constructor(private http: HttpClient) { }

  public createReview(description: string, hotelId: number | undefined):void {
    const createReviewBody = {
      description: description,
      id: hotelId
    }
    this.http.post<any>(environment.apiUrl+environment.createReview, JSON.stringify(createReviewBody), this.httpOptions).subscribe(response=>{
      console.log("Review created")
    })
  }

}
