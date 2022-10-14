
public class YoutubeVideo {

	private int videoID;
	private String videoTitle;
	private String videoLink;
	
	public YoutubeVideo(int videoID, String videoTitle, String videoLink) {
		this.videoID = videoID;
		this.videoTitle = videoTitle;
		this.videoLink = videoLink;
	}
	
	
	public int getVideoID() {
		return videoID;
	}
	public void setVideoID(int videoID) {
		this.videoID = videoID;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	
}

//=====================================================================================================

public interface Subject {

	public void register(Observer observer);

	public void unregister(Observer observer);

	public void notifyObserver(int videoID, String videoTitle, String videoLink);

}

//=====================================================================================================

import java.util.ArrayList;

public class YoutubeChannel implements Subject {

	private ArrayList<Observer> subscribers;
	private ArrayList<YoutubeVideo> videos;

	public YoutubeChannel() {
		subscribers = new ArrayList<Observer>();
		videos = new ArrayList<YoutubeVideo>();
	}

	public void register(Observer newObserver) {
		subscribers.add(newObserver);
	}

	public void unregister(Observer deleteObserver) {
		int observerIndex = subscribers.indexOf(deleteObserver);
		System.out.println("Observer " + (observerIndex + 1) + " deleted");
		subscribers.remove(observerIndex);

	}

	public void uploadVideo(YoutubeVideo newVideo) {
		this.videos.add(newVideo);
		notifyObserver(newVideo.getVideoID(), newVideo.getVideoTitle(), newVideo.getVideoLink());
	}

	public void notifyObserver(int videoID, String videoTitle, String videoLink) {

		for (Observer observer : subscribers) {
			observer.update(videoID, videoTitle, videoLink);
		}

	}

}

//=====================================================================================================

public interface Observer {

	public void update(int videoID, String videoTitle, String videoLink);

}

//=====================================================================================================

public class YoutubeSubscriber implements Observer {

	private static int subscriberIDTracker = 0;
	private int subscriberID;
	private Subject youtubeChannel;

	public YoutubeSubscriber(Subject channel) {
		this.subscriberIDTracker++;
		this.youtubeChannel = channel;
		this.subscriberID = this.subscriberIDTracker;
		System.out.println("============================================");
		System.out.println("\tTotal Subscribers:\t" + this.subscriberID);
		System.out.println("============================================\n");
		youtubeChannel.register(this);
	}

	@Override
	public void update(int videoID, String videoTitle, String videoLink) {
		System.out.println("ID:\t" + videoID + "\nTitle:\t" + videoTitle + "\nLink\t" + videoLink + "\n");
	}

}

//=====================================================================================================

public class DemoClass {
	public static void main(String[] args) {

		
		YoutubeChannel channel = new YoutubeChannel();
		
		YoutubeSubscriber subscriber1 = new YoutubeSubscriber(channel);

		YoutubeVideo video1 = new YoutubeVideo(1,"JS","www.youtube.com/dwqwkdwq");
	
		channel.uploadVideo(video1);
		
		YoutubeSubscriber subscriber2 = new YoutubeSubscriber(channel);

		YoutubeVideo video2 = new YoutubeVideo(2,"CSS","www.youtube.com/qdeercfq");
		channel.uploadVideo(video2);

		YoutubeVideo video3 = new YoutubeVideo(3,"React","www.youtube.com/gtergr");
		channel.uploadVideo(video3);

	}
}

//=====================================================================================================
/*


============================================
	Total Subscribers:	1
============================================

ID:	1
Title:	JS
Link	www.youtube.com/dwqwkdwq

============================================
	Total Subscribers:	2
============================================

ID:	2
Title:	CSS
Link	www.youtube.com/qdeercfq

ID:	2
Title:	CSS
Link	www.youtube.com/qdeercfq

ID:	3
Title:	React
Link	www.youtube.com/gtergr

ID:	3
Title:	React
Link	www.youtube.com/gtergr


*/



