package com.timediffcalc;

import javax.ws.rs.Path;

import org.json.JSONObject;
//import org.json.simple.JSONObject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Hamza on 08/09/19.
 */
@Path("/diffcalc")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/calculate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeDifference(@QueryParam("hour1") int hour1,
                                                      @QueryParam("min1")  int min1,
                                                      @QueryParam("hour2") int hour2,
                                                      @QueryParam("min2") int min2)
    {
        long minDiff = 0;
        long hrDiff = 0;

        if (min2 > min1) {
            min1 = 60 - min1;
            min2 = 60 - min2;

            minDiff = Math.abs(min1 - min2);
            hrDiff = Math.abs(hour1 - hour2);

            if (hour2 > hour1)
            {
                hrDiff = Math.abs(hour1 - hour2) ;
            }
            else if(hour1>hour2)
            {
                hrDiff = 24 - Math.abs(hour1 - hour2) - 1;
            }
            else if (hrDiff == 0)
            {
                hrDiff = 0;
            }


        } else if (min1 > min2) {
            minDiff = (min1 - min2);
            {
                if (minDiff < 60) {

                    minDiff = 60 - minDiff;

                    if (hour2 > hour1)
                        hrDiff = Math.abs(hour1 - hour2)-1;
                    else if(hour1> hour2)
                    {
                        hrDiff = 24 - Math.abs(hour1 - hour2) - 1;
                    }
                    else if (hrDiff == 0)
                    {
                        hrDiff = 24 - hrDiff - 1;
                    }
                }
            }

        } else if (min1 == min2) {
            if (hour1 == hour2 || hour1 > hour2 || hour2 > hour1) {
                hrDiff = Math.abs(hour1 - hour2);
                if (hrDiff == 0) {
                    hrDiff = hrDiff + 24;
                }

            }
        }

        //System.out.println("Calculated Time Difference: "+hrDiff + " hr(s) & " + minDiff + " min(s)");

        /*JSONObject jsonObject = new JSONObject();

        jsonObject.put("Hours",hrDiff);
        jsonObject.put("Mins", minDiff);




        //System.out.println(jsonObject.toString());
        Response response = Response.ok(jsonObject).build();
        System.out.println(response.getEntity());
        return response;*/

        return Response
                .status(200)
                .entity("Calculated Time Difference: "+hrDiff + " hr(s) & " + minDiff + " min(s)")
                .build();


    }
    }
