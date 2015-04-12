/***************************************************************************
 * COPYRIGHT (C) 2015, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/
package com.rpowell.mymidwife;

import retrofit.Callback;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

public interface INetwork {

    @POST("/api/login")
    @Headers({ "Content-Type:application/json" })
    public void loginUser(@Query(value="username", encodeValue = true) String username,
                          @Query(value="password", encodeValue = true) String password,
                          Callback<LoginResponseMapper> cb);

    @POST("/api/booking")
    @Headers({ "Content-Type:application/json" })
    public void makeBooking(
                            @Query(value="date", encodeValue = true) String date,
                            @Query(value="session", encodeValue = true) String session,
                            @Query(value="user", encodeValue = true) String user,
                            Callback<BookingResponseMapper> cb);

    @POST("/api/details")
    @Headers({ "Content-Type:application/json" })
    public void addMotherDetails(
            @Query(value="username", encodeValue = true) String username,
            @Query(value="height", encodeValue = true) int height,
            @Query(value="waist", encodeValue = true) String waist,
            @Query(value="weight", encodeValue = true) String weight,
            @Query(value="weeks", encodeValue = true) int weeks,
            @Query(value="address", encodeValue = true) String address,
            @Query(value="postcode", encodeValue = true) String postcode,
            @Query(value="number", encodeValue = true) String number,
            Callback<MotherDetailsResponseMapper> cb);

//    @GET("/api/1/incidents/all/mobile")
//    @Headers({"Accept: application/json"})
//    public void getMidwife(Callback<UserinsightIncidentMapper> callback);

    @Headers({ "Accept: application/json", "Content-Type:application/json" })
    @POST("/api/1/registration/createUser")
    public void registerUser(String username, String password, String first, String last, String confirm);
}
