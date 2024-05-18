import { Review } from "./review"
import { Rooms } from "./rooms"

export class Hotels {

    id: number | undefined

    name: string | undefined

    roomEntities: Rooms[] | undefined

    reviewEntities: Review[] | undefined

}
