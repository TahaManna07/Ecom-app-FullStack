import {Component, OnInit} from '@angular/core';
import {addWarning} from "@angular-devkit/build-angular/src/utils/webpack-diagnostics";
import {KeycloakService} from "keycloak-angular";
import {KeycloakProfile} from "keycloak-js";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'ecom-frontend';
  public profile! : KeycloakProfile;

  ngOnInit() {
      if(this.keycloakService.isLoggedIn()){
        this.keycloakService.loadUserProfile().then(profile=>{
          this.profile=profile;
        });
      }
    }

  constructor(public keycloakService : KeycloakService) {
  }
  async login() {
    await this.keycloakService.login({
      redirectUri: window.location.origin
    })

  }
  logout() {
    this.keycloakService.logout(window.location.origin)
  }


}
