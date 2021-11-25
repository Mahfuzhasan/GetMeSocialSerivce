package com.example.getmesocialservice.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    public boolean upload(MultipartFile file) {

        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
                BasicAWSCredentials credentials= new BasicAWSCredentials("");
                return credentials;}

            @Override
            public void refresh() {}}).withRegion(Regions.US_EAST_1).build();
        try {
            ObjectMetadata metadata= new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            s3.putObject("bucket_name",file.getOriginalFilename(),file.getInputStream(),metadata);
            return true;
        } catch (AmazonServiceException| IOException e){
           //System.out.println(e.fillInStackTrace());
            return false;
        }
    }

    public S3Object getFile(String key){
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
                BasicAWSCredentials credentials= new BasicAWSCredentials("");
                return credentials;}

            @Override
            public void refresh() {}}).withRegion(Regions.US_EAST_1).build();
    return s3.getObject("bucket_name",key);}

    public void deleteFile(String key){
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
                BasicAWSCredentials credentials= new BasicAWSCredentials(");
                return credentials;}

            @Override
            public void refresh() {}}).withRegion(Regions.US_EAST_1).build();
         s3.deleteObject("bucket_name",key);}



}
