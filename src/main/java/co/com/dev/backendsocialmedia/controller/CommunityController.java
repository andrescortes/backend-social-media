package co.com.dev.backendsocialmedia.controller;

import co.com.dev.backendsocialmedia.dto.ImageDto;
import co.com.dev.backendsocialmedia.dto.MessageDto;
import co.com.dev.backendsocialmedia.service.CommunityService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/messages")
    public ResponseEntity<List<MessageDto>> getCommunityMessages(
        @RequestParam(value = "page", defaultValue = "0") int page) {
        return ResponseEntity.ok(communityService.getCommunityMessages(page));
    }

    @GetMapping("/images")
    public ResponseEntity<List<ImageDto>> getCommunityImages(
        @RequestParam(value = "page", defaultValue = "0") int page
    ) {
        return ResponseEntity.ok(communityService.getCommunityImages(page));
    }

    @PostMapping("/messages")
    public ResponseEntity<MessageDto> postCommunityMessages(@RequestBody MessageDto messageDTO) {
        return ResponseEntity.created(URI.create("/community/messages/"))
            .body(communityService.postMessage(messageDTO));
    }

    @PostMapping("/images")
    public ResponseEntity<ImageDto> postCommunityImages(
        @RequestParam MultipartFile file,
        @RequestParam(value = "title") String title
    ) {
        return ResponseEntity.created(URI.create("/community/images/"))
            .body(communityService.postImage(file, title));
    }
}
