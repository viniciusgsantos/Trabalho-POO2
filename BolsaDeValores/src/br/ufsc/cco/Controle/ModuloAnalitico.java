package br.ufsc.cco.Controle;

import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ModuloAnalitico {
	
	public double getSMA(String jsonIntraday) {
		JsonParser jp = new JsonParser();
		JsonObject jsonObject = jp.parse(jsonIntraday).getAsJsonObject();
		JsonObject jsonTimeSeries = jsonObject.get("Time Series (1min)").getAsJsonObject();
		
		int count = 0;
		double media = 0;
		for(Entry<String, JsonElement> entry : jsonTimeSeries.entrySet()) {
			JsonObject time = entry.getValue().getAsJsonObject();
			double fechamento = time.get("4. close").getAsDouble();
			media += fechamento * 0.1;
			count++;
			if(count == 10) {
				break;
			}
		}
		return media;
	}
	
	public double getLastClose(String jsonIntraday) {
		JsonParser jp = new JsonParser();
		JsonObject jsonObject = jp.parse(jsonIntraday).getAsJsonObject();
		JsonObject jsonTimeSeries = jsonObject.get("Time Series (1min)").getAsJsonObject();
		
		double close = 0;
		for(Entry<String, JsonElement> entry : jsonTimeSeries.entrySet()) {
			JsonObject time = entry.getValue().getAsJsonObject();
			close = time.get("4. close").getAsDouble();
			break;
		}
		
		return close;
		
	}
}
