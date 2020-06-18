package com.timediffcalc;

import org.json.JSONObject;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.lang.annotation.Annotation;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import java.io.*;


@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonMessageBodyWriter implements MessageBodyWriter<JSONObject>
{


    public boolean isWriteable(Class<?> type, Type genericType,
                               Annotation[] annotations, MediaType mediaType) {
        return JSONObject.class.isAssignableFrom(type);
    }


    public long getSize(JSONObject arg0, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType) {
        // deprecated by JAX-RS 2.0 and ignored by Jersey runtime
        return -1;
    }


    public void writeTo(JSONObject jsonObject,
                        Class<?> type,
                        Type type1,
                        Annotation[] antns,
                        MediaType mt, MultivaluedMap<String, Object> mn,
                        OutputStream out) throws IOException, WebApplicationException {

        out.write(jsonObject.toString().getBytes());


    }
}

