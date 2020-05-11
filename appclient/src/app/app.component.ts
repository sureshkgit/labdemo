import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from "@angular/forms";
import { User } from './model/user.model';
import { Router } from '@angular/router';
import { ApiService } from './services/api.service';
import { Country } from './model/country.model';
import { State } from './model/state.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  title = 'LabApp';
  isSubmitted = false;

  users: User[] = [];
  countries: Country[] = [];
  states: State[] = [];
  selectedCountryId: string = "";
  selectedStateId: string = "";

  userForm: FormGroup;

  constructor(private router: Router, public fb: FormBuilder, private apiService: ApiService) { }

  ngOnInit() {

    this.userForm = this.fb.group({
      countryField: ['', Validators.required],  
      stateField: ['', Validators.required]  
    })
     
    this.populateData();
  }

  populateData() {
      this.apiService.getUsers()
      .subscribe( data => { this.users = data; });

      this.apiService.getCountries()
      .subscribe( data => { this.countries = data; });
   
  }

  populateStatesList(e) {
    console.info(e.target.value);
    let countryId: number = e.target.value;

    if (e.target.value == "") {
      console.log("Country Id is empty");
      this.states = [];
      this.selectedStateId = "";
    } else {
      this.apiService.getStatesByCountryId(countryId)
      .subscribe( data => {this.states = data; });

      this.apiService.getUserByCountryId(countryId)
        .subscribe( data => {this.users = data; });
      }
  }

  populateUsers(e) {
    console.info(e.target.value);
    let countryId: number = e.target.value;
    if (e.target.value == "") {
      console.log("State Id is empty");
      this.apiService.getUserByCountryId(this.userForm.get('countryField').value)
      .subscribe( data => {this.users = data; });
    } else {
      console.log("Country -- > " + this.userForm.get('countryField').value);
      console.log("State   -- >" + this.userForm.get('stateField').value);
      this.apiService.getUsersByCountryAndStateId(this.userForm.get('countryField').value, e.target.value)
      .subscribe( data => {this.users = data; });
    }
    

  }


  onSubmit() {
    this.isSubmitted = true;
    if (!this.userForm.valid) {
      return false;
    } else {
      //alert(JSON.stringify(this.userForm.value))
      console.log(this.userForm.value);
    }

  }


}
