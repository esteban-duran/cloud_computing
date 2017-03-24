/*
 * Copyright (c) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not  use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.echo;

/** The message bean that will be used in the echo request and response. */
public class Team {
  
  private String teamName;
  private int cantidadDeTitulos;
  private int fundationYear;

  
  
  public int getCantidadDeTitulos() {
    return cantidadDeTitulos;
  }


  public void setCantidadDeTitulos(int cantidadDeTitulos) {
    this.cantidadDeTitulos = cantidadDeTitulos;
  }


  public int getFundationYear() {
    return fundationYear;
  }


  public void setFundationYear(int fundationYear) {
    this.fundationYear = fundationYear;
  }

  public Team(String name, int cantidadDeTitulos,int fundationYear){
    this.teamName=name;
    this.cantidadDeTitulos=cantidadDeTitulos;
    this.fundationYear=fundationYear;
  }
  
  public Team(String name){
	this.teamName=name;
  }

  public String getName() {
    return teamName;
  }


  public void setName(String name) {
    this.teamName = name;
  }


}