package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Order;
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
public class OrderRepository implements IOrderRepository{
    
    private String apiUrl = "http://localhost:8002/orders";
  
    public OrderRepository() {
       
    }

    @Override
    public List<Order> findAll() {

        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Order> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de ordenes
            String apiUrl = "http://localhost:8002/orders";
            // Crear una solicitud GET para obtener todos las ordenes
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            long statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Order
                Order[] orders = mapper.readValue(jsonResponse, Order[].class);

                for (Order order : orders) {
                    list.add(order);
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(OrderRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener pedidos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(OrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        }

    @Override
    public Order findById(long orderId) {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Definir la URL de la API REST de pedidos
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            long statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Order
                Order[] pedidos = mapper.readValue(jsonResponse, Order[].class);

                // Iterar sobre los pedidos para encontrar el que coincida con el orderId
                for (Order order : pedidos) {
                    if (order.getOrderId() == orderId) {
                        return order;
                    }
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(OrderRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener pedidos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(OrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean save(Order newOrder) {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        try {

          
            String apiUrl = "http://localhost:8002/orders";
            String jsonOrder = mapper.writeValueAsString(newOrder);

            HttpPost request = new HttpPost(apiUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonOrder));

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            long statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_CREATED) {
                return true;
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(OrderRepository.class.getName()).log(Level.SEVERE, "Error al guardar la orden. Código de estado: " + statusCode);
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(OrderRepository.class.getName()).log(Level.SEVERE, "Error al realizar la solicitud HTTP", ex);
            return false;
        }
    }

    @Override
    public boolean save(long orderId, Pay newPay) {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        try {
               
                String apiUrl = "http://localhost:8002/orders/pay/"+orderId;
                newPay.setOrderId(orderId);
                // Convertir el objeto Category a JSON
                String jsonPay = mapper.writeValueAsString(newPay);

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
                    Logger.getLogger(PayRepository.class.getName()).log(Level.SEVERE, "Error al guardar la orden. Código de estado: " + statusCode);
                    return false;
                }
        } catch (IOException ex) {
            Logger.getLogger(PayRepository.class.getName()).log(Level.SEVERE, "Error al realizar la solicitud HTTP", ex);
            return false;
        }
    }
    
    @Override
    public boolean edit(long orderId, Order order) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(long orderId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
