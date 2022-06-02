package com.lokutson.producing;

import org.lokutson.producing_web_service.CreateFileRequest;
import org.lokutson.producing_web_service.DeleteFileRequest;
import org.lokutson.producing_web_service.GetFileRequest;
import org.lokutson.producing_web_service.GetFileResponse;
import org.lokutson.producing_web_service.UpdateFileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class FileEndpoint {
    private static final String NAMESPACE_URI = "http://lokutson.org/producing-web-service";

    private final FileRepository fileRepository;

    @Autowired
    public FileEndpoint(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFileRequest")
    @ResponsePayload
    public GetFileResponse getFile(@RequestPayload GetFileRequest request) {
        GetFileResponse response = new GetFileResponse();
        Optional<File> fileOptional = fileRepository.findById(request.getId());
        if (fileOptional.isPresent()) {
            response.setFile(FileMapper.MAPPER.toFileDto(fileOptional.get()));
        } else {
            response.setFile(null);
        }


        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createFileRequest")
    @ResponsePayload
    public GetFileResponse createFile(@RequestPayload CreateFileRequest request) {
        GetFileResponse response = new GetFileResponse();
        File file = fileRepository.save(FileMapper.MAPPER.toFileEntity(request.getFile()));
        response.setFile(FileMapper.MAPPER.toFileDto(file));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateFileRequest")
    @ResponsePayload
    public GetFileResponse updateFile(@RequestPayload UpdateFileRequest request) {
        GetFileResponse response = new GetFileResponse();
        File file = fileRepository.save(FileMapper.MAPPER.toFileEntity(request.getFile()));
        response.setFile(FileMapper.MAPPER.toFileDto(file));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteFileRequest")
    @ResponsePayload
    public GetFileResponse deleteFile(@RequestPayload DeleteFileRequest request) {
        GetFileResponse response = new GetFileResponse();
        Optional<File> fileOptional = fileRepository.findById(request.getId());
        fileRepository.deleteById(request.getId());
        if (fileOptional.isPresent()) {
            response.setFile(FileMapper.MAPPER.toFileDto(fileOptional.get()));
        } else {
            response.setFile(null);
        }

        return response;
    }
}
