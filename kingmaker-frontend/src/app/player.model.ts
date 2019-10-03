export class Player{
    constructor(
        public id?: number, 
        public username?: string, 
        public password?: string, 
        public gold?: number, 
        public mp?: number, 
        public dp?: number, 
        public crewsize?: number){
    }
}