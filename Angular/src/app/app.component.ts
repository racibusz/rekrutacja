import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CurrencyService } from './currency.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ReactiveFormsModule, HttpClientModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  providers: [CurrencyService]
})
export class AppComponent {
  value:any;
  currencyForm = new FormGroup({
    name: new FormControl(""),
    currency: new FormControl("")
  })
  requestsHistory: any;
  constructor(private fb:FormBuilder, private currencyService:CurrencyService){}

  getRequests(){
    this.currencyService.getRequests().subscribe(
      (res)=>{
        this.requestsHistory = res
      },
      (error) => {
        console.error(error)
      }
    )
  }

  onSubmit(){
    const name = this.currencyForm.value.name || '';
    const currency = this.currencyForm.value.currency || '';
  
    if (name && currency) {
      const formData = { name, currency };
      this.currencyService.getCurrencyRate(formData).subscribe(
      (res)=>{
        this.value = res
      },
      (error) => {
        if(error['status']==404){
          this.value = "Nie ma takiej waluty."
        }
      }
    )
    }
    
  }
  title = 'projekt';
}
