package com.stakater.lab.support;

import org.springframework.http.HttpHeaders;

/**
 * Utility class for http header creation.
 *
 */
public class HeaderUtil
{
    public static HttpHeaders createAlert(String message, String param)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-pliro-alert", message);
        headers.add("X-pliro-params", param);
        return headers;
    }

    public static HttpHeaders createEntityCreationAlert(String entityName, String param)
    {
        return createAlert("pliro." + entityName + ".created", param);
    }

    public static HttpHeaders createEntityUpdateAlert(String entityName, String param)
    {
        return createAlert("pliro." + entityName + ".updated", param);
    }

    public static HttpHeaders createEntityDeletionAlert(String entityName, String param)
    {
        return createAlert("pliro." + entityName + ".deleted", param);
    }

    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-pliro-error", "error." + errorKey);
        headers.add("X-pliro-params", entityName);
        return headers;
    }
}
