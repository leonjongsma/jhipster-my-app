export interface IMovie {
  id?: number;
  name?: string;
}

export class Movie implements IMovie {
  constructor(public id?: number, public name?: string) {}
}
