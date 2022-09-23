import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;


public class Http {
    private static HttpURLConnection urlcon;

    public static void main(String[] args) throws IOException /*throws URISyntaxException, IOException*/ {
        //GET
        String line;
        StringBuffer response = new StringBuffer();//Za append rezultata
        BufferedReader reader;
        int status;
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");
            try {
                urlcon = (HttpURLConnection) url.openConnection();
                urlcon.setRequestMethod("GET");

                status = urlcon.getResponseCode();
                System.out.println(status);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (status > 299) { //If status isnt successful, bad connection. Error msg
            reader = new BufferedReader(new InputStreamReader(urlcon.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
        } else {
            reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            Aparse(response.toString());
            postRequest();

        }
        // System.out.println(response.toString());
        urlcon.disconnect();

    }

    //Extract JSON file
    public static String Aparse(String responseBody) {
        JSONArray albums = new JSONArray(responseBody);
        for (int i = 0; i < albums.length(); i++) {
            JSONObject album = albums.getJSONObject(i);
            int id = album.getInt("id");
            int userId = album.getInt("userId");
            String title = album.getString("title");
            System.out.println(id + " " + title + " " + userId);
        }
        return null;

    }

    public static void postRequest() {


        try {
            String post_data = "key=value";
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");

            urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setRequestMethod("POST");
            urlcon.setDoOutput(true);
            OutputStream outputStream = urlcon.getOutputStream();
            outputStream.write(post_data.getBytes());
            outputStream.flush();
            outputStream.close();

            BufferedReader readerPost;
            String linePost;
            StringBuffer responsePost = new StringBuffer();
            int status = urlcon.getResponseCode();
            if (status > 299) {
                readerPost = new BufferedReader(new InputStreamReader(urlcon.getErrorStream()));
                while ((linePost = readerPost.readLine()) != null) {
                    responsePost.append(linePost);
                }
                readerPost.close();
            } else {
                readerPost = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
                while ((linePost = readerPost.readLine()) != null) {
                    responsePost.append(linePost);
                }
                readerPost.close();

            }
            System.out.println(responsePost.toString());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*HttpClient client = HttpClient.newHttpClient(); //Kreiram client
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/albums")).build(); //pravim request
        client.sendAsync(req, HttpResponse.BodyHandlers.ofString())//saljem zahtev preko client-a asinhrono, sa drugim parametrom kazemo serveru da zelimo respons da bude string
                .thenApply(HttpResponse::body)//kad se zavrsi recieve, ovom metodom delujem na poslednji recieve
                .thenApply(Http::Aparse)
                .join(); // vraca trenutni rezultat i potencijalne rezultate */

    /*public static void putRequest() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut("https://jsonplaceholder.typicode.com/albums");
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            String json = "{\r\n" +  "  \"userId\": \"1\",\r\n" + "  \"id\": \"7\",\r\n" + "  \"title\": \"Aleksa\",\r\n"+
                    "}";
            StringEntity stringEntity = new StringEntity(json);
            httpPut.setEntity(stringEntity);

            System.out.println("Executing request " + httpPut.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPut, responseHandler);
            System.out.println(responseBody);
        }
    }*/
}