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

import com.google.api.server.spi.auth.EspAuthenticator;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.UnauthorizedException;

import java.util.ArrayList;
import java.util.List;

/** The Echo API which Endpoints will be exposing. */
// [START echo_api_annotation]
@Api(
    name = "echo",
    version = "v1"
  
    // [END_EXCLUDE]
    )
// [END echo_api_annotation]
public class Echo {


  private League league;

  /**
   * Echoes the received message back. If n is a non-negative integer, the message is copied that
   * many times in the returned message.
   *
   * Note that name is specified and will override the default name of "{class name}.{method
   * name}". For example, the default is "echo.echo".
   *
   * Note that httpMethod is not specified. This will default to a reasonable HTTP method
   * depending on the API method name. In this case, the HTTP method will default to POST.
   */
  // [START echo_method]
  @ApiMethod(name = "showTeams")
  public List<Team> getAllTeams() {

    if(league==null){
      league = new League();
    }
    return league.getTeamList();
  }


 @ApiMethod(name = "consultarTeam", path="consultarTeam")
  public Team consultarTeam(@Named("name") String name) {

    if(league==null){
      league = new League();
    }

    Team t = league.searchTeamWithName(new Team(name));
   return t;
  }

  @ApiMethod(name = "deleteTeam", path="deleteTeam/{name}")
  public Team deleteTeam(@Named("name") String name) {

    if(league==null){
      league = new League();
    }

    Team t = league.deleteTeam(new Team(name));
   return t;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.PUT,name = "editTeam", path="editTeam/{name}")
  public Team editTeam(@Named("name") String name, @Named("cantidadDeTitulos") int cantidadDeTitulos,@Named("fundationYear") int fundationYear) {

    if(league==null){
      league = new League();
    }
    Team t = league.editTeam(name, cantidadDeTitulos, fundationYear);
   return t;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,name = "createTeam", path="createTeam/success")
  public Team createTeam(@Named("name") String name, @Named("cantidadDeTitulos") int cantidadDeTitulos,@Named("fundationYear") int fundationYear) {

    if(league==null){
      league = new League();
    }
    Team t = league.createTeam(name, cantidadDeTitulos, fundationYear);
   return t;
  }




}

