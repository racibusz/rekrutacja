import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService {
  private CURRENCY_RATE = "http://localhost:8080/currencies/get-current-currency-value-command"
  private REQUEST_HISTORY = "http://localhost:8080/currencies/requests"
  constructor(private http: HttpClient) { }

  getCurrencyRate(data: {name:string, currency:string}):Observable<any>
  {
    return this.http.post(this.CURRENCY_RATE, data)
  }
  getRequests(){
    return this.http.get(this.REQUEST_HISTORY);
  }
  

}
