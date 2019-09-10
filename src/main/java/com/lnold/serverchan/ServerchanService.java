package com.lnold.serverchan;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class ServerchanService {

    private final String requestUrl;
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    ServerchanService(ServerchanProperties properties) {
        requestUrl = "https://sc.ftqq.com/" + properties.getSckey() + ".send";
    }

    public PushResult sendMessage(String title, String content) {

        RestTemplate client = new RestTemplate();
        //构造请求
        HttpEntity<MultiValueMap<String, String>> request = generateRequest(title, content);
        //发送请求
        ResponseEntity<String> response = client.exchange(requestUrl, HttpMethod.POST, request, String.class);
        //解析结果
        return parseResponse(response);


    }

    private HttpEntity<MultiValueMap<String, String>> generateRequest(String text, String desp) {
        if (StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException("标题不能为空");
        }

        // 设置请求头，表单格式
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 设置请求参数
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("text", text);
        params.add("desp", desp);
        // 将请求头部和参数合成一个请求
        return new HttpEntity<>(params, headers);
    }

    private PushResult parseResponse(ResponseEntity<String> response) {
        try {
            return mapper.readValue(response.getBody(), PushResult.class);
        } catch (IOException e) {
            throw new JsonParseException(e);
        }
    }


}
