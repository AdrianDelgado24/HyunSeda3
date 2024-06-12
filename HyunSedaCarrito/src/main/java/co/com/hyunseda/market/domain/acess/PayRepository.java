package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Pay;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * 
 */
public class PayRepository implements IPayRepository{
    
    private String apiUrl = "http://localhost:8004/payments";
  
     
     //Constructor que inicia la base de datos
    public PayRepository() {
       
    }

    @Override
    public List<Pay> findAll() {

        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Pay> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de pagos
            String apiUrl = "http://localhost:8004/payments";
            // Crear una solicitud GET para obtener todos los pagos
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            long statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Pay
                Pay[] pays = mapper.readValue(jsonResponse, Pay[].class);

                for (Pay pay : pays) {
                    list.add(pay);
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(PayRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener pagos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(PayRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        }

    @Override
    public Pay findById(long payId) {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Definir la URL de la API REST de pagos
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            long statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Pay
                Pay[] pagos = mapper.readValue(jsonResponse, Pay[].class);

                // Iterar sobre los pagos para encontrar el que coincida con el payId
                for (Pay pay : pagos) {
                    if (pay.getPayId() == payId) {
                        return pay;
                    }
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(PayRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener pagos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(PayRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean save(Pay newPay) {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        //List<Category> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de categorias
            String apiUrl = "http://localhost:8004/payments";

            // Convertir el objeto Category a JSON
            String jsonPay = mapper.writeValueAsString(newPay);

            // Crear una solicitud POST para obtener todas las categorias
            HttpPost request = new HttpPost(apiUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonPay));

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            long statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_CREATED) {
                return true;
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(PayRepository.class.getName()).log(Level.SEVERE, "Error al guardar el pago. Código de estado: " + statusCode);
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(PayRepository.class.getName()).log(Level.SEVERE, "Error al realizar la solicitud HTTP", ex);
            return false;
        }
    }

    @Override
    public boolean edit(long payId, Pay pay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(long payId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
