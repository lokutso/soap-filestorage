package com.lokutson.consuming;

import com.lokutson.consumingwebservice.wsdl.CreateFileRequest;
import com.lokutson.consumingwebservice.wsdl.DeleteFileRequest;
import com.lokutson.consumingwebservice.wsdl.File;
import com.lokutson.consumingwebservice.wsdl.GetFileRequest;
import com.lokutson.consumingwebservice.wsdl.GetFileResponse;
import com.lokutson.consumingwebservice.wsdl.UpdateFileRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class FileClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(FileClient.class);

    public GetFileResponse getFile(Long id) {

        GetFileRequest request = new GetFileRequest();
        request.setId(id);

        log.info("getFile");

        GetFileResponse response = (GetFileResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/files", request,
                        new SoapActionCallback(
                                "http://lokutson.org/producing-web-service/GetFileRequest"));

        return response;
    }

    public GetFileResponse createFile(File file) {

        CreateFileRequest request = new CreateFileRequest();
        request.setFile(file);

        log.info("createFile");

        GetFileResponse response = (GetFileResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/files", request,
                        new SoapActionCallback(
                                "http://lokutson.org/producing-web-service/CreateFileRequest"));

        return response;
    }

    public GetFileResponse updateFile(File file) {

        UpdateFileRequest request = new UpdateFileRequest();
        request.setFile(file);

        log.info("updateFile");

        GetFileResponse response = (GetFileResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/files", request,
                        new SoapActionCallback(
                                "http://lokutson.org/producing-web-service/GetFileRequest"));

        return response;
    }

    public GetFileResponse deleteFile(Long id) {

        DeleteFileRequest request = new DeleteFileRequest();
        request.setId(id);

        log.info("deleteFile");

        GetFileResponse response = (GetFileResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/files", request,
                        new SoapActionCallback(
                                "http://lokutson.org/producing-web-service/GetFileRequest"));

        return response;
    }

}
