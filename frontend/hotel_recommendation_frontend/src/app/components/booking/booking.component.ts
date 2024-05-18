import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/common/booking';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit{
  
  bookings: Booking[] = []

  constructor(private bookingService: BookingService) {}
  
  ngOnInit(): void {
    this.getBookings()
  }

  getBookings() {
    this.bookingService.getBookings().subscribe(data=> {
      this.bookings = data
    })
  }

  deleteBook(book: Booking): void {
    this.bookingService.deleteBooking(book)
  }

}
