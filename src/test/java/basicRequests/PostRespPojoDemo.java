package basicRequests;

import java.util.List;

public class PostRespPojoDemo {
	
	private String status;
    private int totalCount;
    private List<PostPojoDemo> posts;

    // Getters and Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public int getTotalCount() { return totalCount; }
    public void setTotalCount(int totalCount) { this.totalCount = totalCount; }
    
    public List<PostPojoDemo> getPosts() { return posts; }
    public void setPosts(List<PostPojoDemo> posts) { this.posts = posts; }
}
