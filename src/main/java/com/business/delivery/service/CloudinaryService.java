package com.business.delivery.service;

import com.business.delivery.config.api.CloudinaryProperties;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {
    private CloudinaryProperties cloudinaryProperties;
    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    @Autowired
    public CloudinaryService(CloudinaryProperties cloudinaryProperties) {
        this.cloudinaryProperties = cloudinaryProperties;
        valuesMap.put("cloud_name", cloudinaryProperties.getCloudName());
        valuesMap.put("api_key", cloudinaryProperties.getApiKey());
        valuesMap.put("api_secret", cloudinaryProperties.getApiSecret());
        cloudinary = new Cloudinary(valuesMap);
    }

    public Map upload(MultipartFile multipartFile , String folder) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", folder));
        file.delete();
        return result;
    }

    public Map delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    /*
    public Map delete(String folderName, String imageName) throws IOException {
        String id = folderName+"/"+imageName;
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }*/

    public String returnID(String url) throws MalformedURLException {
        URL url_link = new URL(url);
        String path = url_link.getPath(); // get the path of the resource in the URL
        String[] parts = path.split("/"); // split the path by '/'
        String id = parts[parts.length - 2] + '/' + parts[parts.length - 1]; // take the last two parts to get the id
        System.out.println(id);
        int dotIndex = id.lastIndexOf('.');
        String withoutExtension = id.substring(0, dotIndex);
        return withoutExtension;
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
