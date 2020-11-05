package br.com.dashboardlejour.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.dashboardlejour.bean.Appointment;

public class AppointmentService {
	
	private Client client;
	
	private final String URL_SERVICE = "https://sheet2api.com/v1/ByR2h1huRjyQ/fiap/appointment";
	
	public AppointmentService() {
		this.client = ClientBuilder.newClient();
	}
	
	public List<Appointment> getAll(){
		String respostaJson = client
				.target(URL_SERVICE)
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		Type listType = new TypeToken<ArrayList<Appointment>>(){}.getType();
		
		List<Appointment> appointments = new Gson().fromJson(respostaJson, listType);
		
		return appointments;
	}
	
	public Appointment getById(int id) {
		String respostaJson = client
				.target(URL_SERVICE)
				.path(String.valueOf(id))
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		return new Gson().fromJson(respostaJson, Appointment.class);
	}
	public String getAllJsonString() {
		String respostaJson = client
				.target(URL_SERVICE)
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		return respostaJson;
	}
	

}



