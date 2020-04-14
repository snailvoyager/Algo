
public class Base62 {
	static final int BASE62 = 59;
	static final String BASE62_ALPHA = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijklmnpqrstuvwxyz123456789";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(encodingUrl(Integer.MAX_VALUE));
		System.out.println(decodingUrl("5sLNAD"));
	}
	
	static public String encodingUrl(int idx) {
		StringBuilder sb = new StringBuilder();
		//Base62 Encoding
		while(idx > 0){
			int i = idx % BASE62;
			idx /= BASE62;
			sb.append(BASE62_ALPHA.charAt(i));
		};
		
		return sb.toString();
	}
	
	/**
	 * URL Decoding
	 * @param shortenUrl
	 * @return
	 */
	static public int decodingUrl(String shortenUrl) {
		int decodingIdx=0;
		int power = 1;
		//Base62 Decoding
		for(int i=0; i<shortenUrl.length(); i++) {
			int digit = BASE62_ALPHA.indexOf(shortenUrl.charAt(i));
			decodingIdx += digit * power;
			power *= BASE62;
		}
		return decodingIdx;
	}
}
