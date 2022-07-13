package co.com.dev.backendsocialmedia.service;

import co.com.dev.backendsocialmedia.dto.ImageDto;
import co.com.dev.backendsocialmedia.dto.MessageDto;
import co.com.dev.backendsocialmedia.dto.ProfileDto;
import co.com.dev.backendsocialmedia.dto.SignUpDto;
import co.com.dev.backendsocialmedia.dto.UserDto;
import co.com.dev.backendsocialmedia.dto.UserSummaryDto;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public ProfileDto getProfile(Long userId) {
        return new ProfileDto(new UserSummaryDto(1L, "Sergio", "Lema"),
            Arrays.asList(new UserSummaryDto(2L, "John", "Doe")),
            Arrays.asList(new MessageDto(1L, "My message")),
            Arrays.asList(new ImageDto(1L, "Title", null)));
    }

    public void addFriend(Long friendId) {
        // nothing to do at the moment
    }

    public List<UserSummaryDto> searchUsers(String term) {
        return Arrays.asList(new UserSummaryDto(1L, "Sergio", "Lema"),
            new UserSummaryDto(2L, "John", "Doe"));
    }

    public UserDto signUp(SignUpDto user) {
        return new UserDto(1L, "Sergio", "Lema", "login", "token");
    }

    public void signOut(UserDto user) {
        // nothing to do at the moment
    }
}
