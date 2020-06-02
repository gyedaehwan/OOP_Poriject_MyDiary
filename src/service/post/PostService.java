package service.post;

import controller.Delete;
import controller.Read;
import controller.Update;
import service.post.db.PostDB;
import service.post.service.Create_Post;
import service.post.service.Delete_Post;
import service.post.service.Read_Post;

public class PostService {
	protected PostDB post_service_DB;
	Update update;
	Delete delete;
	Read read;

	public PostService(PostDB postDB) {
		post_service_DB = postDB;
	}

	public void create_post(String postName, String postWriter, String postContents) {
		update = new Create_Post(post_service_DB, postName, postContents, postWriter);
		update.insert();
	}

	public void delete_post(String postName) {
		delete = new Delete_Post(post_service_DB, postName);
		delete.delete();
	}

	public Post read_post(String postName) {
		read = new Read_Post(post_service_DB, postName);
		return (Post) read.read();
	}
}
