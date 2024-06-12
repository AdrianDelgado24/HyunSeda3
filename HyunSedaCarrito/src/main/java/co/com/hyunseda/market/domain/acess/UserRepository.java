/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Pay;
import co.com.hyunseda.market.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.Main;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 */
public class UserRepository implements IUserRepository {
    
   private String apiUrl = "http://localhost:8005/auth/register";

    public UserRepository() {

    }
    
   @Override
    public  boolean save(User user) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String url = "http://localhost:8005/auth/register";
            HttpPost httpPost = new HttpPost(url);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonRequest = objectMapper.writeValueAsString(user);
            StringEntity entity = new StringEntity(jsonRequest);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/json");
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);
            System.out.println("Response status: " + response.getStatusLine());
            System.out.println("Response body: " + responseBody);

            if(response.getStatusLine().getStatusCode() == 200) {
                return true;
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<>();
        try {
            
            String apiUrl = "http://localhost:8005/UserModel";
            // Crear una solicitud GET para obtener todos los usuarios
            HttpGet request = new HttpGet(apiUrl);

            //request.setHeader("Authorization"+ usuario.getToken());

          
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
            
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos 
                User[] users = mapper.readValue(jsonResponse, User[].class);

                for (User user : users) {
                    list.add(user);
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, "Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
    @Override
    public boolean validarUsuario(User user) {
        boolean isIgual = false;
        String rol="";
        String username="";
        String token="";
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String url = "http://localhost:8005/auth/login";
            
            HttpPost httpPost = new HttpPost(url);
            
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonRequest = objectMapper.writeValueAsString(user);
            StringEntity entity = new StringEntity(jsonRequest);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/json");
            
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);
            //System.out.println("status: " + response.getStatusLine());
           //System.out.println("body: " + responseBody);


            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("status: " + statusCode);

            // Verificar si la respuesta es 200 (OK)
            if (statusCode == 200) {
                isIgual = true; 
                rol = responseBody.substring(responseBody.indexOf("[") + 1, responseBody.indexOf("]"));

                // Encontrar la posición inicial del token en el cuerpo de respuesta
                int startIndex = responseBody.indexOf("\"token\":\"") + "\"token\":\"".length();
                int endIndex = responseBody.indexOf("\"", startIndex);

                token = responseBody.substring(startIndex, endIndex);

                 startIndex = responseBody.indexOf("\"username\":\"") + "\"username\":\"".length();
                 endIndex = responseBody.indexOf("\"", startIndex);
                 username=responseBody.substring(startIndex, endIndex);
               
                return true;
            }
            httpClient.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public User findById(long userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
