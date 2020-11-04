package br.com.dashboardlejour.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.dashboardlejour.bean.Wedding;

public class WeddingService {

	private Client client;
	 
	private final String URL_SERVICE = "https://sheet2api.com/v1/ByR2h1huRjyQ/fiap/wedding";
 
	public WeddingService() {
		this.client = ClientBuilder.newClient();  
	}
	
	
	public List<Wedding> getAll(){
		String respostaJson = client
		          .target(URL_SERVICE)
		          .request(MediaType.APPLICATION_JSON)
		          .get(String.class);
		
		Type listType = new TypeToken<ArrayList<Wedding>>(){}.getType();
		
		List<Wedding> weddings = new Gson().fromJson(respostaJson, listType);
		
		return weddings;
	}
	
	
	public Wedding getById(int id) {
		
		String respostaJson = client
		          .target(URL_SERVICE)
		          .path(String.valueOf(id))
		          .request(MediaType.APPLICATION_JSON)
		          .get(String.class);
		
		return new Gson().fromJson(respostaJson, Wedding.class);
	}
	
	
	public String getAllJsonString() {
		String respostaJson = client
		          .target(URL_SERVICE)
		          .request(MediaType.APPLICATION_JSON)
		          .get(String.class);

		return respostaJson;
	}
	
}
