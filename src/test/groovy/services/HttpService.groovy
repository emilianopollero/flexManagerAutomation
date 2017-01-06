package services

import groovy.json.JsonSlurper
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import logger.Logger
import logger.errorMessages.ConnectionErrorMsg
import parsers.ResponseHeader

import static groovyx.net.http.ContentType.JSON
import groovyx.net.http.Method

class HttpService {

    static def get(String baseUrl, String uri, query) {
        try {
            def callData = null
            def callStatus = null
            def http = new HTTPBuilder(baseUrl)
            http.getClient().getParams().setParameter("http.socket.timeout", new Integer(3000))

            http.get(path: uri, query: query) { resp, json ->
                callData = json
                callStatus = resp.status
            }

            [status: callStatus, data: callData]

        } catch (groovyx.net.http.HttpResponseException ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.getMessage()))
            [status: ex.statusCode]
        } catch (java.net.SocketTimeoutException ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.getMessage()))
            [status: 1001]
        } catch (java.net.ConnectException ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.getMessage()))
            [status: 1002]
        } catch (Exception ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.printStackTrace()))
            [status: 1003]
        }
    }

    static def post(String baseUrl, String uri, def payload) {
        try {
            def callData = null
            def callStatus = null
            def http = new HTTPBuilder(baseUrl)

            http.getClient().getParams().setParameter("http.socket.timeout", new Integer(3000))

            http.post(path: uri, body: payload, requestContentType: JSON) { resp, json ->

                callData = json
                callStatus = resp.status

            }

            [status: callStatus, data: callData]

        } catch (groovyx.net.http.HttpResponseException ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.getMessage()))
            [status: ex.statusCode]
        } catch (java.net.SocketTimeoutException ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.getMessage()))
            [status: 1001]
        } catch (java.net.ConnectException ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.getMessage()))
            [status: 1002]
        } catch (Exception ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.printStackTrace()))
            [status: 1003]
        }
    }

    static def executeGetRequest(String baseUrl, String path,
                                 def query = [:], Map requestHeaders = [:], method = Method.GET) {
        try {
            def http = new HTTPBuilder(baseUrl)
            def callData = null
            def callStatus = null

            // perform a ${method} request
            http.request(method, ContentType.JSON) {
                uri.path = path
                uri.query = query
                //headers.'Content-Type' = 'application/json'
                //headers.'authorization' = 'expedia-apikey key=QV0pZPwI5mScsOACWsnhNTnrorUKFRoT'

                // add possible headers
                requestHeaders.each { key, value ->
                    headers."${key}" = "${value}"
                }

                // response handler for a success response code
                response.success = { resp, reader ->
                    callStatus = resp.statusLine
                    callData = reader
                }

                response.failure = { resp, reader ->
                    callStatus = resp.statusLine
                    callData = reader
                }
            }
            return [status: callStatus, data: callData]

        } catch (groovyx.net.http.HttpResponseException ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.printStackTrace()))
            return null
        } catch (java.net.ConnectException ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg(ex.printStackTrace()))
            return null
        }
    }

    static def getHTTPS(String baseUrl, String uri, query) {
        try {
            def callData = null
            int callStatus
            String url = baseUrl + uri
            HttpURLConnection conn = url.toURL().openConnection()
            callStatus = conn.responseCode
            if (callStatus == 200) {
                def json = conn.content.text
                def slurper = new JsonSlurper()
                callData = slurper.parseText(json)
            }
            return [status: callStatus, data: callData]
        } catch (Exception ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg("Https Connection Error"))
            return null
        }
    }

    static ResponseHeader getResponseHeader(String url) {

        try {
            ResponseHeader response
            int callStatus
            HttpURLConnection conn = url.toURL().openConnection()
            callStatus = conn.responseCode
            if (callStatus == 200) {
                Map<String, List<String>> header = conn.getHeaderFields()
                response = new ResponseHeader(header)
                return response
            }
        } catch (Exception ex) {
            Logger.getInstance().addMessage(new ConnectionErrorMsg("Https Connection Error"))
            return null
        }

    }

    static String getLandedUri(String url) {
        HttpURLConnection conn = url.toURL().openConnection()
        conn.setInstanceFollowRedirects(false)
        String target = conn.getHeaderField('Location')
        if (target != null) {
            return target
        }
        else
            return null
    }

}