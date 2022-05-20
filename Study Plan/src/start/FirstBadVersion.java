package start;

public class FirstBadVersion {
	public static void main(String[] args) {

	}
	public int firstBadVersion(int n) {
		int left = 1 , right = n;
		while (left < right){
			int mid = left +  (right - left)/2;
			if(isBadVersion(mid)){
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return left;
	}

	//系统给的，这里只是示意
	private boolean isBadVersion(int version){
		return version <= 50;
	}
}
