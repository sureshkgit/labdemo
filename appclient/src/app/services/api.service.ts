import { Injectable } from '@angular/core';
import { HttpClient  }    from '@angular/common/http';
import { User } from '../model/user.model';
import { Observable } from 'rxjs';
import { CovidCountry } from '../model/covidcountry.model';
import { Country } from '../model/country.model';
import { State } from '../model/state.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }
  
  APIBASEURL: string     = 'http://localhost:8088/api/';
  USERAPI_URL: string    = this. APIBASEURL + 'user';
  COUNTRYAPI_URL: string = this.APIBASEURL + 'country'

  getUsers() : Observable<User[]> {
    return this.http.get<User[]>(this.USERAPI_URL);
  }

  getUserByCountryId(countryId: number ) {
    return this.http.get<User[]>(`${this.USERAPI_URL}/byCountryId/${countryId}`);
  }

  getUsersByCountryAndStateId(countryId: number, stateId: number ) {
    return this.http.get<User[]>(`${this.USERAPI_URL}/byCountryStateId/${countryId}/${stateId}`);
  }


  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(this.COUNTRYAPI_URL)
  }

  getStatesByCountryId(countryId: number) : Observable<State[]> {
    return this.http.get<State[]>(`${this.COUNTRYAPI_URL}/stateByCountryId/${countryId}`);
  }

}