package com.PCD.ReCraftMarket.dto;

import com.PCD.ReCraftMarket.model.Client.ImageClient;
import com.PCD.ReCraftMarket.model.Client.Role;
import com.PCD.ReCraftMarket.model.Post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    private String userName;
    private String email;
    private String password;
    private String address;
    private Number points;
    private Role roles;
    private ImageClient imageClient;
    private List<Post> postsList = new ArrayList<>();
    private List<Post> LikedPosts = new ArrayList<>();
    private List<Post> favouritePosts = new ArrayList<>();

}
