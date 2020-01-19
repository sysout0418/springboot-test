package com.elio.edu.common;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class SmsUtil {

    private static NaverSensEndPoints naverSensEndPoint = null;

    private static final String NAVER_SENS_BASE_URL = "https://api-sens.ncloud.com";

    private static final String NAVER_SENS_AUTH_KEY = "";

    private static final String NAVER_SENS_SERVICE_SECRET = "a54f31f56150436daf7d7e8391345493";

    private static final String NAVER_SENS_SERVICE_ID = "ncp:sms:kr:257660958938:elio\n";

    interface NaverSensEndPoints {
        @Headers({"Content-Type:application/json;", "accept:application/json"})
        @POST("v1/sms/services/{serviceId}/messages")
        Call<Map<String, Object>> sendSms(
                @Header("x-ncp-auth-key") String authKey
                , @Header("x-ncp-service-secret") String serviceSecret
                , @Path("serviceId") String serviceId
                , @Body Map<String, Object> body
        );
    }

    public static NaverSensEndPoints getNaverSensEndPoint() {
        if (naverSensEndPoint == null) {
            Retrofit retrofitSens = new Retrofit.Builder()
                    .baseUrl(NAVER_SENS_BASE_URL)
                    .client(new OkHttpClient.Builder()
                            .connectTimeout(60, TimeUnit.SECONDS)
                            .readTimeout(60, TimeUnit.SECONDS)
                            .writeTimeout(60, TimeUnit.SECONDS)
                            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .build())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();

            naverSensEndPoint = retrofitSens.create(NaverSensEndPoints.class);
        }

        return naverSensEndPoint;
    }

    public static Map<String, Object> callSmsApi(Map<String, Object> requestMap) throws Exception {
        NaverSensEndPoints naverSensEndPoint = getNaverSensEndPoint();
        if (requestMap == null) {
            requestMap = new HashMap<String, Object>();
        }

        Call<Map<String, Object>> call = naverSensEndPoint.sendSms(
                NAVER_SENS_AUTH_KEY
                , NAVER_SENS_SERVICE_SECRET
                , NAVER_SENS_SERVICE_ID
                , requestMap);

        return call.execute().body();
    }

    public static void main(String args[]) throws Exception {

        Map<String, Object> requestMap = new HashMap<>();

        requestMap.put("type", "SMS"); //SMS, LMS
        requestMap.put("contentType", "COMM"); // COMM: 일반메시지, AD: 광고
        requestMap.put("countryCode", "82"); // default: 82
        requestMap.put("from", "024008471");
//		requestMap.put("subject", "제목");// LMS 에서만 사용
        requestMap.put("content", "테스트문자메시지"); // SMS:최대80byte, LMS:최대2000byte
        List<String> toList = new ArrayList<String>();
        toList.add("01039270323");
        requestMap.put("to", toList);

        Map<String, Object> response = callSmsApi(requestMap);
        System.out.println("result:"+response);
    }

}
