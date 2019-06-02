package com.gupb.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.alibaba.fastjson.JSON;
import com.gupb.page.WrapMapperResult;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class Fallback implements FallbackProvider {

	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse(){

			@Override
			public InputStream getBody() throws IOException {
				String result =  setResponseBody(route);
				return new ByteArrayInputStream(result.getBytes("UTF-8"));
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
		        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		        return headers;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {

				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {

				return HttpStatus.OK.value();
			}

			@Override
			public String getStatusText() throws IOException {

				return HttpStatus.OK.getReasonPhrase();
			}

			@Override
			public void close() {

			}
		};
	}

	private String setResponseBody(String route) {
		WrapMapperResult<T> result = new WrapMapperResult<T>();
		result.setMessage("网关服务器调用为服务异常");
		result.setCode("200");

		return JSON.toJSONString(result);
	}
}
