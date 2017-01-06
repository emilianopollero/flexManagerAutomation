package parsers

class ResponseHeader {

    private Map<String, List<String>> header = null

    ResponseHeader(Map<String, List<String>> response) {
        header = response
    }

    String getXPageId(){
        return header['x-page-id'][0]
    }

}