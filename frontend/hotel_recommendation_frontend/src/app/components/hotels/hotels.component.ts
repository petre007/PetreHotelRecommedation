import { Component, OnInit } from '@angular/core';
import { Hotels } from 'src/app/common/hotels';
import { Rooms } from 'src/app/common/rooms';
import { BookingService } from 'src/app/services/booking.service';
import { HotelsService } from 'src/app/services/hotels.service';
import { ReviewService } from 'src/app/services/review.service';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  latitude = 0;
  longitude = 0;

  hotels: Hotels[] | undefined;

  constructor(private hotelService: HotelsService,
              private bookingService: BookingService,
              private reviewService: ReviewService
  ) {}
  
  ngOnInit(): void {
    this.getPosition().then(pos=>
      {
         this.getHotels(pos.lat, pos.lng)
      });
    
  }
  
  getPosition(): Promise<any>
  {
    return new Promise((resolve, reject) => {

      navigator.geolocation.getCurrentPosition(resp => {

          resolve({lng: resp.coords.longitude, lat: resp.coords.latitude});
        },
        err => {
          reject(err);
        });
    });
  }
  
  getHotels(latitude:number, longitude:number): void {
    this.hotelService.getHotels(latitude, longitude).subscribe(data => {
      this.hotels = data
      console.log(data)
    })
  }

  bookRoom(room: Rooms): void {
    this.bookingService.createBooking(room);
  }

  createReview(description: string, id: number | undefined): void {
    this.reviewService.createReview(description, id)
  }
}
