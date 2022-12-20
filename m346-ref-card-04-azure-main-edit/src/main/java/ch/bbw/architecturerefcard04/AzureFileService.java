package ch.bbw.architecturerefcard04;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.azure.spring.cloud.service.implementation.eventhubs.factory.EventHubClientBuilderFactory.LOGGER;

@Service
public class AzureFileService implements FileServiceInterface {

    @Value("${azure.storage.connection.string}")
    private String connectionString;

    @Value("${azure.storage.container.name}")
    private String containerName;

    private BlobServiceClient blobServiceClient;
    private BlobContainerClient blobContainerClient;

    @Autowired
    public AzureFileService(BlobServiceClient blobServiceClient, BlobContainerClient blobContainerClient) {
        this.blobServiceClient = blobServiceClient;
        this.blobContainerClient = blobContainerClient;
    }

    @Override
    public List<String> listFiles() {
        PagedIterable<BlobItem> blobItems = blobContainerClient.listBlobs();
        return blobItems.stream()
                .map(blobItem -> blobItem.getName())
                .collect(Collectors.toList());
    }

    @Override
    public void uploadFile(File file) {
        String fileName = StringUtils.cleanPath(file.getName());
        try {
            BlobClient blobClient = blobContainerClient.getBlobClient(fileName);
            blobClient.upload(new FileInputStream(file), file.length(), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] downloadFile(String filename) {
        // TODO: implement this method
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteFile(String filename) {
        // TODO: implement this method
        throw new UnsupportedOperationException();
    }

}
