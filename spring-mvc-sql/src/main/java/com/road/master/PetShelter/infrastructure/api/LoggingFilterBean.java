package com.road.master.PetShelter.infrastructure.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.function.Function;

import static java.util.Collections.list;

@Component
@Slf4j
public class LoggingFilterBean extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException {
    ContentCachingRequestWrapper requestWrapper = requestWrapper(request);
    ContentCachingResponseWrapper responseWrapper = responseWrapper(response);

    chain.doFilter(requestWrapper, responseWrapper);

    logRequest(requestWrapper);
    logResponse(responseWrapper);
  }

  private void logRequest(ContentCachingRequestWrapper request) {
    StringBuilder builder = new StringBuilder();
    builder.append(headersToString(list(request.getHeaderNames()), request::getHeader));
    builder.append(new String(request.getContentAsByteArray()));
    log.debug("Request: {}", builder);
  }

  private void logResponse(ContentCachingResponseWrapper response) throws IOException {
    StringBuilder builder = new StringBuilder();
    builder.append(headersToString(response.getHeaderNames(), response::getHeader));
    builder.append(new String(response.getContentAsByteArray()));
    log.debug("Response: {}", builder);
    response.copyBodyToResponse();
  }

  private String headersToString(Collection<String> headerNames, Function<String, String> headerValueResolver) {
    StringBuilder builder = new StringBuilder();
    for (String headerName : headerNames) {
      String header = headerValueResolver.apply(headerName);
      builder.append("%s=%s".formatted(headerName, header)).append("\n");
    }
    return builder.toString();
  }

  private ContentCachingRequestWrapper requestWrapper(ServletRequest request) {
    if (request instanceof ContentCachingRequestWrapper requestWrapper) {
      return requestWrapper;
    }
    return new ContentCachingRequestWrapper((HttpServletRequest) request);
  }

  private ContentCachingResponseWrapper responseWrapper(ServletResponse response) {
    if (response instanceof ContentCachingResponseWrapper responseWrapper) {
      return responseWrapper;
    }
    return new ContentCachingResponseWrapper((HttpServletResponse) response);
  }
}
