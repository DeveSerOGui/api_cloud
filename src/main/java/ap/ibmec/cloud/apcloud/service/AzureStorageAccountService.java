package ap.ibmec.cloud.apcloud.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

@Service
public class AzureStorageAccountService {
    public String uploadFileToArtist(MultipartFile file) throws IOException{
        String connectioString = "DefaultEndpointsProtocol=https;AccountName=ibmecstoragegui;AccountKey=2H24+cC4nrX2L6Egt75Rn6OCfMWRfCehJ5nibwgqLnILtQG0AQ08shZZzIbjwKR71UdyfPp1jQ1n+AStmXK0Vg==;EndpointSuffix=core.windows.net";
    
        BlobContainerClient client = new BlobContainerClientBuilder()
        .connectionString(connectioString)
        .containerName("imagens")
        .buildClient();

        BlobClient blob = client.getBlobClient(file.getOriginalFilename());

        blob.upload(file.getInputStream(), file.getSize(), true);

        return "https://ibmecstoragegui.blob.core.windows.net/imagens/" + file.getOriginalFilename();
    }

    public String uploadFileToMusic(MultipartFile file) throws IOException{
        String connectioString = "DefaultEndpointsProtocol=https;AccountName=ibmecstoragegui;AccountKey=2H24+cC4nrX2L6Egt75Rn6OCfMWRfCehJ5nibwgqLnILtQG0AQ08shZZzIbjwKR71UdyfPp1jQ1n+AStmXK0Vg==;EndpointSuffix=core.windows.net";
    
        BlobContainerClient client = new BlobContainerClientBuilder()
        .connectionString(connectioString)
        .containerName("imagens")
        .buildClient();

        BlobClient blob = client.getBlobClient(file.getOriginalFilename());

        blob.upload(file.getInputStream(), file.getSize(), true);

        return "https://ibmecstoragegui.blob.core.windows.net/imagens/" + file.getOriginalFilename();
    }
}
