package br.ufsc.cco.objects;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import br.ufsc.cco.util.ParameterStringBuilder;

public class RequestsURL {
	
	private static final String BANCO_DO_BRASIL = "BBAS3";
	private static final String PETROBRAS = "PETR4";
	private static final String VALE = "vale3.sa";
	private static final String GOOGLE = "GOOG";
	private static final String SANTANDER = "bsan33";
	
	private static final String FUNCTION_PARAM = "function";
	private static final String FUNCTION_VALUE = "TIME_SERIES_INTRADAY";
	private static final String SYMBOL_PARAM = "symbol";
	private static final String INTERVAL_PARAM = "interval";
	private static final String INTERVAL_VALUE = "1min";
	private static final String KEY_PARAM = "apikey";
	private static final String KEY_VALUE = "7GW0PVNZ0KA2KIWC";
	
	private String paramsBB;
	private String paramsPETR;
	private String paramsVALE;
	private String paramsGOOG;
	private String paramsSAN;
	
	public RequestsURL() {
		createParams();
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
		
		Map<String, String> parametersGOOG = new HashMap<>();
		parametersGOOG.put(FUNCTION_PARAM, FUNCTION_VALUE);
		parametersGOOG.put(SYMBOL_PARAM, GOOGLE);
		parametersGOOG.put(INTERVAL_PARAM, INTERVAL_VALUE);
		parametersGOOG.put(KEY_PARAM, KEY_VALUE);
		
		Map<String, String> parametersSAN = new HashMap<>();
		parametersSAN.put(FUNCTION_PARAM, FUNCTION_VALUE);
		parametersSAN.put(SYMBOL_PARAM, SANTANDER);
		parametersSAN.put(INTERVAL_PARAM, INTERVAL_VALUE);
		parametersSAN.put(KEY_PARAM, KEY_VALUE);
		
		try {
			paramsBB = ParameterStringBuilder.getParamsString(parametersBB);
			paramsPETR = ParameterStringBuilder.getParamsString(parametersPETR);
			paramsVALE = ParameterStringBuilder.getParamsString(parametersVALE);
			paramsGOOG = ParameterStringBuilder.getParamsString(parametersGOOG);
			paramsSAN = ParameterStringBuilder.getParamsString(parametersSAN);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getParamsBB() {
		return paramsBB;
	}

	public String getParamsPETR() {
		return paramsPETR;
	}

	public String getParamsVALE() {
		return paramsVALE;
	}

	public String getParamsGOOG() {
		return paramsGOOG;
	}

	public String getParamsSAN() {
		return paramsSAN;
	}
	
}
