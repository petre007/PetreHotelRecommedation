import { DatePipe } from "@angular/common"
import { Rooms } from "./rooms"
import { User } from "./user"

export class Booking {

    id: number | undefined

    date: DatePipe | undefined

    room: Rooms | undefined

    user: User | undefined
}
