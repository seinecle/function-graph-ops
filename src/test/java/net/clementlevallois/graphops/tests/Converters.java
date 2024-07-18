package net.clementlevallois.graphops.tests;

import java.io.IOException;
import java.io.StringWriter;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author LEVALLOIS
 */
public class Converters {

    public static String turnJsonObjectToString(JsonObject jsonObject) {
        String output = "{}";
        try ( java.io.StringWriter stringWriter = new StringWriter()) {
            var jsonWriter = Json.createWriter(stringWriter);
            jsonWriter.writeObject(jsonObject);
            output = stringWriter.toString();
            output = Json.encodePointer(output);
        } catch (IOException ex) {
            System.out.println("exception when turning json to string: "+ ex.getMessage());
        }
        return output;
    }

    public static byte[] byteArraySerializerForAnyObject(Object o) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(o);
        oos.flush();
        byte[] data = bos.toByteArray();
        return data;
    }

}
