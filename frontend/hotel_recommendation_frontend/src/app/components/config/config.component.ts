import { Component, OnInit } from '@angular/core';
import { ConfigService } from 'src/app/services/config.service';
import { Config } from 'src/app/common/config';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})
export class ConfigComponent implements OnInit{

  configs: Config[] = []

  constructor(private configService: ConfigService) {}
  
  ngOnInit(): void {
    this.getConfigParams()
  }

  getConfigParams() {
    this.configService.getConfigParams().subscribe(data => {
      this.configs = data
      console.log(this.configs)
    })
  }

  updateParam() {
    for (let i = 0; i<this.configs.length; i++) {
      this.configService.updateParamValue(this.configs[i])
    }
  }

}
