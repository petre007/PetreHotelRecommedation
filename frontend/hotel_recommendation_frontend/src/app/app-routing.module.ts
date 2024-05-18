import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './components/auth/auth.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { HotelsComponent } from './components/hotels/hotels.component';
import { ConfigComponent } from './components/config/config.component';
import { BookingComponent } from './components/booking/booking.component';

const routes: Routes = [
  {path: 'auth', component:AuthComponent},
  {path: 'homePage', component:HomePageComponent},
  {path: 'hotels', component:HotelsComponent},
  {path: 'config', component:ConfigComponent},
  {path: 'booking', component:BookingComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
