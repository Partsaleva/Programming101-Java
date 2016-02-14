package friday;

public class Data {

	private String key;
	private Integer value;
	Data(){
		this.setKey(null);
		this.setValue(null);
		
	}
	Data(String key, Integer value){
		this.setKey(key);
		this.setValue(value);
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
