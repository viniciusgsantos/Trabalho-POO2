package br.ufsc.cco.Controle;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import br.ufsc.cco.request.ParameterStringBuilder;
import br.ufsc.cco.request.Request;

public class ControladorRequests {
	
	private final String BANCO_DO_BRASIL = "BBAS3";
	private final String PETROBRAS = "PETR4";
	private final String VALE = "vale3.sa";
	private final String AMBEV = "ABEV3";
	private final String SANTANDER = "bsan33";
	
	private final String FUNCTION_PARAM = "function";
	private final String FUNCTION_VALUE = "TIME_SERIES_INTRADAY";
	private final String SYMBOL_PARAM = "symbol";
	private final String INTERVAL_PARAM = "interval";
	private final String INTERVAL_VALUE = "1min";
	private final String KEY_PARAM = "apikey";
	private final String KEY_VALUE = "7GW0PVNZ0KA2KIWC";
	
	private String paramsBB;
	private String paramsPETR;
	private String paramsVALE;
	private String paramsABEV;
	private String paramsSAN;
	
	private static ControladorRequests instance;
	private Request request;
	
	private ControladorRequests() {
		request = new Request();
		createParams();
	}
	
	public String request(String params) {
		System.out.println(paramsBB);
		String response = request.request(paramsBB);
		return response;
	}
	
	private void createParams() {
		Map<String, String> parametersBB = new HashMap<>();
		parametersBB.put(FUNCTION_PARAM, FUNCTION_VALUE);
		parametersBB.put(SYMBOL_PARAM, BANCO_DO_BRASIL);
		parametersBB.put(INTERVAL_PARAM, INTERVAL_VALUE);
		parametersBB.put(KEY_PARAM, KEY_VALUE);
		
		Map<String, String> parametersPETR = new HashMap<>();
		parametersPETR.put(FUNCTION_PARAM, FUNCTION_VALUE);
		parametersPETR.put(SYMBOL_PARAM, PETROBRAS);
		parametersPETR.put(INTERVAL_PARAM, INTERVAL_VALUE);
		parametersPETR.put(KEY_PARAM, KEY_VALUE);
		
		Map<String, String> parametersVALE = new HashMap<>();
		parametersVALE.put(FUNCTION_PARAM, FUNCTION_VALUE);
		parametersVALE.put(SYMBOL_PARAM, VALE);
		parametersVALE.put(INTERVAL_PARAM, INTERVAL_VALUE);
		parametersVALE.put(KEY_PARAM, KEY_VALUE);
		
		Map<String, String> parametersABEV = new HashMap<>();
		parametersABEV.put(FUNCTION_PARAM, FUNCTION_VALUE);
		parametersABEV.put(SYMBOL_PARAM, AMBEV);
		parametersABEV.put(INTERVAL_PARAM, INTERVAL_VALUE);
		parametersABEV.put(KEY_PARAM, KEY_VALUE);
		
		Map<String, String> parametersSAN = new HashMap<>();
		parametersSAN.put(FUNCTION_PARAM, FUNCTION_VALUE);
		parametersSAN.put(SYMBOL_PARAM, SANTANDER);
		parametersSAN.put(INTERVAL_PARAM, INTERVAL_VALUE);
		parametersSAN.put(KEY_PARAM, KEY_VALUE);
		
		try {
			paramsBB = ParameterStringBuilder.getParamsString(parametersBB);
			paramsPETR = ParameterStringBuilder.getParamsString(parametersPETR);
			paramsVALE = ParameterStringBuilder.getParamsString(parametersVALE);
			paramsABEV = ParameterStringBuilder.getParamsString(parametersABEV);
			paramsSAN = ParameterStringBuilder.getParamsString(parametersSAN);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
	public static ControladorRequests getInstance() {
		if(instance == null) {
			instance = new ControladorRequests();
		}
		return instance;
	}

}
