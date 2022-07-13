package co.com.dev.backendsocialmedia.service;

import co.com.dev.backendsocialmedia.dto.ImageDto;
import co.com.dev.backendsocialmedia.dto.MessageDto;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommunityService {

    public List<MessageDto> getCommunityMessages(int page) {
        return Arrays.asList(new MessageDto(1L, "First message"),
            new MessageDto(2L, "Second message"));
    }

    public List<ImageDto> getCommunityImages(int page) {
        return Arrays.asList(new ImageDto(1L, "First image", null),
            new ImageDto(2L, "Second image", null));
    }

    public MessageDto postMessage(MessageDto message) {
        return new MessageDto(3L, "First message");
    }

    public ImageDto postImage(MultipartFile file, String title) {
        return new ImageDto(3L, "First image", null);
    }
}
