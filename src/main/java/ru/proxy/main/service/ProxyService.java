package ru.proxy.main.service;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.HttpStatusCodeException;

import java.net.URISyntaxException;


public interface ProxyService {
    @Retryable(exclude = {
            HttpStatusCodeException.class}, include = Exception.class, backoff = @Backoff(delay = 5000, multiplier = 4.0), maxAttempts = 4)
    ResponseEntity<String> processProxyRequest(String body, HttpMethod method, HttpServletRequest request, HttpServletResponse response, String uuid) throws URISyntaxException;

    @Recover
    public ResponseEntity<String> recoverFromRestClientErrors(Exception e, String body, HttpMethod method, HttpServletRequest request, HttpServletResponse response, String traceId);
}
