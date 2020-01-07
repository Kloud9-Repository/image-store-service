package com.nokia.image.store.api.service;

import com.nokia.image.store.api.entity.Album;
import com.nokia.image.store.api.entity.Photo;
import com.nokia.image.store.api.repository.AlbumRepository;
import com.nokia.image.store.api.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageStoreService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ImageRepository imageRepository;

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    private String deleteAlbum(int albumId) {
        albumRepository.markAlbumStatusAsDeleted(0, albumId);
        return "album " + albumId + " deleted successfully !!";
    }

    private String createImage(List<Photo> photos) {
        List<Photo> photoList = imageRepository.saveAll(photos);
        return photoList.size() + " images stored successfully !!";
    }

    private String deleteImages(List<Integer> ids) {
        imageRepository.markImagesAsDeleted(0, ids);
        return "Images " + "[" + ids + "]" + " deleted successfully !!";
    }


}
